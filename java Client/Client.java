import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    public static void getFile(String url, String filename){

        try{
            URL url_instance = new URL(url);

            try (BufferedInputStream in = new BufferedInputStream(url_instance.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(filename))
            {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                // handle exception
            }

        } catch (Exception e){}
    }

    public static void main(String[] args) {

        String url = args[0];
        String filename = args[1];

        Client.getFile(url, filename);

    }

}
