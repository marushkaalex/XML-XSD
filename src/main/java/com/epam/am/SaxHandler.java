package com.epam.am;

import com.epam.am.entity.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {

    public static final String TAG_TARIFF = "tariff";
    public static final String TAG_NAME = "name";
    public static final String TAG_OP_NAME = "operatorName";
    public static final String TAG_PAYROLL = "payroll";
    public static final String TAG_CALL_PRICES = "callPrices";
    public static final String TAG_SMS_PRICE = "smsPrice";
    public static final String TAG_PARAMETERS = "parameters";
    public static final String TAG_INNER_PRICE = "innerPrice";
    public static final String TAG_OUTER_PRICE = "outerPrice";
    public static final String TAG_FIXED_LOCATION = "fixedLocation";
    public static final String TAG_FAVORITE_NUMBERS = "favoriteNumbers";
    public static final String TAG_TARIFFING = "tariffing";
    public static final String TAG_CONNECTION_FEE = "connectionFee";
    String temp;
    List<Tariff> tariffs;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Tariffs info");
        tariffs = new ArrayList<Tariff>();
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
