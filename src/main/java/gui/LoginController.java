package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.security.auth.login.LoginException;

/**
 * Controller class for GUI element methods in Login Scene.
 * @author Jani Uotinen
 */
public class LoginController {
    @FXML
    private Label errorLabel;
    @FXML
    private PasswordField inputToken;

    //Variables for moving the window.
    double x,y;

    /**
     * Login button method. Tries to launch JDA bot instance with the inserted token.
     * @author Jani Uotinen
     */
    @FXML
    public void login(ActionEvent actionEvent){
        String token = inputToken.getText();

        try {
            botti.Botti.launchBot(token);
        } catch (LoginException logex) {
            errorLabel.setText("Wrong token. Please try again.");
            inputToken.setText("");
            logex.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Launching the bot caused an Exception.");
        }

    }

    /**
     * Exit button method. Exits the program and bot goes offline.
     * @author Jani Uotinen
     */
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Scene method. Causes the window to move according to mouse drag.
     * @author Jani Uotinen
     */
    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }

    /**
     * Scene method. Gets coordinates from clicking the mouse on scene.
     * @author Jani Uotinen
     */
    @FXML
    void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }

    /**
     * Creates a new Scene and switches to it.
     * @author Jani Uotinen
     * */
    @FXML
    public void changeToScene2() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/scene2.fxml"));
        Stage window = (Stage) errorLabel.getScene().getWindow();
        Scene scene2 = new Scene(root, 750, 500);
        scene2.getStylesheets().add(getClass().getResource("/css/scene2.css").toExternalForm());
        window.setScene(scene2);
        root.requestFocus();
    }
}
