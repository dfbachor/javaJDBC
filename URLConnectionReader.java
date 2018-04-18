import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class URLConnectionReader {
    public static void main(String[] args) throws Exception {

        //data format needs to be as follows 
        //2018-04-17 21:42:32
        Date datetime = new Date();
        System.out.println("datetime is : " + datetime);

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = DATE_FORMAT.format(datetime);
        System.out.println("Today in dd-MM-yy:HH:mm:SS : " + date);
        
        // System.out.println("date: " + "http://dbachor.com/NCC/getChatLogJSON.php?startDateTime=" + URLEncoder.encode(date, "UTF-8"));

        URL dfbchats = new URL("http://dbachor.com/NCC/getChatLogJSON.php?startDateTime=" + URLEncoder.encode(date, "UTF-8"));

        URLConnection dfbchatsConnection = dfbchats.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                dfbchatsConnection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}

