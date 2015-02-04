/*
 * WDean Medical is distributed under the
 * GNU Lesser General Public License (GNU LGPL).
 * For details see: http://www.wdeanmedical.com
 * copyright 2013-2014 WDean Medical
 */
 
package com.wdeanmedical.ehr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ed")
public class ED extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -8700198827939079441L;
  private Integer patientId;
  private Integer encounterId;
  private Integer clinicianId;
  private Date date;
  private Date presentationDate;
  private Disposition disposition;
  private TriageCode triageCode;
  private MDB mdb;
  private DxCode primaryDxCode;
  private DxCode primarySATDxCode;
  private Boolean seeAndTreat;
  private Date commencementDate;
  private Date episodeEndDate;


  public ED() {
  }
  

  @Column(name = "presentation_date")
  public Date getPresentationDate() { return presentationDate; }
  public void setPresentationDate(Date presentationDate) { this.presentationDate = presentationDate; }

  @Column(name = "patient_id")
  public Integer getPatientId() { return patientId; }
  public void setPatientId(Integer patientId) { this.patientId = patientId; }

  @Column(name = "clinician_id")
  public Integer getClinicianId() { return clinicianId; }
  public void setClinicianId(Integer clinicianId) { this.clinicianId = clinicianId; }

  @Column(name = "encounter_id")
  public Integer getEncounterId() { return encounterId; }
  public void setEncounterId(Integer encounterId) { this.encounterId = encounterId; }

  @Column(name = "date")
  public Date getDate() { return date; }
  public void setDate(Date date) { this.date = date; }

  @JoinColumn(name = "disposition", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public Disposition getDisposition() { return disposition; }
  public void setDisposition(Disposition disposition) { this.disposition = disposition; }
  
  @JoinColumn(name = "triage_code", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public TriageCode getTriageCode() { return triageCode; }
  public void setTriageCode(TriageCode triageCode) { this.triageCode = triageCode; }

  @JoinColumn(name = "mdb", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public MDB getMdb() { return mdb; }
  public void setMdb(MDB mdb) { this.mdb = mdb; }
  
  @JoinColumn(name = "dx_code", referencedColumnName = "id")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public DxCode getPrimaryDxCode() { return primaryDxCode; }
  public void setPrimaryDxCode(DxCode primaryDxCode) { this.primaryDxCode = primaryDxCode; }
  
  @JoinColumn(name = "sat_dx_code", referencedColumnName = "id")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public DxCode getPrimarySATDxCode() { return primarySATDxCode; }
  public void setPrimarySATDxCode(DxCode primarySATDxCode) { this.primarySATDxCode = primarySATDxCode; }

  @Column(name = "see_and_treat")
  public Boolean getSeeAndTreat() { return seeAndTreat; }
  public void setSeeAndTreat(Boolean seeAndTreat) { this.seeAndTreat = seeAndTreat; }

  @Column(name = "commencement_date")
  public Date getCommencementDate() { return commencementDate; }
  public void setCommencementDate(Date commencementDate) { this.commencementDate = commencementDate; }

  @Column(name = "episode_end_date")
  public Date getEpisodeEndDate() { return episodeEndDate; }
  public void setEpisodeEndDate(Date episodeEndDate) { this.episodeEndDate = episodeEndDate; }

}
