
package com.epam.am.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Tariffs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tariffs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tariff" type="{http://example.com/tariffs}Tariff" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tariffs", namespace = "http://example.com/tariffs", propOrder = {
    "tariff"
})
public class Tariffs {

    @XmlElement(required = true)
    protected List<Tariff> tariff;

    /**
     * Gets the value of the tariff property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariff property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariff().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tariff }
     * 
     * 
     */
    public List<Tariff> getTariff() {
        if (tariff == null) {
            tariff = new ArrayList<Tariff>();
        }
        return this.tariff;
    }

    @Override
    public String toString() {
        return "Tariffs{" +
                "\ntariff=" + tariff +
                '}';
    }
}
