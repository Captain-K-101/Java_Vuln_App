
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XmlParser {

  private static final String FILENAME = "/users/ninair/test/xee.xml";

  public String Printer(){

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	  String s="";
      try {

          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));

          NodeList list = doc.getElementsByTagName("staff");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  String id = element.getAttribute("id");

                  String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                  String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
                  String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();
                  
                  System.out.println(firstname);
                  System.out.println(lastname);
                  System.out.println(nickname);
                  s=s+firstname+"<br>"+lastname+"<br>"+nickname+"<br>";
                  NodeList salaryNodeList = element.getElementsByTagName("salary");
                  String salary = salaryNodeList.item(0).getTextContent();

                  String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

              }
          }


      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
      return s;
  }

}
