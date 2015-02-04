/*
 * WDean Medical is distributed under the
 * GNU Lesser General Public License (GNU LGPL).
 * For details see: http://www.wdeanmedical.com
 * copyright 2013-2014 WDean Medical
 */
 
package com.wdeanmedical.ehr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "icd_10am")
public class ICD10AM extends BaseEntity implements Serializable {
  
  private static final long serialVersionUID = -6643559192047668494L;
  
  private Integer level;
  private String code;
  private String description;
  private Boolean dagger;
  private Boolean asterisk;
  private Boolean valid;
  private Boolean austCode;
  private String longDesc;
  private Date effectiveFrom;
  private Date inactive;
  private Date reactivated;
  private Integer sex;
  private Integer sType;
  private Integer ageL;
  private Integer ageH;
  private Integer aType;
  private Boolean rDiag;
  private Integer morphCode;
  private Date conceptChange;
  private Boolean unacceptPdx;

  public ICD10AM() {
  }

  @Column(name = "description")
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  @Column(name = "code")
  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }

  @Column(name = "level")
  public Integer getLevel() { return level; }
  public void setLevel(Integer level) { this.level = level; }

  @Column(name = "dagger")
  public Boolean getDagger() { return dagger; }
  public void setDagger(Boolean dagger) { this.dagger = dagger; }

  @Column(name = "asterisk")
  public Boolean getAsterisk() { return asterisk; }
  public void setAsterisk(Boolean asterisk) { this.asterisk = asterisk; }

  @Column(name = "valid")
  public Boolean getValid() { return valid; }
  public void setValid(Boolean valid) { this.valid = valid; }

  @Column(name = "aust_code")
  public Boolean getAustCode() { return austCode; }
  public void setAustCode(Boolean austCode) { this.austCode = austCode; }

  @Column(name = "long_desc")
  public String getLongDesc() { return longDesc; }
  public void setLongDesc(String longDesc) { this.longDesc = longDesc; }

  @Column(name = "effective_from")
  public Date getEffectiveFrom() { return effectiveFrom; }
  public void setEffectiveFrom(Date effectiveFrom) { this.effectiveFrom = effectiveFrom; }

  @Column(name = "inactive")
  public Date getInactive() { return inactive; }
  public void setInactive(Date inactive) { this.inactive = inactive; }

  @Column(name = "reactivated")
  public Date getReactivated() { return reactivated; }
  public void setReactivated(Date reactivated) { this.reactivated = reactivated; }

  @Column(name = "sex")
  public Integer getSex() { return sex; }
  public void setSex(Integer sex) { this.sex = sex; }

  @Column(name = "s_type")
  public Integer getsType() { return sType; }
  public void setsType(Integer sType) { this.sType = sType; }

  @Column(name = "age_l")
  public Integer getAgeL() { return ageL; }
  public void setAgeL(Integer ageL) { this.ageL = ageL; }

  @Column(name = "age_h")
  public Integer getAgeH() { return ageH; }
  public void setAgeH(Integer ageH) { this.ageH = ageH; }

  @Column(name = "a_type")
  public Integer getaType() { return aType; }
  public void setaType(Integer aType) { this.aType = aType; }

  @Column(name = "r_diag")
  public Boolean getrDiag() { return rDiag; }
  public void setrDiag(Boolean rDiag) { this.rDiag = rDiag; }

  @Column(name = "morph_code")
  public Integer getMorphCode() { return morphCode; }
  public void setMorphCode(Integer morphCode) { this.morphCode = morphCode; }

  @Column(name = "concept_change")
  public Date getConceptChange() { return conceptChange; }
  public void setConceptChange(Date conceptChange) { this.conceptChange = conceptChange; }

  @Column(name = "unaccept_pdx")
  public Boolean getUnacceptPdx() { return unacceptPdx; }
  public void setUnacceptPdx(Boolean unacceptPdx) { this.unacceptPdx = unacceptPdx; }

}
