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
@Table(name = "dme_code")
public class DMECode extends BaseEntity implements Serializable {
	
  private static final long serialVersionUID = -652619755689294564L;
  
  private Integer encounterId;
  private DMEType dmeType;
  
  
  public DMECode() {
  }
  

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @JoinColumn(name = "dme_type", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public DMEType getDMEType() { return dmeType; }
  public void setDMEType(DMEType dmeType) { this.dmeType = dmeType; }

}
