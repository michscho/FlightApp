package Login;

import Data.Database.DataManager;
import MainScreen.Main;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.awt.*;

public class LoginController {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    public static String globalUserName;


    public void closePressed(){
        Platform.exit();
    }

    public void signInPressed() throws Exception {
        if (DataManager.checkPassword(username.getText(),password.getText())){
            globalUserName = username.getText();
            Main main = new Main();
            main.start(Login.stage);
        }

    }


}
