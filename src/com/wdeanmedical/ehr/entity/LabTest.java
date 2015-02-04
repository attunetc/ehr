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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lab_test")
public class LabTest extends BaseEntity implements Serializable {
	
  private static final long serialVersionUID = -2908112966241890726L;
  
  private Integer encounterId;
  private LabCode labCode;
  private Integer quantity;
  
  
  public LabTest() {
  }
  

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @JoinColumn(name = "lab_code", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public LabCode getLabCode() { return labCode; }
  public void setLabCode(LabCode labCode) { this.labCode = labCode; }

  @Column(name = "quantity")
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }

}
