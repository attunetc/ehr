package com.wdeanmedical.ehr.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wdeanmedical.ehr.entity.Appointment;
import com.wdeanmedical.ehr.entity.CPT;
import com.wdeanmedical.ehr.entity.CPTModifier;
import com.wdeanmedical.ehr.entity.Clinician;
import com.wdeanmedical.ehr.entity.ICD10AM;
import com.wdeanmedical.ehr.entity.PatientMessage;

public class TerminologyDTO extends AuthorizedDTO {
  private String searchText;
  private List<ICD10AM> icd10AMList;
  private List<CPT> cptList;
  private List<CPTModifier> cptModifierList;

  public TerminologyDTO() {
  }
  
  public String getSearchText() { return searchText; }
  public void setSearchText(String searchText) { this.searchText = searchText; }

  public List<ICD10AM> getIcd10AMList() { return icd10AMList; }
  public void setIcd10AMList(List<ICD10AM> icd10AMList) { this.icd10AMList = icd10AMList; }
  
  public List<CPT> getCptList() { return cptList; }
  public void setCptList(List<CPT> cptList) { this.cptList = cptList; }
  
  public List<CPTModifier> getCptModifierList() { return cptModifierList; }
  public void setCptModifierList(List<CPTModifier> cptModifierList) { this.cptModifierList = cptModifierList; }
  
}
