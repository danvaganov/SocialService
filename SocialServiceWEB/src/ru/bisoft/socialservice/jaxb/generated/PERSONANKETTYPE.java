//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.26 at 10:56:38 AM YEKT 
//


package ru.bisoft.socialservice.jaxb.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PERSONANKETTYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PERSONANKETTYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DATE_PA" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="TYPE_PA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PERSONANKETANSWERLIST">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PERSONANKETANSWER" type="{}PERSONANKETANSWERTYPE" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERSONANKETTYPE", propOrder = {
    "datepa",
    "typepa",
    "personanketanswerlist"
})
public class PERSONANKETTYPE {

    @XmlElement(name = "DATE_PA", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datepa;
    @XmlElement(name = "TYPE_PA")
    protected int typepa;
    @XmlElement(name = "PERSONANKETANSWERLIST", required = true)
    protected PERSONANKETTYPE.PERSONANKETANSWERLIST personanketanswerlist;

    /**
     * Gets the value of the datepa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATEPA() {
        return datepa;
    }

    /**
     * Sets the value of the datepa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATEPA(XMLGregorianCalendar value) {
        this.datepa = value;
    }

    /**
     * Gets the value of the typepa property.
     * 
     */
    public int getTYPEPA() {
        return typepa;
    }

    /**
     * Sets the value of the typepa property.
     * 
     */
    public void setTYPEPA(int value) {
        this.typepa = value;
    }

    /**
     * Gets the value of the personanketanswerlist property.
     * 
     * @return
     *     possible object is
     *     {@link PERSONANKETTYPE.PERSONANKETANSWERLIST }
     *     
     */
    public PERSONANKETTYPE.PERSONANKETANSWERLIST getPERSONANKETANSWERLIST() {
        return personanketanswerlist;
    }

    /**
     * Sets the value of the personanketanswerlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link PERSONANKETTYPE.PERSONANKETANSWERLIST }
     *     
     */
    public void setPERSONANKETANSWERLIST(PERSONANKETTYPE.PERSONANKETANSWERLIST value) {
        this.personanketanswerlist = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PERSONANKETANSWER" type="{}PERSONANKETANSWERTYPE" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "personanketanswer"
    })
    public static class PERSONANKETANSWERLIST {

        @XmlElement(name = "PERSONANKETANSWER", required = true)
        protected List<PERSONANKETANSWERTYPE> personanketanswer;

        /**
         * Gets the value of the personanketanswer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the personanketanswer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPERSONANKETANSWER().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PERSONANKETANSWERTYPE }
         * 
         * 
         */
        public List<PERSONANKETANSWERTYPE> getPERSONANKETANSWER() {
            if (personanketanswer == null) {
                personanketanswer = new ArrayList<PERSONANKETANSWERTYPE>();
            }
            return this.personanketanswer;
        }

    }

}
