package ryu.useless.project03.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.api.PersonCreateView;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.services.PersonService;

import java.util.Optional;

public class AddPersonController {
    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label mainLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Label studentLabel;

    @FXML
    private TextField studentTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Label surenameLabel;

    @FXML
    private TextField surenameTextField;
    private PersonService personService;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(AddPersonController.class);
    @FXML
    public void initialize() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

        ValidationSupport validation = new ValidationSupport();
        validation.registerValidator(nameTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(surenameTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(emailTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(studentTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(phoneTextField, Validator.createEmptyValidator("The email must not be empty."));

        submitButton.disableProperty().bind(validation.invalidProperty());
        logger.info("AddPersonController initialized");
    }

    @FXML
    void clickedAction(ActionEvent event) {
        String fullName = "nameError";
        try {
            String name = nameTextField.getText();
            String surnmae = surenameTextField.getText();
            String email = emailTextField.getText();
            String password = studentTextField.getText();
            fullName = name +" "+surnmae;
            int phoneNumber = Integer.parseInt(phoneTextField.getText());

            PersonCreateView personCreateView = new PersonCreateView();
            personCreateView.setName(name);
            personCreateView.setSurename(surnmae);
            personCreateView.setEmail(email);
            personCreateView.setPassword(password);
            personCreateView.setPhoneNumber(phoneNumber);

            personService.createPerson(personCreateView);

            System.out.println(" "+name+" "+surnmae+" "+email+" "+password+" "+phoneNumber);
        } catch (NumberFormatException e){
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            System.out.println("STOOOPID");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROOOOOR!");
            alert.setContentText("ERROOOOOOOOOOOOOOOOOOOOOOR");
            alert.showAndWait();
        }
        Stage stage = new Stage();
        stage = (Stage) submitButton.getScene().getWindow();
        stage.close();

        if(personService.getStatusCreate()){
            endDialog(fullName);
        }
    }
    private void endDialog(String name) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succesfully created person");
        alert.setHeaderText("Congrats!");
        alert.setContentText("You indeed created person by a name: "+name);
        Timeline idlestage = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alert.setResult(ButtonType.CANCEL);
                alert.hide();
            }
        }));
        idlestage.setCycleCount(1);
        idlestage.play();
        alert.show();
    }

}

