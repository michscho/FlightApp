package Login;

import Data.Database.DataManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoginTest {

    @Test
    public void loginTest() throws Exception {
        assertEquals(false,DataManager.checkPassword("asdfad","asdfdf"));
        assertEquals(false,DataManager.checkPassword("HalloWelt","HalloWelt"));
        assertEquals(false,DataManager.checkPassword("",""));
        DataManager.safeUserData("Michael","12345");
        assertEquals(true, DataManager.checkPassword("Michael","12345"));
    }

}
