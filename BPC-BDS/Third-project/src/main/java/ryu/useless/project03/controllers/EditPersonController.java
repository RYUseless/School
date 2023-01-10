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
import ryu.useless.project03.api.PersonEditView;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.services.PersonService;

public class EditPersonController {

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label mainLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label phnNumber;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button submitID;

    @FXML
    private TextField surenameTextField;

    @FXML
    private Label surnameLabel;
    private PersonService personService;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(EditPersonController.class);
    @FXML
    public void initialize() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

        ValidationSupport validation = new ValidationSupport();
        validation.registerValidator(nameTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(surenameTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(emailTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(phoneNumberTextField, Validator.createEmptyValidator("The email must not be empty."));
        validation.registerValidator(idTextField, Validator.createEmptyValidator("The id must not be empty."));

        submitID.disableProperty().bind(validation.invalidProperty());
        logger.info("EditController Initialized");
    }
    @FXML
    void buttonClicked(ActionEvent event) {
        Long id = Long.valueOf(idTextField.getText());
        String name = nameTextField.getText();
        String surname = surenameTextField.getText();
        String email = emailTextField.getText();
        int phoneNumber = Integer.parseInt(phoneNumberTextField.getText());

        PersonEditView personEditView = new PersonEditView();
        personEditView.setID(id);
        personEditView.setName(name);
        personEditView.setSurname(surname);
        personEditView.setEmail(email);
        personEditView.setPhoneNumber(phoneNumber);

        personService.editPerson(personEditView);
        boolean finalStatus = personService.getStatusEdit();
        if(finalStatus){
            endDialog(name);
        }

        Stage stage = (Stage) submitID.getScene().getWindow();
        stage.close();
    }

    private void endDialog(String name) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("EDIT WAS SUCCESFULL");
        alert.setHeaderText("You succesfully edited zi person: "+name);

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


