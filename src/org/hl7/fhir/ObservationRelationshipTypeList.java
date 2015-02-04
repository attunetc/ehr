//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.12 at 12:19:07 PM EDT 
//


package org.hl7.fhir;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationRelationshipType-list.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationRelationshipType-list">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="has-component"/>
 *     &lt;enumeration value="has-member"/>
 *     &lt;enumeration value="derived-from"/>
 *     &lt;enumeration value="sequel-to"/>
 *     &lt;enumeration value="replaces"/>
 *     &lt;enumeration value="qualified-by"/>
 *     &lt;enumeration value="interfered-by"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ObservationRelationshipType-list")
@XmlEnum
public enum ObservationRelationshipTypeList {


    /**
     * The target observation is a component of this observation (e.g. Systolic and Diastolic Blood Pressure).
     * 
     */
    @XmlEnumValue("has-component")
    HAS_COMPONENT("has-component"),

    /**
     * This observation is a group observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.
     * 
     */
    @XmlEnumValue("has-member")
    HAS_MEMBER("has-member"),

    /**
     * The target observation is part of the information from which this observation value is derived (e.g. calculated anion gap, Apgar score).
     * 
     */
    @XmlEnumValue("derived-from")
    DERIVED_FROM("derived-from"),

    /**
     * This observation follows the target observation (e.g. timed tests such as Glucose Tolerance Test).
     * 
     */
    @XmlEnumValue("sequel-to")
    SEQUEL_TO("sequel-to"),

    /**
     * This observation replaces a previous observation (i.e. a revised value). The target observation is now obsolete.
     * 
     */
    @XmlEnumValue("replaces")
    REPLACES("replaces"),

    /**
     * The value of the target observation qualifies (refines) the semantics of the source observation (e.g. a lipaemia measure target from a plasma measure).
     * 
     */
    @XmlEnumValue("qualified-by")
    QUALIFIED_BY("qualified-by"),

    /**
     * The value of the target observation interferes (degardes quality, or prevents valid observation) with the semantics of the source observation (e.g. a hemolysis measure target from a plasma potassium measure which has no value).
     * 
     */
    @XmlEnumValue("interfered-by")
    INTERFERED_BY("interfered-by");
    private final java.lang.String value;

    ObservationRelationshipTypeList(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static ObservationRelationshipTypeList fromValue(java.lang.String v) {
        for (ObservationRelationshipTypeList c: ObservationRelationshipTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
