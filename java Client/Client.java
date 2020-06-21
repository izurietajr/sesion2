import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public Socket socket;
    public int port;
    public String host;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
        } catch (Exception e) { }
    }

    public void getServer(){
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            System.out.println(buffer.readLine());
        } catch (Exception e) { }
    }

    public static void main(String[] args) {

        String url = args[0];
        System.out.println(url);

        String FILE_NAME = "archivo.txt";
        try{
            URL url_instance = new URL(url);


            try (BufferedInputStream in = new BufferedInputStream(url_instance.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME))
            {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                // handle exception
            }

        } catch (Exception e){}//MalformedURLException}



    }

}
