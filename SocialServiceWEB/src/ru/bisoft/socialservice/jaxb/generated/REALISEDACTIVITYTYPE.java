//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.02 at 05:10:58 PM YEKT 
//


package ru.bisoft.socialservice.jaxb.generated;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.bisoft.socialservice.jaxb.adapter.DateAdapter;


/**
 * <p>Java class for REALISEDACTIVITYTYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REALISEDACTIVITYTYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PERFORMANCEDATE" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="COMMENTS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COD_PERSO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REALIZE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COD_USLUGA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PERIODLOW" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="PERIODHIGH" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="FREQUENCY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USLUGA_FSIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COD_TYPEUSLUGA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COD_KSSC" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PERFORMER" type="{}PERFORMERTYPE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REALISEDACTIVITYTYPE", propOrder = {
    "performancedate",
    "comments",
    "codperso",
    "realize",
    "codusluga",
    "periodlow",
    "periodhigh",
    "frequency",
    "uslugafsin",
    "codtypeusluga",
    "codkssc",
    "performer"
})
public class REALISEDACTIVITYTYPE {

    @XmlElement(name = "PERFORMANCEDATE", required = true, type = String.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlSchemaType(name = "date")
    protected Date performancedate;
    @XmlElement(name = "COMMENTS", required = true)
    protected String comments;
    @XmlElement(name = "COD_PERSO")
    protected int codperso;
    @XmlElement(name = "REALIZE")
    protected int realize;
    @XmlElement(name = "COD_USLUGA")
    protected int codusluga;
    @XmlElement(name = "PERIODLOW", required = true, type = String.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlSchemaType(name = "date")
    protected Date periodlow;
    @XmlElement(name = "PERIODHIGH", required = true, type = String.class)
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlSchemaType(name = "date")
    protected Date periodhigh;
    @XmlElement(name = "FREQUENCY", required = true)
    protected String frequency;
    @XmlElement(name = "USLUGA_FSIN", required = true)
    protected String uslugafsin;
    @XmlElement(name = "COD_TYPEUSLUGA")
    protected int codtypeusluga;
    @XmlElement(name = "COD_KSSC")
    protected int codkssc;
    @XmlElement(name = "PERFORMER", required = true)
    protected PERFORMERTYPE performer;

    /**
     * Gets the value of the performancedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPERFORMANCEDATE() {
        return performancedate;
    }

    /**
     * Sets the value of the performancedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERFORMANCEDATE(Date value) {
        this.performancedate = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMENTS() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMENTS(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the codperso property.
     * 
     */
    public int getCODPERSO() {
        return codperso;
    }

    /**
     * Sets the value of the codperso property.
     * 
     */
    public void setCODPERSO(int value) {
        this.codperso = value;
    }

    /**
     * Gets the value of the realize property.
     * 
     */
    public int getREALIZE() {
        return realize;
    }

    /**
     * Sets the value of the realize property.
     * 
     */
    public void setREALIZE(int value) {
        this.realize = value;
    }

    /**
     * Gets the value of the codusluga property.
     * 
     */
    public int getCODUSLUGA() {
        return codusluga;
    }

    /**
     * Sets the value of the codusluga property.
     * 
     */
    public void setCODUSLUGA(int value) {
        this.codusluga = value;
    }

    /**
     * Gets the value of the periodlow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPERIODLOW() {
        return periodlow;
    }

    /**
     * Sets the value of the periodlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERIODLOW(Date value) {
        this.periodlow = value;
    }

    /**
     * Gets the value of the periodhigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPERIODHIGH() {
        return periodhigh;
    }

    /**
     * Sets the value of the periodhigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERIODHIGH(Date value) {
        this.periodhigh = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFREQUENCY() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFREQUENCY(String value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the uslugafsin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSLUGAFSIN() {
        return uslugafsin;
    }

    /**
     * Sets the value of the uslugafsin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSLUGAFSIN(String value) {
        this.uslugafsin = value;
    }

    /**
     * Gets the value of the codtypeusluga property.
     * 
     */
    public int getCODTYPEUSLUGA() {
        return codtypeusluga;
    }

    /**
     * Sets the value of the codtypeusluga property.
     * 
     */
    public void setCODTYPEUSLUGA(int value) {
        this.codtypeusluga = value;
    }

    /**
     * Gets the value of the codkssc property.
     * 
     */
    public int getCODKSSC() {
        return codkssc;
    }

    /**
     * Sets the value of the codkssc property.
     * 
     */
    public void setCODKSSC(int value) {
        this.codkssc = value;
    }

    /**
     * Gets the value of the performer property.
     * 
     * @return
     *     possible object is
     *     {@link PERFORMERTYPE }
     *     
     */
    public PERFORMERTYPE getPERFORMER() {
        return performer;
    }

    /**
     * Sets the value of the performer property.
     * 
     * @param value
     *     allowed object is
     *     {@link PERFORMERTYPE }
     *     
     */
    public void setPERFORMER(PERFORMERTYPE value) {
        this.performer = value;
    }

}
