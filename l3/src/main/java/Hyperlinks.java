import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Dan on 20-Apr-17.
 */
public class Hyperlinks {


    public static int check(String link){
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.connect();
            return 1;

        } catch (MalformedURLException e) {
            // the URL is not in a valid form
            return 0;
        } catch (IOException e) {
            // the connection couldn't be established
            return 0;
        }

    }
    public static int scan(String link) throws IOException {
        Document doc = Jsoup.parse(new URL(link), 2000);

        Elements resultLinks = doc.select("div  > a");
        for (Element er : resultLinks) {
            String href = er.attr("href");

            if(check(href)==1){
                System.out.println("href: " + href);
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {

        scan("http://www.bbc.com/news/technology");




    }


}
