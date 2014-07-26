package com.epam.am.parser;

import com.epam.am.entity.CallPrices;
import com.epam.am.entity.Parameters;
import com.epam.am.entity.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
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

    private String temp;
    private Parameters tempParameters;
    private CallPrices tempCallPrices;
    private Tariff tempTariff;
    List<Tariff> tariffs;

    public SaxHandler(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

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
        if (eq(qName, TAG_TARIFF)) {
            tempTariff = new Tariff();
        } else if (eq(qName, TAG_CALL_PRICES)) {
            tempCallPrices = new CallPrices();
        } else if (eq(qName, TAG_PARAMETERS)) {
            tempParameters = new Parameters();
        }
        temp = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (eq(qName, TAG_TARIFF)) {
            tariffs.add(tempTariff);
        } else if (eq(qName, TAG_PARAMETERS)) {
            tempTariff.setParameters(tempParameters);
        } else if (eq(qName, TAG_CALL_PRICES)) {
            tempTariff.setCallPrices(tempCallPrices);
        } else if (eq(qName, TAG_NAME)) {
            tempTariff.setName(temp);
        } else if (eq(qName, TAG_OP_NAME)) {
            tempTariff.setOperatorName(temp);
        } else if (eq(qName, TAG_PAYROLL)) {
            tempTariff.setPayroll(new BigDecimal(temp));
        } else if (eq(qName, TAG_SMS_PRICE)) {
            tempTariff.setSmsPrice(new BigDecimal(temp));
        } else if (eq(qName, TAG_INNER_PRICE)) {
            tempCallPrices.setInnerPrice(new BigDecimal(temp));
        } else if (eq(qName, TAG_OUTER_PRICE)) {
            tempCallPrices.setOuterPrice(new BigDecimal(temp));
        } else if (eq(qName, TAG_FIXED_LOCATION)) {
            tempCallPrices.setFixedLocation(new BigDecimal(temp));
        } else if (eq(qName, TAG_FAVORITE_NUMBERS)) {
            tempParameters.setFavoriteNumbers(new Boolean(temp));
        } else if (eq(qName, TAG_TARIFFING)) {
            tempParameters.setTarriffing(temp);
        } else if (eq(qName, TAG_CONNECTION_FEE)) {
            tempParameters.setConnectionFee(new BigDecimal(temp));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        temp = new String(ch, start, length);
    }

    private boolean eq(String s1, String s2) {
        return s1.equalsIgnoreCase(s2);
    }
}
