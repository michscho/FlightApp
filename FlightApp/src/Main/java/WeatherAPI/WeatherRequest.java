package WeatherAPI;

import org.json.JSONObject;

import java.net.URL;
import java.util.Scanner;

public class WeatherRequest {

    private static final String APIKey = "39b1bc038434e7c0b3db7e4b96a6afb9";
    public String city;

    public WeatherRequest(String city) {
        this.city = city;
    }

    public void arrayToString (int[] arr) { // for testing
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Day " + i + ": " + Integer.toString(arr[i]));
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

    public String[] getIcon () throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/forecast?q=");
        JSONObject obj = new JSONObject(url);

        JSONObject today = obj.getJSONArray("list").getJSONObject(0); // Weather Today
        JSONObject tomorrow = obj.getJSONArray("list").getJSONObject(8); // Weather tomorrow
        JSONObject future = obj.getJSONArray("list").getJSONObject(16); // Weather in two days

        String[] icons = new String[3];
        icons[0] = today.getJSONArray("weather").getJSONObject(0).getString("icon");
        icons[1] = tomorrow.getJSONArray("weather").getJSONObject(0).getString("icon");
        icons[2] = future.getJSONArray("weather").getJSONObject(0).getString("icon");

        return icons;
    }

    public int[] getTemp () throws Exception {
        String url = urlBuilder("https://api.openweathermap.org/data/2.5/forecast?q=");
        JSONObject obj = new JSONObject(url);

        JSONObject today = obj.getJSONArray("list").getJSONObject(0); // Temp Today
        JSONObject tomorrow = obj.getJSONArray("list").getJSONObject(8); // Temp Tomorrow
        JSONObject future = obj.getJSONArray("list").getJSONObject(16); // Temp in two days

        int[] temperatures = new int[3];
        temperatures[0] = tempConverter(today.getJSONObject("main").getInt("temp"));
        temperatures[1] = tempConverter(tomorrow.getJSONObject("main").getInt("temp"));
        temperatures[2] = tempConverter(future.getJSONObject("main").getInt("temp"));

        return temperatures;
    }

    public int tempConverter(int kelvin) {
        return kelvin - 273;
    }

}