package ryu.useless.project03.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.FakeMain;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.exceptions.DataAccessException;
import ryu.useless.project03.services.AuthenticationService;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button SubmitButton;

    @FXML
    private Label loginLabel;

    @FXML
    private ImageView logo;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;

    private PersonRepository personRepository;
    private AuthenticationService authenticationService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @FXML
    private void initialize(){ //When enter pressed in text/password fields is pressed
        initializeServices();
        usernameTextField.setOnKeyPressed(event -> { //username text field trigger
            if (event.getCode() == KeyCode.ENTER) {
                LoginVerification();
            }
        });
        passwordTextField.setOnKeyPressed(event -> { //password text field trigger
            if (event.getCode() == KeyCode.ENTER && usernameTextField.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username not specified");
                alert.setHeaderText("Error: 0x0069xxxUserInputError");
                alert.setContentText("You need to provide username and password!");
                alert.showAndWait();
            }
            else if (event.getCode() == KeyCode.ENTER && !usernameTextField.getText().equals("")) {
                LoginVerification();
            }
        });
        logger.info("LoginController initialized");
    }
    public LoginController() {
    }
    private void initializeServices() {
        personRepository = new PersonRepository();
        authenticationService = new AuthenticationService(personRepository);
    }

    @FXML
    void submitActionHandler(ActionEvent event) { //when sign in button pressed
        LoginVerification();
    }
    private void LoginVerification(){
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        try {
            boolean authenticated = authenticationService.authenticate(username, password);
            if (authenticated) {
                MainWindow();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong login");
                alert.setHeaderText("Error: 0x0070xxxUserBadLogin");
                alert.setContentText("You need to provide correct username and password!");
                alert.showAndWait();
                logger.info("Incorrect password or username");
            }
        } catch (DataAccessException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
        }
    }
    private void MainWindow() { //with popup alert and closing login gui
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/App.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
            Stage stage = new Stage();
            stage.setTitle("Main App");
            stage.setScene(scene);
            stage.setResizable(false);
            Stage stageOld = (Stage) SubmitButton.getScene().getWindow();
            stageOld.close(); //closing login gui

            stage.show(); //show app gui
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login successful");
        alert.setHeaderText("Login successful!");
        alert.setContentText("Did you know that the capybara is the world's largest living rodent..");

        Timeline idlestage = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                alert.setResult(ButtonType.CANCEL);
                alert.hide();
            }
        }));
        idlestage.setCycleCount(1);
        idlestage.play();
        alert.showAndWait();
    }
}
