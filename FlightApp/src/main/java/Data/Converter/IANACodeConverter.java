package Data.Converter;

import Util.StringUtil;
import com.Ostermiller.util.CSVParser;

import java.io.IOException;
import java.net.URL;

public class IANACodeConverter {

    private static final URL airportCSV = IANACodeConverter.class.getResource("AirportToIANACode.csv");

    public static CSVParser getCSVParser(){
        try {
            return new CSVParser(airportCSV.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param cityName
     * @return
     * @throws IOException
     */
    public static String getIANACode(String cityName) throws IOException {
        if (cityName == null || cityName.equals("")) {
            return Error.NULL_OR_EMPTY.toString();
        }
        CSVParser csvParser = getCSVParser();
        for (String t; (t = csvParser.nextValue()) != null; ) {
            if (t.contains(cityName)) {
                String s1 = csvParser.nextValue();
                String s2 = csvParser.nextValue();
                if (s2.length() == 3) {
                    return s2;
                } else if (s1.length() == 3) {
                    return s1;
                }
            }

        }
        csvParser.close();
        return Error.INVALID_CITY_NAME.toString();
    }

    /**
     * @param IANACode
     * @return
     * @throws IOException
     */
    public static String IANAToCity(String IANACode) throws IOException {
        CSVParser csvParser = getCSVParser();
        while (csvParser.getLastLineNumber() < 9020) {
            String t1 = csvParser.nextValue();
            String t2 = csvParser.nextValue();
            if (IANACode.equals(t2)) {
                return t1;
            }
        }
        csvParser.close();
        return Error.INVALID_IANA_CODE.toString();
    }


    /**
     * @return String with all IANA Codes and city names
     * @throws IOException
     */
    public static String[] getAllAttributes() throws IOException {
        CSVParser csvParser = getCSVParser();
        String[][] data = csvParser.getAllValues();
        return StringUtil.flatten(data);

    }

    public enum Error {
        NULL_OR_EMPTY {
            @Override
            public String toString() {
                return "no input or null";
            }
        },
        INVALID_CITY_NAME {
            @Override
            public String toString() {
                return "invalid City Name";
            }
        },
        INVALID_IANA_CODE {
            @Override
            public String toString() {
                return "invalid IANACode";
            }

        }
    }


}


