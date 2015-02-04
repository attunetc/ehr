/*
 * WDean Medical is distributed under the
 * GNU Lesser General Public License (GNU LGPL).
 * For details see: http://www.wdeanmedical.com
 * copyright 2013-2014 WDean Medical
 */
 
package com.wdeanmedical.ehr.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dme_type")
public class DMEType extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -703737204727960015L;
  
  private String code;
  private String description;
  private DMECategory category;

  public DMEType() {
  }

  @Column(name = "code")
  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }
  
  @Column(name = "description")
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  @JoinColumn(name = "dme_category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  public DMECategory getCategory() { return category; }
  public void setCategory(DMECategory category) { this.category = category; }

}
