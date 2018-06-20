package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {


        @Test
        public void testStringUtil() throws Exception{

            String[] exp = new String[1];
            exp[0] = "test";

            String[][] give = new String[1][1];
            give[0][0] = "test";

           assertArrayEquals(exp, StringUtil.flatten(give));
        }



}
