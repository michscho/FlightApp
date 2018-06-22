package WeatherAPI; // TODO: show current weather and weather on arrival

import org.json.JSONObject;

import java.net.URL;
import java.util.Scanner;

public class WeatherRequest {

    private static final String APIKey = "39b1bc038434e7c0b3db7e4b96a6afb9";
    public String cityID;

    public WeatherRequest(String cityID) {
        this.cityID = cityID;
    }

    public static void main(String[] args) {
        String munich = "3220838";
        String berlin = "2950158";

        WeatherRequest wr = new WeatherRequest(berlin);
        try {
            System.out.println(wr.currentWeather());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String urlBuilder (String url) throws Exception {
        String s = url + this.cityID + "&APPID=" + this.APIKey;
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
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/weather?id=");
        JSONObject obj = new JSONObject(url);

        JSONObject weather = obj.getJSONArray("weather").getJSONObject(0);
        return weather.getString("main");
    }

    public String weatherForecast () throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/forecast?id=");
        JSONObject obj = new JSONObject(url);

        JSONObject res = obj.getJSONArray("list").getJSONObject(8);
        return res.getJSONArray("weather").getJSONObject(0).getString("main");
    }

}