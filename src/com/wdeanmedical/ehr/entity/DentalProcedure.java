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
@Table(name = "dental_procedure")
public class DentalProcedure extends BaseEntity implements Serializable {
  
  private static final long serialVersionUID = -6428880196476918728L;
  
  private Integer encounterId;
  private DentalProcedureCode dentalProcedureCode;
  private Integer quantity;
  
  
  public DentalProcedure() {
  }
  

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @JoinColumn(name = "dental_proc_code", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public DentalProcedureCode getDentalProcedureCode() { return dentalProcedureCode; }
  public void setDentalProcedureCode(DentalProcedureCode dentalProcedureCode) { this.dentalProcedureCode = dentalProcedureCode; }

  @Column(name = "quantity")
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }

}
