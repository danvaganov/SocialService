//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.02 at 05:10:58 PM YEKT 
//


package ru.bisoft.socialservice.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WORKPLACETYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WORKPLACETYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KEY_WORKPLACE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WORKPLACETYPE", propOrder = {
    "keyworkplace",
    "name"
})
public class WORKPLACETYPE {

    @XmlElement(name = "KEY_WORKPLACE")
    protected int keyworkplace;
    @XmlElement(name = "NAME", required = true)
    protected String name;

    /**
     * Gets the value of the keyworkplace property.
     * 
     */
    public int getKEYWORKPLACE() {
        return keyworkplace;
    }

    /**
     * Sets the value of the keyworkplace property.
     * 
     */
    public void setKEYWORKPLACE(int value) {
        this.keyworkplace = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
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
    public void setNAME(String value) {
        this.name = value;
    }

}
