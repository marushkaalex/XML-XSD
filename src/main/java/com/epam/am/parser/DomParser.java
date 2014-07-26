package com.epam.am.parser;

import com.epam.am.entity.CallPrices;
import com.epam.am.entity.Parameters;
import com.epam.am.entity.Tariff;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class DomParser {

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

    private static List<Tariff> tariffs;

    public static void parse(InputStream xml, List<Tariff> list) throws ParserConfigurationException, IOException, SAXException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
        tariffs = list;
        parseNode(doc.getDocumentElement());
    }

    private static void parseNode(Element element) {
        NodeList nodeList = element.getElementsByTagName(TAG_TARIFF);
        Tariff tariff;
        for (int i = 0; i < nodeList.getLength(); i++) {
            tariff = new Tariff();
            Element el = (Element) nodeList.item(i);
            tariff.setName(getChildValue(el, TAG_NAME));
            tariff.setOperatorName(getChildValue(el, TAG_OP_NAME));
            tariff.setPayroll(new BigDecimal(getChildValue(el, TAG_PAYROLL)));
            tariff.setSmsPrice(new BigDecimal(getChildValue(el, TAG_SMS_PRICE)));

            CallPrices callPrices = new CallPrices();
            Element tmp = getChild(el, TAG_CALL_PRICES);
            callPrices.setInnerPrice(new BigDecimal(getChildValue(tmp, TAG_INNER_PRICE)));
            callPrices.setOuterPrice(new BigDecimal(getChildValue(tmp, TAG_OUTER_PRICE)));
            callPrices.setFixedLocation(new BigDecimal(getChildValue(tmp, TAG_FIXED_LOCATION)));
            tariff.setCallPrices(callPrices);

            Parameters parameters = new Parameters();
            tmp = getChild(el, TAG_PARAMETERS);
            parameters.setFavoriteNumbers(new Boolean(getChildValue((Element) tmp, TAG_FAVORITE_NUMBERS)));
            parameters.setTarriffing(getChildValue(tmp, TAG_TARIFFING));
            parameters.setConnectionFee(new BigDecimal(getChildValue(tmp, TAG_CONNECTION_FEE)));
            tariff.setParameters(parameters);

            tariffs.add(tariff);
        }
    }

    private static String getChildValue(Element element, String childName) {
        Node child = getChild(element, childName);
        return child == null ? "0" : child.getFirstChild().getNodeValue();
    }

    private static Element getChild(Element parent, String childName) {
        return (Element) parent.getElementsByTagName(childName).item(0);
    }
}
