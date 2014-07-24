
package com.epam.am.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.am.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Tariffs_QNAME = new QName("http://example.com/tariffs", "tariffs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.am.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tariffs }
     * 
     */
    public Tariffs createTariffs() {
        return new Tariffs();
    }

    /**
     * Create an instance of {@link FavoriteNumbers }
     * 
     */
    public FavoriteNumbers createFavoriteNumbers() {
        return new FavoriteNumbers();
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Tariff }
     * 
     */
    public Tariff createTariff() {
        return new Tariff();
    }

    /**
     * Create an instance of {@link CallPrices }
     * 
     */
    public CallPrices createCallPrices() {
        return new CallPrices();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tariffs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example.com/tariffs", name = "tariffs")
    public JAXBElement<Tariffs> createTariffs(Tariffs value) {
        return new JAXBElement<Tariffs>(_Tariffs_QNAME, Tariffs.class, null, value);
    }

}
