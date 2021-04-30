package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Kontrolleri-luokka GUI-elementtien metodeille.
 * @author Jani Uotinen
 */
public class LoginController {
    @FXML
    private Label errorLabel;
    @FXML
    private PasswordField inputToken;

    double x,y;

    @FXML
    public void login(ActionEvent actionEvent){
        String token = inputToken.getText();

        try {
            botti.Botti.launchBot(token);
        } catch (Exception e) {
            errorLabel.setText("Väärä token. Yritä uudelleen");
            inputToken.setText("");
        }

        //String input = inputToken.getText();
        //errorLabel.setText(input);
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }
}
