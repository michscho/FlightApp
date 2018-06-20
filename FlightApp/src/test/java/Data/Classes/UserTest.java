package Data.Classes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserClass(){
        User.setUsername("Test_User1");

        assertEquals("Test_User1", User.getUsername());
    }



}
