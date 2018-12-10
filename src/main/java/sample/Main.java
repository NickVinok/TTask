package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Model.TransportModel;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

            //Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
            primaryStage.setTitle("Hello World");
            //primaryStage.setScene(new Scene(root, 300, 275));
            //primaryStage.show();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            var root =(VBox) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();


            Controller c = loader.getController();
            c.setMOdel(new TransportModel());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
