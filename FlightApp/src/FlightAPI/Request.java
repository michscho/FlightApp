package FlightAPI;

import Main.Main;
import javafx.scene.control.Alert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    // get this token at https://developer.lufthansa.com/io-docs
    private static final String token = "bwhj6dfr93b3cyb4tctdbjzm";

     public static String request(String request) throws Exception {
         // In developerModues you don't send any request to Lufthansa
         if (Main.developerModus){
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
             DocumentBuilder db = dbf.newDocumentBuilder();
             Document doc = db.parse("file:///" + System.getProperty("user.dir") + "\\resources\\data\\sampleResponse.xml");
             System.out.println(toXmlString(doc));
             return toXmlString(doc);
         } else {
             String url = request;
             URL obj = new URL(url);
             HttpURLConnection con = (HttpURLConnection) obj.openConnection();
             con.setRequestMethod("GET");
             con.setRequestProperty("Authorization", "Bearer " + token + " ");
             con.setRequestProperty("Accept", "application/xml");
             int responseCode = con.getResponseCode();
             System.out.println("\nSending 'GET' request to URL : " + url);
             System.out.println("Response Code : " + responseCode);

             if (responseCode != HttpURLConnection.HTTP_OK) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Error");
                 alert.setHeaderText("Your request failed");
                 alert.setContentText("Error code: " + responseCode);
                 alert.showAndWait();
             }

             BufferedReader in = new BufferedReader(
                     new InputStreamReader(con.getInputStream()));
             String inputLine;
             StringBuffer response = new StringBuffer();
             while ((inputLine = in.readLine()) != null) {
                 response.append(inputLine);
             }
             in.close();
             System.out.println(response.toString());
             return response.toString();
         }

        }

    private static String toXmlString(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StringWriter strWriter = new StringWriter();
        StreamResult result = new StreamResult(strWriter);

        transformer.transform(source, result);

        return strWriter.getBuffer().toString();

    }



    }
