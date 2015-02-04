//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.12 at 12:19:07 PM EDT 
//


package org.hl7.fhir;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A conformance statement is a set of requirements for a desired implementation or a description of how a target application fulfills those requirements in a particular implementation.
 * 
 * <p>Java class for Conformance.Event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Conformance.Event">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://hl7.org/fhir}Coding"/>
 *         &lt;element name="category" type="{http://hl7.org/fhir}MessageSignificanceCategory" minOccurs="0"/>
 *         &lt;element name="mode" type="{http://hl7.org/fhir}ConformanceEventMode"/>
 *         &lt;element name="protocol" type="{http://hl7.org/fhir}Coding" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="focus" type="{http://hl7.org/fhir}code"/>
 *         &lt;element name="request" type="{http://hl7.org/fhir}ResourceReference"/>
 *         &lt;element name="response" type="{http://hl7.org/fhir}ResourceReference"/>
 *         &lt;element name="documentation" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conformance.Event", propOrder = {
    "code",
    "category",
    "mode",
    "protocol",
    "focus",
    "request",
    "response",
    "documentation"
})
public class ConformanceEvent
    extends BackboneElement
{

    @XmlElement(required = true)
    protected Coding code;
    protected MessageSignificanceCategory category;
    @XmlElement(required = true)
    protected ConformanceEventMode mode;
    protected List<Coding> protocol;
    @XmlElement(required = true)
    protected Code focus;
    @XmlElement(required = true)
    protected ResourceReference request;
    @XmlElement(required = true)
    protected ResourceReference response;
    protected String documentation;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Coding }
     *     
     */
    public Coding getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coding }
     *     
     */
    public void setCode(Coding value) {
        this.code = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link MessageSignificanceCategory }
     *     
     */
    public MessageSignificanceCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageSignificanceCategory }
     *     
     */
    public void setCategory(MessageSignificanceCategory value) {
        this.category = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link ConformanceEventMode }
     *     
     */
    public ConformanceEventMode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConformanceEventMode }
     *     
     */
    public void setMode(ConformanceEventMode value) {
        this.mode = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the protocol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtocol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Coding }
     * 
     * 
     */
    public List<Coding> getProtocol() {
        if (protocol == null) {
            protocol = new ArrayList<Coding>();
        }
        return this.protocol;
    }

    /**
     * Gets the value of the focus property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getFocus() {
        return focus;
    }

    /**
     * Sets the value of the focus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setFocus(Code value) {
        this.focus = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceReference }
     *     
     */
    public ResourceReference getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceReference }
     *     
     */
    public void setRequest(ResourceReference value) {
        this.request = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceReference }
     *     
     */
    public ResourceReference getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceReference }
     *     
     */
    public void setResponse(ResourceReference value) {
        this.response = value;
    }

    /**
     * Gets the value of the documentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Sets the value of the documentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentation(String value) {
        this.documentation = value;
    }

}
