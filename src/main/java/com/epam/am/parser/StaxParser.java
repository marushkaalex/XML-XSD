package com.epam.am.parser;

import com.epam.am.entity.CallPrices;
import com.epam.am.entity.Parameters;
import com.epam.am.entity.Tariff;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class StaxParser {

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

    public static void parse(InputStream xml, List<Tariff> tariffs) {
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xml);
            process(reader, tariffs);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void process(XMLStreamReader reader, List<Tariff> tariffs) throws XMLStreamException {

        Tariff tempTariff = null;
        CallPrices tempCallPrices = null;
        Parameters tempParameters = null;
        String qName = "";
        String temp = "";

        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    qName = reader.getLocalName();
                    if (eq(qName, TAG_TARIFF)) {
                        tempTariff = new Tariff();
                    } else if (eq(qName, TAG_CALL_PRICES)) {
                        tempCallPrices = new CallPrices();
                    } else if (eq(qName, TAG_PARAMETERS)) {
                        tempParameters = new Parameters();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    temp = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    qName = reader.getLocalName();
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
                    break;
            }
        }
    }

    private static boolean eq(String s1, String s2) {
        return s1.equalsIgnoreCase(s2);
    }
}
