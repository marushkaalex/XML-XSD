package com.epam.am;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {

    String temp;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Tariffs info");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("<end of the document>");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("<" + qName + ">");
        temp = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(temp);
        System.out.println("</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        temp = new String(ch, start, length);
    }
}
