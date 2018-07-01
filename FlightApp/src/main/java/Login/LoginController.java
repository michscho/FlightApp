package Login;

import Data.Database.DataManager;
import MainScreen.Main;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    public static String globalUserName;


    /**
     * Sign in if password is correct
     *
     * @throws Exception
     */
    public void signInPressed() throws Exception {
        if (DataManager.checkPassword(username.getText(),password.getText())){
            globalUserName = username.getText();
            Main main = new Main();
            main.start(Login.stage);
        }

    }


}
