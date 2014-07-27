package com.epam.am;

import com.epam.am.entity.Tariff;
import com.epam.am.parser.StaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO arrange parsers!
public class Runner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
//        ReadXMLFile.method();
//        ReadXMLFile2.method();
        List<Tariff> tariffs = new ArrayList<Tariff>();
//        SaxParser.parse(Runner.class.getClassLoader().getResourceAsStream("xml/tariffs.xml"), new SaxHandler(tariffs));
//        DomParser.parse(Runner.class.getClassLoader().getResourceAsStream("xml/tariffs.xml"), tariffs);
        StaxParser.parse(Runner.class.getClassLoader().getResourceAsStream("xml/tariffs.xml"), tariffs);
        System.out.println(tariffs);
    }
}
