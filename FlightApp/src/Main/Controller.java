package Main;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDateTime;

public class Controller {

    @FXML
    private Label dateLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private DatePicker inputField;


    /**
     *
     *  TODO more Fields and more actions
     *
     */

    public void searchButtonClicked(){
        inputField.getEditor().getText();
        // TODO Linking to Table
    }


    public void menuAboutFlightAppClicked(){
        // TODO Small Frame with some Information
    }

    public void menuSettingsClicked(){
        // TODO Setting Frame, for example: Toggle: Search with Case Sensitive
    }

    public void menuUserClicked(){
// TODO Display UserInformation
    }

    public void menuQuitClicked(){
        Platform.exit();
    }

    public void hyperlinkClicked(){
// TODO Link to Safety Video
    }

}
