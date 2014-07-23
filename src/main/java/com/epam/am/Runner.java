package com.epam.am;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
//        ReadXMLFile.method();
//        ReadXMLFile2.method();
        SaxParser.parse(Runner.class.getClassLoader().getResourceAsStream("xml/tariffs.xml"), new SaxHandler());
    }
}
