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
@Table(name = "drug_item")
public class DrugItem extends BaseEntity implements Serializable {
  
  private static final long serialVersionUID = 1099642434578109826L;
  private Integer encounterId;
  private DrugCode drugCode;
  private Integer quantity;
  
  
  public DrugItem() {
  }
  

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @JoinColumn(name = "drug_code", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public DrugCode getDrugCode() { return drugCode; }
  public void setDrugCode(DrugCode drugCode) { this.drugCode = drugCode; }

  @Column(name = "quantity")
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }

}
