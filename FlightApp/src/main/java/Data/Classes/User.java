package Data.Classes;

import Login.LoginController;

public class User {

    private static String username;
    private static String password;

    public static String getUsername() {
        return LoginController.globalUserName;
    }

    public static void setUsername(String name) {
        username = name;
    }
}
