package Data.Converter;

import Util.StringUtil;
import com.Ostermiller.util.CSVParser;

import java.io.*;
import java.net.URL;

public class IANACodeConverter {

    private static final URL airportCSV = IANACodeConverter.class.getResource("AirportToIANACode.csv");


    /**
     * @param cityName
     * @return
     * @throws IOException
     */
    public static String getIANACode(String cityName) throws IOException {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(airportCSV.openStream()));
            while ((line = br.readLine()) != null) {

                String[] country = line.split(cvsSplitBy);
                for (int i = 0; i < country.length; i++) {
                    if (country[i].equals(cityName)) {
                        if (cityName.contains("Airport"))
                        {
                            return country[i + 2];
                        } else {
                            return country[i + 1];
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return cityName;

    }

    /**
     * @param IANACode
     * @return
     * @throws IOException
     */
    public static String IANAToCity(String IANACode) throws IOException {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(airportCSV.openStream()));
            while ((line = br.readLine()) != null) {

                String[] country = line.split(cvsSplitBy);
                for (int i = 0; i < country.length; i++) {
                    if (country[i].equals(IANACode)) {
                        return country[i - 1];
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return IANACode;

    }


    public static CSVParser getCSVParser(){
        try {
            return new CSVParser(airportCSV.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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


}





