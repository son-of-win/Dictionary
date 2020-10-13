package source_code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Scanner;

public class googleAptTranslate {

    public void getRequest(){
        HttpClient client = HttpClient.newHttpClient();
                ;


        String Url = generateUrl("hello");

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Url)).build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Path.of("E:\\Dictionary\\src\\result\\response.txt"))); // trả về in kq vào file json
//            String a = response.body();
//            System.out.print(a);


        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public void getResult(){
        String result = "";
        try {
            File file = new File("E:\\Dictionary\\src\\result\\response.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                if(key.contains("translatedText")){
                    result = result + key;
                }
            }
            System.out.print(result.substring(27));
            scan.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String generateUrl(String input){
        String key = "https://translation.googleapis.com/language/translate/v2?target=vi&key=AIzaSyDYImq9Vbx_5wu2VkvXFx9eXY6D3gQTdg4";
        String chuoi = "&q=";
        String result = input.replace(" ","%20");
        String Url = key + chuoi + result;
        return Url;
    }
}
