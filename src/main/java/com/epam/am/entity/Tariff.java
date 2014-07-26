
package com.epam.am.entity;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tariff complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tariff">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="payroll" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="callPrices" type="{http://example.com/tariffs}CallPrices"/>
 *         &lt;element name="smsPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="parameters" type="{http://example.com/tariffs}Parameters"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tariff", namespace = "http://example.com/tariffs", propOrder = {

})
public class Tariff {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String operatorName;
    @XmlElement(required = true)
    protected BigDecimal payroll;
    @XmlElement(required = true)
    protected CallPrices callPrices;
    @XmlElement(required = true)
    protected BigDecimal smsPrice;
    @XmlElement(required = true)
    protected Parameters parameters;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the operatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * Sets the value of the operatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * Gets the value of the payroll property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayroll() {
        return payroll;
    }

    /**
     * Sets the value of the payroll property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayroll(BigDecimal value) {
        this.payroll = value;
    }

    /**
     * Gets the value of the callPrices property.
     * 
     * @return
     *     possible object is
     *     {@link CallPrices }
     *     
     */
    public CallPrices getCallPrices() {
        return callPrices;
    }

    /**
     * Sets the value of the callPrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallPrices }
     *     
     */
    public void setCallPrices(CallPrices value) {
        this.callPrices = value;
    }

    /**
     * Gets the value of the smsPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSmsPrice() {
        return smsPrice;
    }

    /**
     * Sets the value of the smsPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSmsPrice(BigDecimal value) {
        this.smsPrice = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link Parameters }
     *     
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *     
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

}
