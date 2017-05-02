    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.nodes.Element;
    import org.jsoup.select.Elements;

    import java.io.*;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.*;

    /**
     * Created by Dan on 20-Apr-17.
     */
    public class Crawler extends Hyperlinks{
        static List<String> sites = new ArrayList<String>();
        static String txt = new String();

        public static int scan(String link) throws IOException {
            Document doc = Jsoup.parse(new URL(link), 2000);

            Elements resultLinks = doc.select("a");
            for (Element er : resultLinks) {
                String href = er.attr("href");

                if(check(href)==1){
                    if(!sites.contains(href)){
                        sites.add(href);
                    }

                }
            }
            return 0;
        }

        public static int scanEl(String link, String tag) throws IOException {
            Document doc = Jsoup.parse(new URL(link), 2000);

            Elements resultLinks = doc.select(tag);

            for (Element er : resultLinks) {

                    System.out.println(tag + " : " + er.text());

                txt = txt+er+"  ";

            }
            print();

            return 0;
        }
        public static void print(){
            try{
                PrintWriter writer = new PrintWriter("crawler.txt", "UTF-8");
                writer.println(txt);
                writer.close();
            } catch (IOException e) {
                System.out.print("err");
            }
        }

        public static void main(String[] args) throws Exception {

            sites.add("http://localhost/Lab3APPOO/1/pages/1.html");

            for (int i = 0; i < sites.size();i++){

                System.out.println(sites.get(i));
                scan(sites.get(i));
                System.out.println(sites);
                System.out.println(i);

            }

            System.out.println(sites);
            System.out.println("-------------");

            for (int i = 0; i < sites.size();i++){
                scanEl(sites.get(i),".clasa");
            }

        }
    }
