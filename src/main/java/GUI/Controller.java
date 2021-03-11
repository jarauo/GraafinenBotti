package GUI;
;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class Controller {
    @FXML
    private Label errorLabel;
    @FXML
    private PasswordField inputToken;

    @FXML
    public void login(ActionEvent actionEvent){
        String token = inputToken.getText();

        try {
            Botti.Botti.launchBot(token);
        } catch (Exception e) {
            errorLabel.setText("Väärä token. Yritä uudelleen");
            inputToken.setText("");
        }

        //String input = inputToken.getText();
        //errorLabel.setText(input);
    }
}
