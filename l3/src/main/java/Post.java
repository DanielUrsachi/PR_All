import org.javalite.http.Http;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;

/**
 * Created by Dan on 20-Apr-17.
 */



public class Post {

    public static void main(String[] args) throws Exception {
        org.javalite.http.Post post = Http.post("http://localhost:3000")
                .param("nume2", "valoare2");
                 System.out.println(post.text());

    }


}
