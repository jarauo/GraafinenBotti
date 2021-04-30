package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Graafisen käyttöliittymän käynnistys.
 * @author Jani Uotinen
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("Discord Bot Dashboard");
        Scene login = new Scene(root,300,275);
        login.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
        primaryStage.setScene(login);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        root.requestFocus();
    }


    public static void main(String[] args) {
        launch(Main.class);
    }

}
