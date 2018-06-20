package Util;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {


        @Test
        public void testStringUtil() throws Exception{

            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add("1");

            String[][] tmp2 = new String[1][1];
            tmp2[0][0] = "1";

           assertEquals(tmp, StringUtil.flatten(tmp2));
        }



}
