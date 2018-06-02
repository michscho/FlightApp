package FlightAPI;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class XMLReader {

    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

        public void readInput(String string) {

            try {
                Document doc = loadXMLFromString(string);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("Schedule");
                System.out.println("----------------------------");

                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nNode;
                        System.out.println("Duration : "
                                + e
                                .getElementsByTagName("TotalJourney")
                                .item(0)
                                .getChildNodes()
                                .item(0)
                                .getTextContent());
                        System.out.println("Arrival AirportCode : "
                                + e
                                .getElementsByTagName("Flight")
                                .item(0)
                                .getChildNodes()
                                .item(0)
                                .getChildNodes()
                                .item(0)
                                .getTextContent());
                        System.out.println("Departure AirportCode : "
                                + e
                                .getElementsByTagName("Flight")
                                .item(0)
                                .getChildNodes()
                                .item(1)
                                .getChildNodes()
                                .item(0)
                                .getTextContent());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

