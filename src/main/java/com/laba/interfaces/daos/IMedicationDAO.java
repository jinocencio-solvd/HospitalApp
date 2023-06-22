package com.laba.interfaces.daos;

import com.laba.models.Medication;
import java.util.List;

public interface IMedicationDAO extends IEntityDAO<Medication> {

    List<Medication> getMedicationsByPatientId(int patientId);

}
