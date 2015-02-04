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
@Table(name = "encounter")
public class Encounter extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1462745762564975233L;

  public static final Integer LOCK_FREE = 0;
  public static final Integer LOCK_LOCKED = 1;
  public static final Integer LOCK_OVERRIDDEN = 2;

  private ServiceEventOrdinal serviceEventOrdinal;
  private String episodeNumber;
  private String priorAuthNumber;
  private Date date;
  private Patient patient;
  private Clinician clinician;
  private EncounterType encounterType;
  private ChiefComplaint cc;
  private VitalSigns vitals;
  private SuppQuestions supp;
  private Exam exam;
  private Lab lab;
  private SOAPNote soapNote;
  private OBGYNEncounterData obgyn;
  private ED ed;
  private Integer lockStatus;
  private Boolean completed = false;
  private String notes;
  private Boolean demoSaved = true;
  private Boolean vitalsSaved = false;
  private Boolean soapNoteSaved = false;
  private Boolean ccSaved = false;
  private Boolean obgynSaved = false;
  private Boolean pfshSaved = false;
  private Boolean suppSaved = false;
  private Boolean histSaved = false;
  private Boolean examSaved = false;
  private Boolean edSaved = false;
  private DxCode primaryDxCode;
  private List<DxCode> dxCodes;
  private List<DMECode> dmeCodes;
  private List<TxCode> txCodes;
  private List<ImagingTest> imagingTests;
  private List<LabTest> labTests;
  private List<DrugItem> drugItems;
  private List<DentalProcedure> dentalProcedures;

  public Encounter() {
  }
  
  @JoinColumn(name = "service_event_ordinal", referencedColumnName = "id")
  @ManyToOne(optional = false)
  public ServiceEventOrdinal getServiceEventOrdinal() { return serviceEventOrdinal; }
  public void setServiceEventOrdinal(ServiceEventOrdinal serviceEventOrdinal) { this.serviceEventOrdinal = serviceEventOrdinal; }

  @Column(name = "episode_number", unique=true)
  public String getEpisodeNumber() { return episodeNumber; }
  public void setEpisodeNumber(String episodeNumber) { this.episodeNumber = episodeNumber; }

  @Column(name = "completed")
  public Boolean getCompleted() { return completed; }
  public void setCompleted(Boolean completed) { this.completed = completed; }

  @JoinColumn(name = "patient", referencedColumnName = "id")
  @ManyToOne(optional = false)
  public Patient getPatient() { return patient; }
  public void setPatient(Patient patient) { this.patient = patient; }

  @Column(name = "date")
  public Date getDate() { return date; }
  public void setDate(Date date) { this.date = date; }

  @JoinColumn(name = "clinician", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public Clinician getClinician() { return clinician; }
  public void setClinician(Clinician clinician) { this.clinician = clinician; }

  @JoinColumn(name = "vital_signs", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public VitalSigns getVitals() { return vitals; }
  public void setVitals(VitalSigns vitals) { this.vitals = vitals; }

  @JoinColumn(name = "chief_complaint", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public ChiefComplaint getCc() { return cc; }
  public void setCc(ChiefComplaint cc) { this.cc = cc; }

  @JoinColumn(name = "exam", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public Exam getExam() { return exam; }
  public void setExam(Exam exam) { this.exam = exam; }

  @JoinColumn(name = "lab", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public Lab getLab() { return lab; }
  public void setLab(Lab lab) { this.lab = lab; }

  @JoinColumn(name = "obgyn", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public OBGYNEncounterData getObgyn() { return obgyn; }
  public void setObgyn(OBGYNEncounterData obgyn) { this.obgyn = obgyn; }

  @JoinColumn(name = "soap_note", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public SOAPNote getSOAPNote() { return soapNote; }
  public void setSOAPNote(SOAPNote soapNote) { this.soapNote = soapNote; }

  @JoinColumn(name = "ed", referencedColumnName = "id")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public ED getED() { return ed; }
  public void setED(ED ed) { this.ed = ed; }

  @JoinColumn(name = "encounter_type", referencedColumnName = "id")
  @ManyToOne(optional = false)
  public EncounterType getEncounterType() { return encounterType; }
  public void setEncounterType(EncounterType encounterType) { this.encounterType = encounterType; }

  @Column(name = "lock_status")
  public Integer getLockStatus() { return lockStatus; }
  public void setLockStatus(Integer lockStatus) { this.lockStatus = lockStatus; }

  @JoinColumn(name = "supp_questions", referencedColumnName = "id")
  @ManyToOne(optional = true)
  public SuppQuestions getSupp() { return supp; }
  public void setSupp(SuppQuestions supp) { this.supp = supp; }

  @Column(name = "demo_saved")
  public Boolean getDemoSaved() { return demoSaved; }
  public void setDemoSaved(Boolean demoSaved) { this.demoSaved = demoSaved; }

  @Column(name = "vitals_saved")
  public Boolean getVitalsSaved() { return vitalsSaved; }
  public void setVitalsSaved(Boolean vitalsSaved) { this.vitalsSaved = vitalsSaved; }

  @Column(name = "soap_note_saved")
  public Boolean getSOAPNoteSaved() { return soapNoteSaved; }
  public void setSOAPNoteSaved(Boolean soapNoteSaved) { this.soapNoteSaved = soapNoteSaved; }

  @Column(name = "cc_saved")
  public Boolean getCcSaved() { return ccSaved; }
  public void setCcSaved(Boolean ccSaved) { this.ccSaved = ccSaved; }

  @Column(name = "obgyn_saved")
  public Boolean getObgynSaved() { return obgynSaved; }
  public void setObgynSaved(Boolean obgynSaved) { this.obgynSaved = obgynSaved; }

  @Column(name = "pfsh_saved")
  public Boolean getPfshSaved() { return pfshSaved; }
  public void setPfshSaved(Boolean pfshSaved) { this.pfshSaved = pfshSaved; }

  @Column(name = "supp_saved")
  public Boolean getSuppSaved() { return suppSaved; }
  public void setSuppSaved(Boolean suppSaved) { this.suppSaved = suppSaved; }

  @Column(name = "hist_saved")
  public Boolean getHistSaved() { return histSaved; }
  public void setHistSaved(Boolean histSaved) { this.histSaved = histSaved; }

  @Column(name = "exam_saved")
  public Boolean getExamSaved() { return examSaved; }
  public void setExamSaved(Boolean examSaved) { this.examSaved = examSaved; }

  @Column(name = "ed_saved")
  public Boolean getEDSaved() { return edSaved; }
  public void setEDSaved(Boolean edSaved) { this.edSaved = edSaved; }

  @Column(name = "notes")
  public String getNotes() { return notes; }
  public void setNotes(String notes) { this.notes = notes; }
  
  @Column(name = "prior_auth_number")
  public String getPriorAuthNumber() { return priorAuthNumber; }
  public void setPriorAuthNumber(String priorAuthNumber) { this.priorAuthNumber = priorAuthNumber; }

  @JoinColumn(name = "dx_code", referencedColumnName = "id")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public DxCode getPrimaryDxCode() { return primaryDxCode; }
  public void setPrimaryDxCode(DxCode primaryDxCode) { this.primaryDxCode = primaryDxCode; }

  @Transient
  public List<DxCode> getDxCodes() { return dxCodes; }
  public void setDxCodes(List<DxCode> dxCodes) { this.dxCodes = dxCodes; }
  
  @Transient
  public List<DMECode> getDMECodes() { return dmeCodes; }
  public void setDMECodes(List<DMECode> dmeCodes) { this.dmeCodes = dmeCodes; }

  @Transient
  public List<TxCode> getTxCodes() { return txCodes; }
  public void setTxCodes(List<TxCode> txCodes) { this.txCodes = txCodes; }

  @Transient
  public List<ImagingTest> getImagingTests() { return imagingTests; }
  public void setImagingTests(List<ImagingTest> imagingTests) { this.imagingTests = imagingTests; }

  @Transient
  public List<LabTest> getLabTests() { return labTests; }
  public void setLabTests(List<LabTest> labTests) { this.labTests = labTests; }

  @Transient
  public List<DrugItem> getDrugItems() { return drugItems; }
  public void setDrugItems(List<DrugItem> drugItems) { this.drugItems = drugItems; }

  @Transient
  public List<DentalProcedure> getDentalProcedures() { return dentalProcedures; }
  public void setDentalProcedures(List<DentalProcedure> dentalProcedures) { this.dentalProcedures = dentalProcedures; }

}
