package za.ac.tut.pizzashopwindows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PizzaShopWindows extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{

            // load window layout
            Parent root = FXMLLoader.load(getClass().getResource("../buywindow/buyWindowLayout.fxml"));

            // set root onto scene, but let fxml control the size of the application
            Scene scene = new Scene(root);

            // apply styling through css
            scene.getStylesheets().add(getClass().getResource("../appStyling.css").toExternalForm());

            // set scene onto stage and show it
            primaryStage.setScene(scene);
            primaryStage.setTitle("OOPAs Pizza Shop");
            primaryStage.show();
        }
}
