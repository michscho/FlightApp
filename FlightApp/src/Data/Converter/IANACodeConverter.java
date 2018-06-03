package Data.Converter;


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

    public static String IANAToCity(String IANACode){
        // TODO
        return"";
    }

    public static String[] flatten(String[][] data) {
        ArrayList<String> list = new ArrayList<String>();

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++){
                list.add(data[i][j]);
            }
        }

        return list.toArray(new String[0]);
    }

    public static String[] getAllAttribues() throws IOException {
        CSVParser csvParser = new CSVParser( new FileInputStream(System.getProperty("user.dir") + "/resources/data/AirportToIANACode.csv") );
        String[][] data = csvParser.getAllValues();
       return flatten(data);

    }


}
