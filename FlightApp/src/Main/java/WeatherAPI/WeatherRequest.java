package WeatherAPI;

import org.json.JSONObject;

import java.net.URL;
import java.util.Scanner;

public class WeatherRequest { // TODO: Array zurückgeben mit lediglich einem Request pro Aufruf

    private static final String APIKey = "39b1bc038434e7c0b3db7e4b96a6afb9";
    public String city;

    public WeatherRequest(String city) {
        this.city = city;
    }

    public static void main(String[] args) {
        WeatherRequest wr = new WeatherRequest("München");
        try {
            System.out.println(wr.tempForecast(16));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String urlBuilder (String url) throws Exception {
        String s = url + this.city + "&APPID=" + this.APIKey;
        return urlReader(new URL(s));
    }

    public String urlReader (URL url) throws Exception {
        Scanner scan = new Scanner(url.openStream());
        String output = new String();
        while (scan.hasNext())
            output += scan.nextLine();
        scan.close();

        return output;
    }

    public String currentWeather () throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/weather?q=");
        JSONObject obj = new JSONObject(url);

        JSONObject weather = obj.getJSONArray("weather").getJSONObject(0);
        return weather.getString("icon");
    }

    public String weatherForecast (int index) throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/forecast?q=");
        JSONObject obj = new JSONObject(url);

        JSONObject res = obj.getJSONArray("list").getJSONObject(index); // 1 Day: index 8; 2 Days: index 16
        return res.getJSONArray("weather").getJSONObject(0).getString("icon");
    }

    public int currentTemp () throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/weather?q=");
        JSONObject obj = new JSONObject(url);

        JSONObject temp = obj.getJSONObject("main");
        int kel = temp.getInt("temp");
        return kel - 273;
    }

    public int tempForecast (int index) throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/forecast?q=");
        JSONObject obj = new JSONObject(url);

        JSONObject res = obj.getJSONArray("list").getJSONObject(index); // 1 Day: index 8; 2 Days: index 16
        int kel = res.getJSONObject("main").getInt("temp");
        return kel - 273;
    }

}