package com.wdeanmedical.ehr.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.wdeanmedical.ehr.core.Core;
import com.wdeanmedical.ehr.core.ExcludedFields;
import com.wdeanmedical.ehr.entity.Appointment;
import com.wdeanmedical.ehr.entity.BaseEntity;
import com.wdeanmedical.ehr.entity.CPT;
import com.wdeanmedical.ehr.entity.CPTModifier;
import com.wdeanmedical.ehr.entity.ChiefComplaint;
import com.wdeanmedical.ehr.entity.Clinician;
import com.wdeanmedical.ehr.entity.ClinicianSchedule;
import com.wdeanmedical.ehr.entity.ClinicianSession;
import com.wdeanmedical.ehr.entity.Country;
import com.wdeanmedical.ehr.entity.Credentials;
import com.wdeanmedical.ehr.entity.DMECode;
import com.wdeanmedical.ehr.entity.DMEType;
import com.wdeanmedical.ehr.entity.Demographics;
import com.wdeanmedical.ehr.entity.DentalProcedure;
import com.wdeanmedical.ehr.entity.DentalProcedureCode;
import com.wdeanmedical.ehr.entity.Disposition;
import com.wdeanmedical.ehr.entity.DrugCode;
import com.wdeanmedical.ehr.entity.DrugItem;
import com.wdeanmedical.ehr.entity.DxCode;
import com.wdeanmedical.ehr.entity.ED;
import com.wdeanmedical.ehr.entity.Encounter;
import com.wdeanmedical.ehr.entity.EncounterType;
import com.wdeanmedical.ehr.entity.Ethnicity;
import com.wdeanmedical.ehr.entity.Exam;
import com.wdeanmedical.ehr.entity.Gender;
import com.wdeanmedical.ehr.entity.ICD10AM;
import com.wdeanmedical.ehr.entity.ImagingCode;
import com.wdeanmedical.ehr.entity.ImagingTest;
import com.wdeanmedical.ehr.entity.LabCode;
import com.wdeanmedical.ehr.entity.LabTest;
import com.wdeanmedical.ehr.entity.MDB;
import com.wdeanmedical.ehr.entity.PatientHistoryMedication;
import com.wdeanmedical.ehr.entity.EncounterQuestion;
import com.wdeanmedical.ehr.entity.Lab;
import com.wdeanmedical.ehr.entity.LabReview;
import com.wdeanmedical.ehr.entity.MaritalStatus;
import com.wdeanmedical.ehr.entity.OBGYNEncounterData;
import com.wdeanmedical.ehr.entity.Patient;
import com.wdeanmedical.ehr.entity.PatientAllergen;
import com.wdeanmedical.ehr.entity.PatientClinician;
import com.wdeanmedical.ehr.entity.PatientFollowUp;
import com.wdeanmedical.ehr.entity.PatientHealthIssue;
import com.wdeanmedical.ehr.entity.PatientHealthTrendReport;
import com.wdeanmedical.ehr.entity.PatientImmunization;
import com.wdeanmedical.ehr.entity.PatientLetter;
import com.wdeanmedical.ehr.entity.MedicalHistory;
import com.wdeanmedical.ehr.entity.PatientMedicalProcedure;
import com.wdeanmedical.ehr.entity.PatientMedicalTest;
import com.wdeanmedical.ehr.entity.PatientMedication;
import com.wdeanmedical.ehr.entity.PatientMessage;
import com.wdeanmedical.ehr.entity.PFSH;
import com.wdeanmedical.ehr.entity.PatientStatus;
import com.wdeanmedical.ehr.entity.Country;
import com.wdeanmedical.ehr.entity.Race;
import com.wdeanmedical.ehr.entity.SOAPNote;
import com.wdeanmedical.ehr.entity.ServiceCategory;
import com.wdeanmedical.ehr.entity.ServiceEventOrdinal;
import com.wdeanmedical.ehr.entity.SuppQuestions;
import com.wdeanmedical.ehr.entity.TriageCode;
import com.wdeanmedical.ehr.entity.TxCode;
import com.wdeanmedical.ehr.entity.VisitType;
import com.wdeanmedical.ehr.entity.VitalSigns;
import com.wdeanmedical.ehr.entity.ProgressNote;
import com.wdeanmedical.ehr.entity.ToDoNote;
import com.wdeanmedical.ehr.persistence.SiteDAO;
import com.wdeanmedical.ehr.util.DataEncryptor;
import com.wdeanmedical.ehr.util.OneWayPasswordEncoder;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PatientDAO extends SiteDAO {

  private static final Logger log = Logger.getLogger(PatientDAO.class);

  private SessionFactory sessionFactory;
  
  
  public PatientDAO() {
    super();
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  protected Session getSession() {
    return this.sessionFactory.getCurrentSession();
  }
  
  public void create(BaseEntity item) throws Exception {
    item.setLastUpdated(new Date());
    this.createEntity(item);
  }
  
  public void update(BaseEntity item) throws Exception {
    item.setLastUpdated(new Date());
    this.updateEntity(item);
  }
  
  public void delete(BaseEntity item) throws Exception {
    this.deleteEntity(item);
  }
  
  public List<EncounterQuestion> getEncounterQuestionsByEncounter(int encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(EncounterQuestion.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    crit.addOrder(Order.asc("id"));
    List<EncounterQuestion> list = crit.list();
    return list;
  }
  
  
  
  public List<PatientHistoryMedication> getPatientMedicationsByPatient(int patientId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(PatientHistoryMedication.class);
    crit.add(Restrictions.eq("patientId", patientId));
    crit.addOrder(Order.asc("id"));
    List<PatientHistoryMedication> list = crit.list();
    for (PatientHistoryMedication item : list) {
      ExcludedFields.excludeFields(item);
    }
    return list;
  }
  
  
  
   public List<DxCode> getDxCodes(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(DxCode.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    crit.add(Restrictions.eq("isPrimary", false));
    List<DxCode> list =  crit.list();
    return list;
  }
  
  
  
  
   public List<DMECode> getDMECodes(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(DMECode.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    List<DMECode> list =  crit.list();
    return list;
  }
  
    
    
  public DxCode getPrimaryDxCode(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(DxCode.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    crit.add(Restrictions.eq("isPrimary", true));
    return (DxCode)crit.uniqueResult();
  }
  
  
  public DxCode findDxCodeFromCode(String code) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(DxCode.class);
    crit.add(Restrictions.eq("code", code));
    return (DxCode)crit.uniqueResult();
  }
  
  
  
  public List<ImagingTest> getImagingTests(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(ImagingTest.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    List<ImagingTest> list =  crit.list();
    return list;
  }
  
  
  
  public List<LabTest> getLabTests(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(LabTest.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    List<LabTest> list =  crit.list();
    return list;
  }
  
  
  public List<DrugItem> getDrugItems(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(DrugItem.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    List<DrugItem> list =  crit.list();
    return list;
  }
  
  
  public List<DentalProcedure> getDentalProcedures(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(DentalProcedure.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    List<DentalProcedure> list =  crit.list();
    return list;
  }
  
  
  
  public List<TxCode> getTxCodes(Integer encounterId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(TxCode.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    List<TxCode> list =  crit.list();
    return list;
  }
  
  

  public Encounter findCurrentEncounterByPatientId(int patientId) throws Exception {
    Patient patient = findPatientById(patientId);
    Session session = this.getSession();
    Criteria crit = session.createCriteria(Encounter.class);
    crit.add(Restrictions.eq("patient", patient));
    ProjectionList proj = Projections.projectionList();
    proj = proj.add(Projections.max("id"));
    crit = crit.setProjection(proj);
    Integer id = (Integer)crit.uniqueResult();
    crit = session.createCriteria(Encounter.class);
    crit.add(Restrictions.eq("id", id));
    Encounter encounter = (Encounter)crit.uniqueResult();
    if (encounter != null) {
     loadEncounter(encounter);
    }
    
    return encounter;
  }
    
    
  public List<Encounter> findEncountersByPatient(Integer patientId) throws Exception {
    Patient patient = findPatientById(patientId);
    Session session = this.getSession();
    Criteria crit = session.createCriteria(Encounter.class);
    crit.add(Restrictions.eq("patient", patient));
    crit.addOrder(Order.desc("date"));
    List<Encounter> list = crit.list();
    for (Encounter encounter : list) {
     loadEncounter(encounter);
    }
    return list;
  }
  
  
  
  public void loadEncounter(Encounter encounter) throws Exception {
    encounter.getSupp().setEncounterQuestionList(getEncounterQuestionsByEncounter(encounter.getId()));
    encounter.setDMECodes(getDMECodes(encounter.getId()));
    encounter.setDxCodes(getDxCodes(encounter.getId()));
    encounter.setTxCodes(getTxCodes(encounter.getId()));
    encounter.setImagingTests(getImagingTests(encounter.getId()));
    encounter.setLabTests(getLabTests(encounter.getId()));
    encounter.setDrugItems(getDrugItems(encounter.getId()));
    encounter.setDentalProcedures(getDentalProcedures(encounter.getId()));
    encounter.setPrimaryDxCode(getPrimaryDxCode(encounter.getId()));
    encounter.getPatient().getHist().setPatientMedicationList(getPatientMedicationsByPatient(encounter.getPatient().getId()));
  }
  
  
  public  List<ProgressNote> findProgressNotesByPatient(Patient patient) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(ProgressNote.class);
    crit.add(Restrictions.eq("patient", patient));
    crit.addOrder(Order.desc("date"));
    List<ProgressNote> list = crit.list();
    return list;
  }
  
  
  
  public List<ChiefComplaint> findChiefComplaintsByPatientId(Integer patientId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(ChiefComplaint.class);
    crit.add(Restrictions.eq("patientId", patientId));
    crit.addOrder(Order.desc("date"));
    List<ChiefComplaint> list = crit.list();
    return list;
  }
  
  
  
  public  List<SOAPNote> findSOAPNotesByPatientId(Integer patientId) throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(SOAPNote.class);
    crit.add(Restrictions.eq("patientId", patientId));
    crit.addOrder(Order.desc("date"));
    List<SOAPNote> list = crit.list();
    return list;
  }
  

  
  public void updatePatientMedication(PatientHistoryMedication patientHistoryMedication) throws Exception {
    Session session = this.getSession();
    session.update(patientHistoryMedication);
  }
  
  
  
  public void updateEncounterQuestion(EncounterQuestion encounterQuestion) throws Exception {
    Session session = this.getSession();
    session.update(encounterQuestion);
  }
  
  
 
  public void updateDxCode(DxCode dxCode) throws Exception {
    Session session = this.getSession();
    session.update(dxCode);
  } 
  
  
  
  public void updateTxCode(TxCode txCode) throws Exception {
    Session session = this.getSession();
    session.update(txCode);
  } 
  
  
  
  public void createPatient(Patient patient) throws Exception {
    Session session = this.getSession();
    patient.setLastAccessed(new Date());
    session.save(patient);
  }
  
  public ProgressNote createProgressNote(Patient patient, Clinician clinician) throws Exception {
    Session session = this.getSession();
    ProgressNote note = new ProgressNote(); 
    note.setPatient(patient);
    note.setClinician(clinician);
    note.setDate(new Date());
    session.save(note);
    return note;
  }
  
  
  
  public String createEpisodeNumber(Encounter encounter) throws Exception {
    return String.format("%012d", encounter.getId());
  }
  
  
  
  public Encounter createEncounter(Patient patient, Clinician clinician) throws Exception {
    Session session = this.getSession();
    
    Encounter encounter = new Encounter(); 
    encounter.setEncounterType(findEncounterTypeById(EncounterType.CHECK_UP)); 
    encounter.setLastAccessed(new Date());
    encounter.setCreatedDate(new Date());
    encounter.setDate(new Date());
    encounter.setClinician(clinician);
    encounter.setPatient(patient);
    session.save(encounter);
    
    encounter.setEpisodeNumber(createEpisodeNumber(encounter));
    
    ChiefComplaint cc = new ChiefComplaint();
    cc.setPatientId(patient.getId());
    cc.setEncounterId(encounter.getId());
    session.save(cc);
    encounter.setCc(cc);
    
    VitalSigns vitals = new VitalSigns();
    vitals.setPatientId(patient.getId());
    vitals.setClinicianId(clinician.getId());
    vitals.setEncounterId(encounter.getId());
    vitals.setDate(encounter.getDate());
    session.save(vitals);
    encounter.setVitals(vitals);
    
    SOAPNote soapNote = new SOAPNote();
    soapNote.setPatientId(patient.getId());
    soapNote.setClinicianId(clinician.getId());
    soapNote.setEncounterId(encounter.getId());
    soapNote.setDate(encounter.getDate());
    session.save(soapNote);
    encounter.setSOAPNote(soapNote);
    
    SuppQuestions supp = new SuppQuestions();
    supp.setPatientId(patient.getId());
    supp.setEncounterId(encounter.getId());
    session.save(supp);
    encounter.setSupp(supp);
    
    Exam exam = new Exam();
    exam.setPatientId(patient.getId());
    exam.setEncounterId(encounter.getId());
    session.save(exam);
    encounter.setExam(exam);
    
    Lab lab = new Lab();
    lab.setPatientId(patient.getId());
    lab.setEncounterId(encounter.getId());
    session.save(lab);
    encounter.setLab(lab);
    
    OBGYNEncounterData obgyn = new OBGYNEncounterData();
    obgyn.setPatientId(patient.getId());
    obgyn.setEncounterId(encounter.getId());
    session.save(obgyn);
    encounter.setObgyn(obgyn);
    
    ED ed = new ED();
    ed.setPatientId(patient.getId());
    ed.setEncounterId(encounter.getId());
    session.save(ed);
    encounter.setED(ed);
    
    session.update(encounter);
    return encounter;
  }

  
  public Encounter findCurrentEncounterByPatient(Patient patient) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(Encounter.class);
    crit.add(Restrictions.eq("patient", patient));
    crit.add(Restrictions.eq("completed", false));
    Encounter encounter = null;
    encounter = (Encounter)crit.uniqueResult();
    if (encounter != null) {
     loadEncounter(encounter);
    }
    return encounter;
  }
  
  public EncounterType findEncounterTypeById(int id) throws Exception {
    EncounterType et = (EncounterType) this.findById(EncounterType.class, id);
    return et;
  }
  
  public Encounter findEncounterById(int id) throws Exception {
    Encounter encounter = (Encounter) this.findById(Encounter.class, id);
    Patient patient = encounter.getPatient();
    loadEncounter(encounter);
    return encounter;
  }
  
  public ProgressNote findProgressNoteById(int id) throws Exception {
    ProgressNote note = (ProgressNote) this.findById(ProgressNote.class, id);
    return note;
  }
  
  public Patient findPatientById(Integer id) throws Exception {
    Patient patient = (Patient) this.findById(Patient.class, id);
    return patient;
  }
  
  public PatientStatus findPatientStatusById(Integer id) throws Exception {
    PatientStatus ps = (PatientStatus) this.findById(PatientStatus.class, id);
    return ps;
  }
  
  public Encounter findEncounterById(Integer id) throws Exception {
    Encounter patientEncounter = (Encounter) this.findById(Encounter.class, id);
    return patientEncounter;
  }
  
  public VitalSigns findVitalSignsByEncounterId(Integer encounterId) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(VitalSigns.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    return (VitalSigns)crit.uniqueResult();
  }
  
  public ChiefComplaint findChiefComplaintByEncounterId(Integer encounterId) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(ChiefComplaint.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    return (ChiefComplaint)crit.uniqueResult();
  }
  
  public Exam findExamByEncounterId(Integer encounterId) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(Exam.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    return (Exam)crit.uniqueResult();
  }
  
  public Lab findLabByEncounterId(Integer encounterId) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(Lab.class);
    crit.add(Restrictions.eq("encounterId", encounterId));
    return (Lab)crit.uniqueResult();
  }
  
  public void updatePatientProfileImage(Patient patient, String path) throws Exception {
    Session session = this.getSession();
    Demographics d = patient.getDemo();
    d.setProfileImagePath(path);
    session.update(d);
  }
  
  public PatientHistoryMedication findPatientMedicationById(int id) throws Exception {
    PatientHistoryMedication patientHistoryMedication = (PatientHistoryMedication) this.findById(PatientHistoryMedication.class, id);
    return patientHistoryMedication;
  }
  
  public EncounterQuestion findEncounterQuestionById(int id) throws Exception {
    EncounterQuestion encounterQuestion = (EncounterQuestion) this.findById(EncounterQuestion.class, id);
    return encounterQuestion;
  }
  
  
  
  public ICD10AM findICD10AMById(int id) throws Exception {
    ICD10AM icd10AM = (ICD10AM) this.findById(ICD10AM.class, id);
    return icd10AM;
  }
  
  
  
  public CPT findCPTById(int id) throws Exception {
    CPT cpt = (CPT) this.findById(CPT.class, id);
    return cpt;
  }
  
  
  
  public ImagingCode findImagingCodeById(int id) throws Exception {
    ImagingCode imagingCode = (ImagingCode) this.findById(ImagingCode.class, id);
    return imagingCode;
  }
  
  
  
  public LabCode findLabCodeById(int id) throws Exception {
    LabCode labCode = (LabCode) this.findById(LabCode.class, id);
    return labCode;
  }
  
  
  
  public DrugCode findDrugCodeById(int id) throws Exception {
    DrugCode drugCode = (DrugCode) this.findById(DrugCode.class, id);
    return drugCode;
  }
  
  
  
  public DentalProcedureCode findDentalProcedureCodeById(int id) throws Exception {
    DentalProcedureCode dentalProcedureCode = (DentalProcedureCode) this.findById(DentalProcedureCode.class, id);
    return dentalProcedureCode;
  }
  
  
  
  public CPTModifier findCPTModifierById(int id) throws Exception {
    CPTModifier cptModifier = (CPTModifier) this.findById(CPTModifier.class, id);
    return cptModifier;
  }
  
  
  
  public DMEType findDMETypeById(int id) throws Exception {
    DMEType dmeType = (DMEType) this.findById(DMEType.class, id);
    return dmeType;
  }
  
  
  
  public ImagingTest findImagingTestById(int id) throws Exception {
    ImagingTest imagingTest = (ImagingTest) this.findById(ImagingTest.class, id);
    return imagingTest;
  }
  
  
  
  public LabTest findLabTestById(int id) throws Exception {
    LabTest labTest = (LabTest) this.findById(LabTest.class, id);
    return labTest;
  }
  
  
  public DrugItem findDrugItemById(int id) throws Exception {
    DrugItem drugItem = (DrugItem) this.findById(DrugItem.class, id);
    return drugItem;
  }
  
  
  public DentalProcedure findDentalProcedureById(int id) throws Exception {
    DentalProcedure proc = (DentalProcedure) this.findById(DentalProcedure.class, id);
    return proc;
  }
  
  
  
  public DxCode findDxCodeById(int id) throws Exception {
    DxCode dxCode = (DxCode) this.findById(DxCode.class, id);
    return dxCode;
  }
  
  
  
  public DMECode findDMECodeById(int id) throws Exception {
    DMECode dmeCode = (DMECode) this.findById(DMECode.class, id);
    return dmeCode;
  }
  
  
  
  public TxCode findTxCodeById(int id) throws Exception {
    TxCode txCode = (TxCode) this.findById(TxCode.class, id);
    return txCode;
  }
  
  
  
  public Gender findGenderByCode(String code) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(Gender.class);
    crit.add(Restrictions.eq("code", code));
    return (Gender)crit.uniqueResult();
  }
  
  
  
  public ServiceEventOrdinal findServiceEventOrdinalById(int id) throws Exception {
    return (ServiceEventOrdinal) this.findById(ServiceEventOrdinal.class, id);
  }
  
  
  
  public Race findRaceById(int id ) throws Exception {
    return (Race) this.findById(Race.class, id);
  }
  
  
  
  public Disposition findDispositionById(int id ) throws Exception {
    return (Disposition) this.findById(Disposition.class, id);
  }
  
  
  
  public TriageCode findTriageCodeById(int id ) throws Exception {
    return (TriageCode) this.findById(TriageCode.class, id);
  }
  
  
  
  public MDB findMDBById(int id ) throws Exception {
    return (MDB) this.findById(MDB.class, id);
  }
  
  
  
  public Ethnicity findEthnicityById(int id ) throws Exception {
    return (Ethnicity) this.findById(Ethnicity.class, id);
  }
  
  
  
  public MaritalStatus findMaritalStatusByCode(String code) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(MaritalStatus.class);
    crit.add(Restrictions.eq("code", code));
    return (MaritalStatus)crit.uniqueResult();
  }
  
  public Country findCountryByName(String name) throws Exception {
    Session session = getSession();
    Criteria crit = session.createCriteria(Country.class);
    crit.add(Restrictions.eq("name", name));
    return (Country)crit.uniqueResult();
  }
  
  
  public Patient findPatientByMrn(String mrn) throws Exception {
	 Session session = getSession();
	 Criteria crit = session.createCriteria(Credentials.class);
	 crit.add(Restrictions.eq("mrn", mrn));
	 Credentials cred = (Credentials)crit.uniqueResult();
	 Patient patient = (Patient) this.findById(Patient.class, cred.getPatientId());
	 return patient;
  }
  
  
  public Country findCountryById(int id ) throws Exception {
    return (Country) this.findById(Country.class, id);
  }

  public  List<VisitType> getVisitTypes() throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(VisitType.class);
    List<VisitType> list = crit.list();
    return list;
  }
  
  public  List<ServiceCategory> getServiceCategorys() throws Exception {
    Session session = this.getSession();
    Criteria crit = session.createCriteria(ServiceCategory.class);
    List<ServiceCategory> list = crit.list();
    return list;
  }
  
}
