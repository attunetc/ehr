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
 * A description of a query with a set of parameters.
 * 
 * <p>Java class for Query.Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Query.Response">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://hl7.org/fhir}uri"/>
 *         &lt;element name="outcome" type="{http://hl7.org/fhir}QueryOutcome"/>
 *         &lt;element name="total" type="{http://hl7.org/fhir}integer" minOccurs="0"/>
 *         &lt;element name="parameter" type="{http://hl7.org/fhir}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="first" type="{http://hl7.org/fhir}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="previous" type="{http://hl7.org/fhir}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="next" type="{http://hl7.org/fhir}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="last" type="{http://hl7.org/fhir}Extension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://hl7.org/fhir}ResourceReference" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Query.Response", propOrder = {
    "identifier",
    "outcome",
    "total",
    "parameter",
    "first",
    "previous",
    "next",
    "last",
    "reference"
})
public class QueryResponse
    extends BackboneElement
{

    @XmlElement(required = true)
    protected Uri identifier;
    @XmlElement(required = true)
    protected QueryOutcome outcome;
    protected Integer total;
    protected List<Extension> parameter;
    protected List<Extension> first;
    protected List<Extension> previous;
    protected List<Extension> next;
    protected List<Extension> last;
    protected List<ResourceReference> reference;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link Uri }
     *     
     */
    public Uri getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uri }
     *     
     */
    public void setIdentifier(Uri value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the outcome property.
     * 
     * @return
     *     possible object is
     *     {@link QueryOutcome }
     *     
     */
    public QueryOutcome getOutcome() {
        return outcome;
    }

    /**
     * Sets the value of the outcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryOutcome }
     *     
     */
    public void setOutcome(QueryOutcome value) {
        this.outcome = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotal(Integer value) {
        this.total = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<Extension>();
        }
        return this.parameter;
    }

    /**
     * Gets the value of the first property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the first property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFirst().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getFirst() {
        if (first == null) {
            first = new ArrayList<Extension>();
        }
        return this.first;
    }

    /**
     * Gets the value of the previous property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previous property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrevious().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getPrevious() {
        if (previous == null) {
            previous = new ArrayList<Extension>();
        }
        return this.previous;
    }

    /**
     * Gets the value of the next property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the next property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getNext() {
        if (next == null) {
            next = new ArrayList<Extension>();
        }
        return this.next;
    }

    /**
     * Gets the value of the last property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the last property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLast().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     * 
     * 
     */
    public List<Extension> getLast() {
        if (last == null) {
            last = new ArrayList<Extension>();
        }
        return this.last;
    }

    /**
     * Gets the value of the reference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceReference }
     * 
     * 
     */
    public List<ResourceReference> getReference() {
        if (reference == null) {
            reference = new ArrayList<ResourceReference>();
        }
        return this.reference;
    }

}
