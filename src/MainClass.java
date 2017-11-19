
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MainClass extends Application 
{
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)throws Exception
    {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("calculator.css");
        primaryStage.setTitle("MyCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
