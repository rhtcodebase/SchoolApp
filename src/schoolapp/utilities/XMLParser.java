/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.utilities;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author prohit
 */
public class XMLParser {
    private ArrayList<Template> templates;

    public ArrayList<Template> parseXML() {
        try {
            File inputFile = new File("smsTemplates.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(inputFile);
            templates = new ArrayList<Template>();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("template");
            String tempId;
            String shortForm;
            String description;

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    tempId = eElement.getElementsByTagName("tempID")
                            .item(0)
                            .getTextContent();
                    shortForm = eElement
                            .getElementsByTagName("shortForm")
                            .item(0)
                            .getTextContent();
                    description = eElement
                            .getElementsByTagName("description")
                            .item(0)
                            .getTextContent();
                    Template template = new Template(tempId, shortForm, description);
                    templates.add(template);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templates;
    }
}
