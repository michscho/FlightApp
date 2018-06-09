package FlightAPI;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import Data.Classes.Flight;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class XMLReader {

    public static Document loadXMLFromString(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public static List<Flight> readInput(String string) {

        List<Flight> flightList = new ArrayList<>();

        String flightNumber;
        String startTime;
        String startAirport;
        String endTime;
        String endAirport;
        int gate = 12;
        // TODO
        String terminal = "na";
        // TODO
        String numberOfStops;
        String airplaneType = "na";
        String airline;
        int price;
        boolean directFlight = false;


        try {
            Document doc = loadXMLFromString(string);
            doc.getDocumentElement().normalize();
            System.out.println();
            System.out.println();
            System.out.println();
            NodeList nList = doc.getElementsByTagName("Schedule");
            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                gate = 12;

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nNode;
                    System.out.println("Duration : "
                            + e
                            .getElementsByTagName("TotalJourney")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());

                    // STARTAIRPORT
                    System.out.println("Departure AirportCode : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    startAirport = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    // START TIME
                    System.out.println("DateTime Departure : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    startTime = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    // END AIRPORT
                    System.out.println("Arrival AirportCode : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    endAirport = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    // END TIME
                    System.out.println("DateTime Arrival : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    endTime = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    // AIRLINE ID
                    System.out.println("Airline ID : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(2)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    airline = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(2)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    // FLIGHT NUMBER
                    System.out.println("Flight Number : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(2)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    flightNumber = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(2)
                            .getChildNodes()
                            .item(1)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    // Number of Stops
                    System.out.println("Number of Stops : "
                            + e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(4)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent());
                    numberOfStops = e
                            .getElementsByTagName("Flight")
                            .item(0)
                            .getChildNodes()
                            .item(4)
                            .getChildNodes()
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getTextContent();

                    Random random = new Random();
                    price = random.nextInt(500);
                    int r = random.nextInt(10);
                    gate = gate + r;
                    if (numberOfStops.equals("0")){
                        directFlight = true;
                    }
                    flightList.add(
                            new Flight(
                                    flightNumber, startTime,
                                    startAirport, endTime,
                                    endAirport, terminal,
                                    gate, numberOfStops,
                                    airplaneType, airline,
                                    price, directFlight));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }

}

