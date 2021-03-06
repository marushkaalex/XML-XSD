package com.epam.am.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class SaxParser {
    private static SAXParser parser;
    private static SaxHandler handler;

    static {
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private SaxParser() {}

    public static SAXParser getInstance() {
        return parser;
    }

    public static void setHandler(SaxHandler handler) {
        SaxParser.handler = handler;
    }

    public static void parse(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        if (handler == null) throw new ParserConfigurationException("You haven't set handler");
        parser.parse(inputStream, handler);
    }

    public static void parse(InputStream inputStream, SaxHandler handler) throws IOException, SAXException, ParserConfigurationException {
        SaxParser.handler = handler;
        parse(inputStream);
    }
}
