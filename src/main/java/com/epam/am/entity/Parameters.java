
package com.epam.am.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for Parameters complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Parameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="favoriteNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tarriffing" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="second"/>
 *               &lt;enumeration value="12 second"/>
 *               &lt;enumeration value="minute"/>
 *               &lt;enumeration value="none"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="connectionFee" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameters", namespace = "http://example.com/tariffs", propOrder = {

})
public class Parameters {

    protected Boolean favoriteNumbers;
    protected String tarriffing;
    protected BigDecimal connectionFee;

    /**
     * Gets the value of the favoriteNumbers property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isFavoriteNumbers() {
        return favoriteNumbers;
    }

    /**
     * Sets the value of the favoriteNumbers property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setFavoriteNumbers(Boolean value) {
        this.favoriteNumbers = value;
    }

    /**
     * Gets the value of the tarriffing property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTarriffing() {
        return tarriffing;
    }

    /**
     * Sets the value of the tarriffing property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTarriffing(String value) {
        this.tarriffing = value;
    }

    /**
     * Gets the value of the connectionFee property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getConnectionFee() {
        return connectionFee;
    }

    /**
     * Sets the value of the connectionFee property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setConnectionFee(BigDecimal value) {
        this.connectionFee = value;
    }

    @Override
    public String toString() {
        return "\nParameters{" +
                "\nfavoriteNumbers=" + favoriteNumbers +
                ", \ntarriffing='" + tarriffing + '\'' +
                ", \nconnectionFee=" + connectionFee +
                '}';
    }
}
