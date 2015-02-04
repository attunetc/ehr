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
@Table(name = "facility")
public class Facility extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -5331745944019981859L;
	
  private Integer institutionId;
  private String campusCode;
  private String name;
  private String primaryPhone;
  private String secondaryPhone;
  private String streetAddress1;
  private String streetAddress2;
  private String city;
  private String postalCode;
  private Country country;
  private ClinicCategoryCode clinicCategoryCode;
  private String clinicCode;

  public Facility() {
  }


  @Column(name = "institution_id")
  public Integer getInstitutionId() { return institutionId; }
  public void setInstitutionId(Integer institutionId) { institutionId = institutionId; }

  @Column(name = "campus_code")
  public String getCampusCode() { return campusCode; }
  public void setCampusCode(String campusCode) { this.campusCode = campusCode; }

  @Column(name = "name")
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  @Column(name = "postal_code")
  public String getPostalCode() { return postalCode; }
  public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

  @Column(name = "primary_phone")
  public String getPrimaryPhone() { return primaryPhone; }
  public void setPrimaryPhone(String primaryPhone) { this.primaryPhone = primaryPhone; }

  @Column(name = "secondary_phone")
  public String getSecondaryPhone() { return secondaryPhone; }
  public void setSecondaryPhone(String secondaryPhone) { this.secondaryPhone = secondaryPhone; }

  @Column(name = "street_address1")
  public String getStreetAddress1() { return streetAddress1; }
  public void setStreetAddress1(String streetAddress1) { this.streetAddress1 = streetAddress1; }

  @Column(name = "street_address2")
  public String getStreetAddress2() { return streetAddress2; }
  public void setStreetAddress2(String streetAddress2) { this.streetAddress2 = streetAddress2; }

  @Column(name = "city")
  public String getCity() { return city; }
  public void setCity(String city) { this.city = city; }

  @JoinColumn(name = "country", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public Country getCountry() { return country; }
  public void setCountry(Country country) { this.country = country; }

  @JoinColumn(name = "clinic_category_code", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public ClinicCategoryCode getClinicCategoryCode() { return clinicCategoryCode; }
  public void setClinicCategoryCode(ClinicCategoryCode clinicCategoryCode) { this.clinicCategoryCode = clinicCategoryCode; }

  @Column(name = "clinic_code")
  public String getClinicCode() { return clinicCode; }
  public void setClinicCode(String clinicCode) { this.clinicCode = clinicCode; }

}
