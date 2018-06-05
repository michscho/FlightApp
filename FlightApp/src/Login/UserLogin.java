package Login;

import Data.Classes.User;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;
import javafx.util.Pair;

import java.util.Optional;

public class UserLogin {

    Dialog<Pair<String, String>> dialog;

    public void createUserLogin() {
        // Create the custom dialog.
        dialog = new Dialog<>();
        dialog.setTitle("Login FlightApp");
        dialog.setHeaderText("Log in or register for the FlightApp!");

        // Set the icon (must be included in the project).
        ImageView imageView = new ImageView("file:///" +System.getProperty("user.dir") + "\\resources\\pictures\\userlogin.jpg");
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        dialog.setGraphic(imageView);
        ;

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);


        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            if (username.getText().length() > 6 && !username.getText().contains("   ")) {
                loginButton.setDisable(newValue.trim().isEmpty());
            } else {
                loginButton.setDisable(true);
                }
        });

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            System.exit(0);
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();


        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            User.setUsername(usernamePassword.getKey());
        });

    }




}

