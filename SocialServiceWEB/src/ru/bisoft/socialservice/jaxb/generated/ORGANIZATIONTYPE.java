//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.26 at 10:56:38 AM YEKT 
//


package ru.bisoft.socialservice.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORGANIZATIONTYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORGANIZATIONTYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NAME_ORGANIZATION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INN_ORGANIZATION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FULL_NAME_ORGANIZATION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KEY_ORGANIZATION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORGANIZATIONTYPE", propOrder = {
    "nameorganization",
    "innorganization",
    "fullnameorganization",
    "keyorganization"
})
public class ORGANIZATIONTYPE {

    @XmlElement(name = "NAME_ORGANIZATION", required = true)
    protected String nameorganization;
    @XmlElement(name = "INN_ORGANIZATION", required = true)
    protected String innorganization;
    @XmlElement(name = "FULL_NAME_ORGANIZATION", required = true)
    protected String fullnameorganization;
    @XmlElement(name = "KEY_ORGANIZATION")
    protected int keyorganization;

    /**
     * Gets the value of the nameorganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAMEORGANIZATION() {
        return nameorganization;
    }

    /**
     * Sets the value of the nameorganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAMEORGANIZATION(String value) {
        this.nameorganization = value;
    }

    /**
     * Gets the value of the innorganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINNORGANIZATION() {
        return innorganization;
    }

    /**
     * Sets the value of the innorganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINNORGANIZATION(String value) {
        this.innorganization = value;
    }

    /**
     * Gets the value of the fullnameorganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFULLNAMEORGANIZATION() {
        return fullnameorganization;
    }

    /**
     * Sets the value of the fullnameorganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFULLNAMEORGANIZATION(String value) {
        this.fullnameorganization = value;
    }

    /**
     * Gets the value of the keyorganization property.
     * 
     */
    public int getKEYORGANIZATION() {
        return keyorganization;
    }

    /**
     * Sets the value of the keyorganization property.
     * 
     */
    public void setKEYORGANIZATION(int value) {
        this.keyorganization = value;
    }

}
