import java.lang.reflect.Array;
import java.util.List;

public class Weather {
    String city;
    String appid;
    String data;
    String req;
    String url = "http://api.openweathermap.org/data/2.5/weather";

    public Weather(String c, String aid){
        city = c;
        appid = aid;
        data = "q=" + city + "&APPID=" + appid;
        req = url + "?" + data;
    }

    public void main() throws Exception{
        //System.out.println(req);
        //System.out.println(city);
        //System.out.println(appid);
        String result = new URLReader(req).reading();
        JsonWeatherReader jwr = new JsonWeatherReader(result);
        jwr.jsoning();
        String description = jwr.get_weather_description();
        Double temp_k = jwr.get_temperature();
        Double temp_c = temp_k - 273.15;
        System.out.println("description: " + description);
        System.out.println("temperature in Kelvin: " + temp_k);
        System.out.println("temperature in Celsius: " + temp_c);
    }
}
