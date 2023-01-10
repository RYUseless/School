package ryu.useless.project03.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ryu.useless.project03.config.DataSetupConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePersonController {

    @FXML
    private Button deleteButton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label mainLabel;

    @FXML
    private Label secondLabel;
    private static final Logger logger = LoggerFactory.getLogger(DeletePersonController.class);
    private boolean didItRun;

    @FXML
    private void initialize() {
        logger.info("DeletePersonController Initialized");
    }
    @FXML
    void onClickedAction(ActionEvent event) {
        try{
            long id_pokus = Long.parseLong(idTextField.getText());
            System.out.println(id_pokus);
            removePerson(id_pokus);
        } catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("WHAT MORE DO YOU WANT FROM ME?!");
            alert.setHeaderText("This brokey: \n"+e.getMessage());
            alert.setContentText("This caused it: \n"+e.getCause());
            alert.showAndWait();
        }
    }
    public void removePerson(Long id)
    {
        String remove = "DELETE FROM bds.person WHERE id_person = ?;";
        try (Connection conn = DataSetupConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(remove))
        {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            didItRun = true;
        } catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("WHAT MORE DO YOU WANT FROM ME?!");
            alert.setHeaderText("This brokey: \n"+e.getMessage());
            alert.setContentText("This caused it: \n"+e.getCause());
            alert.showAndWait();
        }

        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
        if (didItRun){ //this will always come true, becuase the query will always run, even if there is noone with id like that
            endDialog(id);
        }
    }
    private void endDialog(Long id) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("DELETE WAS SUCCESFULL");
        alert.setHeaderText("Congrats!");
        alert.setHeaderText("You succesfully deleted zi person with id: "+id);

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

