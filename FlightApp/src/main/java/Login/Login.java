package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {

    private static Stage stage;

    /**
     * Creates Scene
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("UserLoginFrame.fxml"));
        Parent mainLayout = loader.load();
        primaryStage.getIcons().add(new Image("pictures/plane.png"));
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        setStage(primaryStage);
    }

     private static void setStage(Stage primaryStage){
        stage = primaryStage;
    }

    public static Stage getStage(){
        return stage;
    }


}
