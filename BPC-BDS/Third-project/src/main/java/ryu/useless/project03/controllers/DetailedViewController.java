package ryu.useless.project03.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.api.PersonDetailedView;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.services.PersonService;

public class DetailedViewController {

    @FXML
    private TextField cityTextField;

    @FXML
    private Button editButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phonenumberTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private Button submitButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField zipcodeTextField;
    private PersonService personService;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(DetailedViewController.class);
    public Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() { //do not delete!
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

        nameTextField.setEditable(false);
        surnameTextField.setEditable(false);
        emailTextField.setEditable(false);
        phonenumberTextField.setEditable(false);
        cityTextField.setEditable(false);
        zipcodeTextField.setEditable(false);
        streetTextField.setEditable(false);

        loadPersonsData();
        logger.info("DetailedViewController Initialized");
    }
    private void loadPersonsData() {
        Stage stage = this.stage;
        if (stage.getUserData() instanceof PersonDetailedView) {
            PersonDetailedView personDetailedView = (PersonDetailedView) stage.getUserData();
            nameTextField.setText(personDetailedView.getName());
            surnameTextField.setText(personDetailedView.getSurname());
            emailTextField.setText(personDetailedView.getEmail());
            phonenumberTextField.setText(String.valueOf(personDetailedView.getPhoneNumber()));
            cityTextField.setText(personDetailedView.getCity());
            zipcodeTextField.setText(String.valueOf(personDetailedView.getZipCode()));
            streetTextField.setText(personDetailedView.getStreet());
        }

    }

}
