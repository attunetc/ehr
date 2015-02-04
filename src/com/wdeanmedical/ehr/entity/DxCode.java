/*
 * WDean Medical is distributed under the
 * GNU Lesser General Public License (GNU LGPL).
 * For details see: http://www.wdeanmedical.com
 * copyright 2013-2014 WDean Medical
 */
 
package com.wdeanmedical.ehr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dx_code")
public class DxCode extends BaseEntity implements Serializable {
	
  private static final long serialVersionUID = -652619755689294564L;
  
  private Integer encounterId;
  private ICD10AM icd10AM;
  private Boolean isPrimary;
  
  
  public DxCode() {
  }
  

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @JoinColumn(name = "icd_10am", referencedColumnName = "id")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public ICD10AM getIcd10AM() { return icd10AM; }
  public void setIcd10AM(ICD10AM icd10am) { icd10AM = icd10am; }

  @Column(name = "is_primary")
  public Boolean getIsPrimary() { return isPrimary; }
  public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }

}
