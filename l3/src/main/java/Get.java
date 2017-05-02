import org.javalite.http.Http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Dan on 20-Apr-17.
 */
public class Get {

    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();



        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    public static void main(String args[])
    {
        org.javalite.http.Get get = Http.get("http://localhost:3000");
        System.out.println(get.text());
        System.out.println(get.headers());
        System.out.println(get.responseCode());

    }
}
