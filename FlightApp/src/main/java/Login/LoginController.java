package Login;

import Alerts.LoginAlerts;
import Data.Database.DataManager;
import MainScreen.Main;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;


import static Alerts.LoginAlerts.getSignUpAlert;

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
    public void signInPressed()  {

        try {
            if (username.getText().equals("") || password.getText().equals(""))
            {
                LoginAlerts.getLoginAlert("No password or username given!");
            }
            else if (DataManager.checkPassword(username.getText(),password.getText())){
                globalUserName = username.getText();
                Main main = new Main();
                main.start(Login.stage);
            }
            else {
                LoginAlerts.getLoginAlert("Wrong Password or Username!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void signUpPressed() {
        getSignUpAlert();



    }


}
