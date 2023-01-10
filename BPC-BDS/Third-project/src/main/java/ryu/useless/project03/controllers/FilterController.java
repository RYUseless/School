package ryu.useless.project03.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.api.PersonFilterView;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.services.PersonService;

import java.util.List;

public class FilterController {

    @FXML
    private TableColumn<PersonFilterView, String> cityColumn;

    @FXML
    private TableColumn<PersonFilterView, String> emailTableColumn;

    @FXML
    private TableColumn<PersonFilterView, Long> idTableColumn;

    @FXML
    private TableColumn<PersonFilterView, String> nameTableColumn;

    @FXML
    private TableColumn<PersonFilterView, Long> phonenumberColumn;
    @FXML
    private TableColumn<PersonFilterView, String> surnameTableColumn;

    @FXML
    private TableView<PersonFilterView> filterView;

    @FXML
    private Button submitTextField; //should be submitButton

    @FXML
    private TextField filterTextField;

    private PersonService personService;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    @FXML
    private void initialize() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

        idTableColumn.setCellValueFactory(new PropertyValueFactory<PersonFilterView, Long>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<PersonFilterView, String>("name"));
        surnameTableColumn.setCellValueFactory(new PropertyValueFactory<PersonFilterView, String>("surname"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<PersonFilterView, String>("email"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<PersonFilterView, String>("city"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<PersonFilterView, Long>("phoneNumber"));

        filterTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && !(filterTextField.getText().equals(""))) {
                filterByName(filterTextField.getText());
            }
        });

        logger.info("FilterController initiliazed");
    }
    private ObservableList<PersonFilterView> initializePersonsData(String name) {
        List<PersonFilterView> persons = personService.getFilterThing(name);
        return FXCollections.observableArrayList(persons);
    }

    @FXML
    void clickedOnAction(ActionEvent event) {
        String name = filterTextField.getText();
        if(!name.equals("")){
            filterByName(name);
        } else {
            logger.info("FilterController: Bad user input");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("E R R O R ");
            alert.setHeaderText("User Input error!");
            alert.setContentText("You need to add the name!");
            alert.showAndWait();
        }

    }
    private void filterByName(String name){
        ObservableList<PersonFilterView> observablePersonsList = initializePersonsData(name);
        filterView.setItems(observablePersonsList);
        filterView.getSortOrder().add(idTableColumn);
    }

}

