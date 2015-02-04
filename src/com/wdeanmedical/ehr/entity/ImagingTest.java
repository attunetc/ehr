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
@Table(name = "imaging_test")
public class ImagingTest extends BaseEntity implements Serializable {
	
  private static final long serialVersionUID = -6360104967948030699L;
  
  private Integer encounterId;
  private ImagingCode imagingCode;
  private Integer quantity;
  
  
  public ImagingTest() {
  }
  

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @JoinColumn(name = "imaging_code", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public ImagingCode getImagingCode() { return imagingCode; }
  public void setImagingCode(ImagingCode imagingCode) { this.imagingCode = imagingCode; }

  @Column(name = "quantity")
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }


}
