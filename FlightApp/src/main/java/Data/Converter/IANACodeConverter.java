package Data.Converter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

            br = new BufferedReader(new InputStreamReader(airportCSV.openStream(),"UTF8"));
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

            br = new BufferedReader(new InputStreamReader(airportCSV.openStream(),"UTF8"));
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


    /**
     * @return String with all IANA Codes and city names
     * @throws IOException
     */
    public static String[] getAllAttributes() throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(airportCSV.openStream(),"UTF8"));
            while ((line = br.readLine()) != null) {

                String[] country = line.split(cvsSplitBy);
                for (int i = 0; i < country.length; i++) {
                    list.add(country[i]);
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

        return list.toArray(new String[0]);
    }


}





