package main.java.Converter.Data;

import main.java.Data.Converter.IANACodeConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class IANACodeConverterTest {

    @Test
    public void testGetIANACodeBasic() throws IOException {
        assertEquals("FRA", IANACodeConverter.getIANACode("Frankfurt")) ;
        assertEquals("IST", IANACodeConverter.getIANACode("Istanbul")) ;
        assertEquals("SOF", IANACodeConverter.getIANACode("Sofia")) ;

    }

    @Test
    public void testGetIANACodeSpecial() throws IOException {
        String randomString = "sidjx";
        for (int i = 0; i < 10; i++) {
            assertEquals(IANACodeConverter.Error.INVALID_CITY_NAME.toString(), IANACodeConverter.getIANACode(randomString));
            randomString += 3;
        }
        assertEquals(IANACodeConverter.Error.NULL_OR_EMPTY.toString(), IANACodeConverter.getIANACode(""));
        assertEquals(IANACodeConverter.Error.NULL_OR_EMPTY.toString(), IANACodeConverter.getIANACode(null));
    }

//    @Test
//    public void testGetIANAtoCity() throws IOException {
//        assertEquals("Frankfurt", IANACodeConverter.IANAToCity("FRA")) ;
//        assertEquals("Istanbul", IANACodeConverter.IANAToCity("IST")) ;
//        assertEquals("Sofia", IANACodeConverter.IANAToCity("SOF")) ;
//
//    }

}
