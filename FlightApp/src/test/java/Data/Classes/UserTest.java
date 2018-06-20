package Data.Classes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserClass(){
        User test1 = new User();
        test1.setUsername("Test_User1");

        assertEquals("Test_User1", test1.getUsername());
    }

}
