package Data.Converter;


import Util.StringUtil;
import com.Ostermiller.util.CSVParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class IANACodeConverter {

    public static String getIANACode(String cityName) throws IOException {
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

    public static String IANAToCity(String IANACode) throws  IOException{
        CSVParser csvParser = new CSVParser( new FileInputStream(System.getProperty("user.dir") + "/resources/data/AirportToIANACode.csv") );
        for ( String t; (t = csvParser.nextValue()) != null; ) {
            if (t.equals(IANACode)){
                String s1 = csvParser.getLine()[1];
                return s1;
            }
        }
        return "";
    }


    public static String[] getAllAttributes() throws IOException {
        CSVParser csvParser = new CSVParser( new FileInputStream(System.getProperty("user.dir") + "/resources/data/AirportToIANACode.csv") );
        String[][] data = csvParser.getAllValues();
       return StringUtil.flatten(data);

    }


}
