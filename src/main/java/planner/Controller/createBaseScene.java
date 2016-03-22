package planner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import planner.GUI.Main;
import planner.Util.databaseConnection;

import java.sql.SQLException;

/**
 *
 * Created by mchemingway0031 on 3/1/2016.
 */
public class createBaseScene
{
    @FXML private MenuItem closeButton;
    @FXML private MenuItem logOutButton;
    @FXML private MenuItem addNewClientButton;

    @FXML
    private void initialize()
    {
        if(!databaseConnection.connected)
        {
            databaseConnection.connectToDatabase();
        }

        closeButton.setOnAction(event -> {
            try {
                databaseConnection.connection.close();
                System.exit(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        logOutButton.setOnAction(event -> {
            try {
                Main main = new Main();
                main.closeStage();
                main.setFXML("log_in.fxml");
                main.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addNewClientButton.setOnAction(event -> {
            try {
                Main main = new Main();
                main.closeStage();
                main.setFXML("create_client.fxml");
                main.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}