import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonWeatherReader {
    String jsn;
    JSONParser parser = new JSONParser();
    JSONObject jsnobj;

    public JsonWeatherReader(String jsn){
        this.jsn = jsn;
    }

    public void jsoning() throws Exception{
        JSONObject jsnobj = (JSONObject) parser.parse(this.jsn);
        this.jsnobj = jsnobj;
    }

    public String get_weather_description() throws Exception{
        JSONArray arr = (JSONArray) this.jsnobj.get("weather");
        JSONObject weather = (JSONObject) arr.get(0);
        String description = weather.get("description").toString();
        return description;
    }

    public Double get_temperature() throws Exception{
        JSONObject main = (JSONObject) this.jsnobj.get("main");
        Double temp = (Double) main.get("temp");
        return temp;
    }






}