package Alerts;

import Data.Database.DataManager;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;


public class LoginAlerts {

    /**
     *
     * @param headerText
     */
    public static void getLoginAlert(String headerText){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("Pictures/userlogin.jpg"));
        alert.setTitle("Login failed");
        alert.setHeaderText(headerText);
        alert.setContentText("Sign Up or try again!");
        alert.showAndWait();
    }

    public static void getSignUpAlert(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Sign Up");
        dialog.setHeaderText("Choose a password and a username");

        //dialog.setGraphic(new ImageView("Pictures/userlogin.jpg"));

// Set the button types.
        ButtonType signUpButtonType = new ButtonType("Sign Up", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(signUpButtonType, ButtonType.CANCEL);
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("Pictures/userlogin.jpg"));

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("username");
        PasswordField password = new PasswordField();
        password.setPromptText("password");
        PasswordField password2 = new PasswordField();
        password2.setPromptText("confirm password");



        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);
        grid.add(new Label("Confirm Password:"), 0, 2);
        grid.add(password2, 1, 2);

// Enable/Disable login button depending on whether a username was entered.
        Node signUpButton = dialog.getDialogPane().lookupButton(signUpButtonType);
        signUpButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            signUpButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == signUpButtonType) {
                if (!password.getText().equals(password2.getText())){
                    return new Pair<>("passwordDiffer","passwordDiffer");
                }
                else if (password.getText().length() < 5){
                    return new Pair<>("tooShort","tooShort");
                }
                try {
                    DataManager.safeUserData(username.getText(),password.getText());
                    System.out.println("Safed userData");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        dialog.showAndWait().ifPresent(result -> {
            if (result.getKey().equals("passwordDiffer")){
                passwordsDiffer();
            }
            else if (result.getKey().equals("tooShort")){
                passwordTooShort();
            }
            else {
                newAccount();
            }
        });



    }

    public static void passwordsDiffer(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("Pictures/userlogin.jpg"));
        alert.setTitle("Sign Up failed");
        alert.setHeaderText("Passwords doesn't match");
        alert.setContentText("Passwords doesn't match");
        alert.showAndWait();
    }

    public static void passwordTooShort(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("Pictures/userlogin.jpg"));
        alert.setTitle("Sign Up failed");
        alert.setHeaderText("Passwords is too short");
        alert.setContentText("Passwords is too short");
        alert.showAndWait();
    }

    public static void newAccount(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("Pictures/userlogin.jpg"));
        alert.setTitle("Sign Up complete");
        alert.setHeaderText("new Account was created ");
        alert.setContentText("new Account was created");
        alert.showAndWait();
    }

}
