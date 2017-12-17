import java.net.*;
import java.io.*;

public class URLReader{
    String url;

    public URLReader(String url){
        this.url = url;
    }
    public String reading() throws Exception {
        return new BufferedReader(new InputStreamReader(new URL(this.url).openStream())).readLine();
    }
}