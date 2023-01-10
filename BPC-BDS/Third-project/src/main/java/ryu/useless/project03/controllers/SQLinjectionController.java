package ryu.useless.project03.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.api.SQLinjectionView;
import ryu.useless.project03.data.PersonRepository;
import ryu.useless.project03.services.PersonService;
import javafx.event.ActionEvent;

import java.util.List;

public class SQLinjectionController {

    @FXML
    private TableColumn<SQLinjectionView, String> capy2TableColumn;

    @FXML
    private TableColumn<SQLinjectionView, String> capyTableColumn;

    @FXML
    private TextField queryTextField;

    @FXML
    private TableView<SQLinjectionView> tableThing;

    @FXML
    private Button withPreparedStatementButton;

    @FXML
    private Button withoutPreparedSatement;

    @FXML
    private Button refreshButton;
    @FXML
    private TextField dummTextField;

    private PersonService personService;
    private PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(SQLinjectionController.class);

    @FXML
    private void initialize() {
        personRepository = new PersonRepository();
        personService = new PersonService(personRepository);

        capyTableColumn.setCellValueFactory(new PropertyValueFactory<SQLinjectionView, String>("capybara1"));
        capy2TableColumn.setCellValueFactory(new PropertyValueFactory<SQLinjectionView, String>("capybara2"));

        ObservableList<SQLinjectionView> observableSQLList = initializeSQLData();
        tableThing.setItems(observableSQLList);
        tableThing.getSortOrder().add(capy2TableColumn);

        logger.info("SQLinjectionController initialized");
    }

    private ObservableList<SQLinjectionView> initializeSQLData() {
        List<SQLinjectionView> sql = personService.getSQLbasicView();
        return FXCollections.observableArrayList(sql);
    }
    @FXML
    void onActionF5(ActionEvent event) {
        ObservableList<SQLinjectionView> observableSQLList = initializeSQLData();
        tableThing.setItems(observableSQLList);
        tableThing.refresh();
        tableThing.sort();
    }
    @FXML
    void onActionNOpreparedStatement(ActionEvent event) {
        logger.info("SQLinjectionController starting no prepared statement");

        String input = dummTextField.getText();
        personService.sqlAttack(input); //will break the popup down

        Stage stage = (Stage) withoutPreparedSatement.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onActionPreparedStatement(ActionEvent event) {
        logger.info("SQLinjectionController starting prepared statement");

        String input = dummTextField.getText();
        personService.sqlAttackPRMMNTSTMNT(input);

        //does not need to be closed, because than we will try to do no prepared statement

    }

}
