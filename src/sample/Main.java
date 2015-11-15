package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage gt;


    @Override
    public void start(Stage primaryStage) throws Exception{
        gt=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Editor");
        primaryStage.setScene(new Scene(root, 700, 875));
        primaryStage.show();



    }





    public static void main(String[] args) {
        launch(args);


    }


}


