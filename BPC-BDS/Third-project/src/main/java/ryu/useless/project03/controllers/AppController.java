package ryu.useless.project03.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.FakeMain;
import ryu.useless.project03.api.PersonBasicView;
import ryu.useless.project03.api.PersonDetailedView;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.services.PersonService;
import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private Button RefreshButton; //useless, cause i have action event

    @FXML
    private Button SearchButton; //use later

    @FXML
    private MenuItem addPerson;

    @FXML
    private MenuItem capyBlapy;

    @FXML
    private MenuItem deletePerson;

    @FXML
    private MenuItem dummySqlAttack;

    @FXML
    private MenuItem helpMe;

    @FXML
    private MenuItem sqkAttack;
    @FXML
    private MenuItem editPerson;

    @FXML
    private MenuItem SearchItemMenu;

    @FXML
    private Label findByEmailLabel; //useless

    @FXML
    private TableView<PersonBasicView> menuBar;

    @FXML
    private TableColumn<PersonBasicView, String> personCity;

    @FXML
    private TableColumn<PersonBasicView, String> personEmail;

    @FXML
    private TableColumn<PersonBasicView, Long> personID;

    @FXML
    private TableColumn<PersonBasicView, String> personName;

    @FXML
    private TableColumn<PersonBasicView, Long> personPhoneNumber;

    @FXML
    private TableColumn<PersonBasicView, String> personSurname;

    @FXML
    private TextField textField;
    private PersonService personService;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    @FXML
    private void initialize() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

        personID.setCellValueFactory(new PropertyValueFactory<PersonBasicView, Long>("id"));
        personName.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("name"));
        personSurname.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("surname"));
        personEmail.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("email"));
        personCity.setCellValueFactory(new PropertyValueFactory<PersonBasicView, String>("city"));
        personPhoneNumber.setCellValueFactory(new PropertyValueFactory<PersonBasicView, Long>("phoneNumber"));

        ObservableList<PersonBasicView> observablePersonsList = initializePersonsData();
        menuBar.setItems(observablePersonsList);
        menuBar.getSortOrder().add(personID);

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && !(textField.getText().equals(""))) {
                openDetailedView();
            }
        });

        menuItems();
        logger.info("AppControoler initiliazed");
    }

    @FXML
    void refresButtonAction(ActionEvent event) {
        ObservableList<PersonBasicView> observablePersonsList = initializePersonsData();
        menuBar.setItems(observablePersonsList);
        menuBar.refresh();
        menuBar.sort();
    }

    @FXML
    void searchButtonAction(ActionEvent event) {
        if(!textField.getText().equals("")){
            openDetailedView();
        }
    }

    private ObservableList<PersonBasicView> initializePersonsData() {
        List<PersonBasicView> persons = personService.getPersonsBasicView();
        return FXCollections.observableArrayList(persons);
    }

    void menuItems() {
        addPerson.setOnAction((ActionEvent event) -> { //add person
            logger.info("AppController: Starting AddPersonController");
            openAddWindow();
        });
        deletePerson.setOnAction((ActionEvent event) -> { //delete person
            logger.info("AppController: Starting DeletePersonController");
            openDeleteWindow();
        });
        editPerson.setOnAction((ActionEvent event) -> { //edit person
            logger.info("AppController: Starting EditPersonController");
            openEditWindow();
        });
        sqkAttack.setOnAction((ActionEvent event) -> { //SQL attack
            logger.info("AppController: Starting SQLinjectionController");
            openSQLwindow();
        });
        dummySqlAttack.setOnAction((ActionEvent event) -> { //dummy SQL attack
            logger.info("AppController: Starting SQLinjectionController");
            openSQLwindow();
        });
        helpMe.setOnAction((ActionEvent event) -> { //HELP option
            logger.info("AppController: Starting Help call to the space!");
            shoHelpWindow();
        });
        capyBlapy.setOnAction((ActionEvent event) -> { //CapyBlapy option
            logger.info("AppController: Capybaras are fantastic swimmers and they can sleep in the water!");
            CapyBlapy();
        });
        SearchItemMenu.setOnAction((ActionEvent event) -> { //search option
            logger.info("AppController: Starting FilterController");
            showSearchWindow();
        });

    }
    public void openAddWindow(){ //add
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/AddPopUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 550, 450); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Add person window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);}
    }
    private void CapyBlapy(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/Capy.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Capybara :)");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);
        }
    }
    private void openDeleteWindow(){ //delete
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/DeletePopUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 300); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Delete person window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);
        }
    }
    private void openEditWindow(){ //edit
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("U NEED TO KNOW THIS");
            alert.setHeaderText("IMPORTANT!");
            alert.setContentText("You need to remember the ID of a person, that u wanna edit!\n UwU");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/EditPopUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Edit person window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);

        }
    }
    public void openSQLwindow(){ //SQL injection
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/SQLinjection.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Main App");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);
        }
    }
    public void openDetailedView(){ //Detailed view
        try {
            String emailos = textField.getText();
            PersonDetailedView personDetailedView = personService.findPersonDetailedView(emailos);
            if(personDetailedView != null){ //this checks, if the query isnt empty
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(FakeMain.class.getResource("FXML/DetailedPopUp.fxml"));
                Stage stage = new Stage();
                stage.setUserData(personDetailedView);
                stage.setTitle("Detailed view");
                DetailedViewController controller = new DetailedViewController();
                controller.setStage(stage);
                fxmlLoader.setController(controller);

                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } else{
                logger.info("could not open the detailed view window, because the query returned nothing");
            }
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);
        }
    }
    private void shoHelpWindow(){ //Help Pop Up
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/Rick.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 465, 400); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Rick will help :)");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);
        }
    }
    private void showSearchWindow(){ //Filter actom
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FakeMain.class.getResource("FXML/FilterPopUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400); //sirka x vyska
            Stage stage = new Stage();
            stage.setTitle("Filter window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            logger.info("Zi error: "+e.getMessage()+"\n cause is: "+e.getCause());
            throw new RuntimeException(e);
        }
    }
}

