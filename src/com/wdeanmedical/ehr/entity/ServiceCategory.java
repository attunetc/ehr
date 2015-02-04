/**
 * 
 */
package com.wdeanmedical.ehr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rajesh
 * 
 */

@Entity
@Table(name = "service_category")
public class ServiceCategory extends BaseEntity implements Serializable {
  
  public static final Integer FAMILY_MEDICINE_GENERAL_MEDICINE  = 1;
  public static final Integer ANTENATAL_CARE = 2;
  public static final Integer WELL_BABY_IMMUNIZATIONS = 3;
  public static final Integer PEDIATRIC_OTHER = 4;
  public static final Integer WELL_WOMAN = 5;
  public static final Integer DIABETES = 6;
  public static final Integer OTHER_CHRONIC_DISEASE_MANAGEMENT = 7;
  public static final Integer PRE_MARITAL_CONSULTATION = 8;
  public static final Integer REPRODUCTIVE_HEALTH = 9;
  public static final Integer SCREENING_SERVICES = 10;
  public static final Integer HOME_CARE = 11;
  public static final Integer MEDICAL_COMMISSION = 12;
  public static final Integer OTHER_PRIMARY_CARE  = 13;
  
  private String code;
  private String name;
  
  public ServiceCategory(){}
  
  @Column(name = "code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  @Column(name = "name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ServiceCategory other = (ServiceCategory) obj;
    if (code == null) {
      if (other.code != null)
        return false;
    } else if (!code.equals(other.code))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ServiceCategory [code=" + code + ", name=" + name + "]";
  } 

}
