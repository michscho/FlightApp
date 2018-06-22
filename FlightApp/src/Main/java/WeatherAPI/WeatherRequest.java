package WeatherAPI; // TODO: show current weather and weather on arrival

import javafx.scene.image.Image;
import org.json.JSONObject;

import java.net.URL;
import java.util.Scanner;

public class WeatherRequest {

    private static final String APIKey = "39b1bc038434e7c0b3db7e4b96a6afb9";
    public String city;

    public WeatherRequest(String city) {
        this.city = city;
    }

    public static void main(String[] args) {
        String munich = "3220838";
        String berlin = "2950158";

        WeatherRequest wr = new WeatherRequest("München");
        String tmp = "";
        try {
            System.out.println(wr.currentWeather());
            tmp = wr.currentWeather();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Image image = new Image("http://openweathermap.org/img/w/" + tmp + ".png");
//        System.out.println("Image URL: " + image.getUrl());
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
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/forecast?id=");
        JSONObject obj = new JSONObject(url);

        JSONObject res = obj.getJSONArray("list").getJSONObject(index); // 1 Day: index 8; 2 Days: index 16
        return res.getJSONArray("weather").getJSONObject(0).getString("icon");
    }

}