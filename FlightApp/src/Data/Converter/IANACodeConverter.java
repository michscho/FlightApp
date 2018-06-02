package Data.Converter;


import com.Ostermiller.util.CSVParser;

import java.io.FileInputStream;
import java.io.IOException;

public class IANACodeConverter {

    public String getIANACode(String cityName) throws IOException {
        CSVParser csvParser = new CSVParser( new FileInputStream(System.getProperty("user.dir") + "/resources/data/AirportToIANACode.csv") );
        for ( String t; (t = csvParser.nextValue()) != null; ) {
            if (t.contains(cityName)){
                String s1 = csvParser.nextValue();
                String s2 = csvParser.nextValue();
                if (s2.length() == 3){
                    return s2;
                }
                else if (s1.length() == 3){
                    return s1;
                }
            }

        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        IANACodeConverter con = new IANACodeConverter();
        System.out.println(con.getIANACode("Washington"));
    }

}
