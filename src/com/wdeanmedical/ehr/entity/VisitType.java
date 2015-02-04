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
@Table(name = "visit_type_code")
public class VisitType extends BaseEntity implements Serializable {
  
  public static final Integer SCHEDULED_VISIT  = 1;
  public static final Integer WALK_IN_VISIT = 2;
  
  private String code;
  private String name;
  
  public VisitType(){}
  
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
    VisitType other = (VisitType) obj;
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
    return "VisitType [code=" + code + ", name=" + name + "]";
  }  

}
