package FlightAPI;

import MainScreen.Main;
import javafx.scene.control.Alert;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.*;

public class Request {

    private Request(){
    }

    // get this token at https://developer.lufthansa.com/io-docs
    private static final String TOKEN = generateToken();

    /**
     * Send a request to Lufthansa API and gets an XML-response
     *
     * @param request - URL to Lufthansa API
     * @return String with XML-Data
     * @throws Exception
     */
    public static String request(String request) throws Exception {
        // In developerModues you don't send any request to Lufthansa
        if (Main.developerModus) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(Request.class.getResource("sampleResponse.xml").openStream());
            System.out.println(toXmlString(doc));
            return toXmlString(doc);
        } else {
            String url = request;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + TOKEN + " ");
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

    /**
     * @return Token
     */
    public static String generateToken()  {
        HttpClient client = new HttpClient();

        BufferedReader br = null;

        PostMethod method = new PostMethod("https://api.lufthansa.com/v1/oauth/token");
        method.addParameter("client_id", "d6fkytd9f8agex9zb59g7x6m");
        method.addParameter("client_secret", "n5hSSb3RkV");
        method.addParameter("grant_type", "client_credentials");


        try{
            int returnCode = client.executeMethod(method);

            if(returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
                System.err.println("The Post method is not implemented by this URI");
                // still consume the response body
                method.getResponseBodyAsString();
            } else {
                br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
                String readLine;
                while(((readLine = br.readLine()) != null)) {
                    System.out.println(readLine);
                    return readLine.substring(17,17+24);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
            if(br != null) try { br.close(); } catch (Exception fe) {

            }
        }


        System.err.println("something went wrong - generation of a token");
        return "";
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
