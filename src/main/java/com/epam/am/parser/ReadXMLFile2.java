package com.epam.am.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadXMLFile2 {
    private static final Logger log = LoggerFactory.getLogger(ReadXMLFile2.class);

    public static void method() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(ReadXMLFile2.class.getClassLoader().getResourceAsStream("xml/tariffs.xml"));
            log.info("Root element: {}", document.getDocumentElement().getNodeName());

            if (document.hasChildNodes()) {
                printNode(document.getChildNodes());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNode(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                log.info("Node name = {} [OPEN]", tempNode.getNodeName());
                log.info("Node value = {}", tempNode.getTextContent());

                if (tempNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Node node = nodeMap.item(j);
                        log.info("attr name: {}", node.getNodeName());
                        log.info("attr value: {}", node.getNodeValue());
                    }
                }

                if (tempNode.hasChildNodes()) {
                    printNode(tempNode.getChildNodes());
                }
                log.info("Node name = {} + [CLOSE]", tempNode.getNodeName());
            }
        }
    }
}
