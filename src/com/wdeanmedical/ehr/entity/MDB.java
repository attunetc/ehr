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
import javax.persistence.Table;

@Entity
@Table(name = "mdb")
public class MDB extends BaseEntity implements Serializable {
  
  private static final long serialVersionUID = 1587359145216228151L;
  
  private String code;
  private String descriptor;

  public MDB() {
  }

  @Column(name = "descriptor")
  public String getDescriptor() { return descriptor; }
  public void setDescriptor(String descriptor) { this.descriptor = descriptor; }

  @Column(name = "code")
  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }

}
