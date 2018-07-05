package Data.Classes;

import Login.LoginController;

public class User {

    private User(){
    }

    private static String username;

    public static String getUsername() {
        return LoginController.globalUserName;
    }

    public static void setUsername(String name) {
        username = name;
    }
}
