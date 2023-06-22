package com.laba.interfaces.daos;

import com.laba.models.Prescription;
import java.util.List;

public interface IPrescriptionDAO extends IEntityDAO<Prescription> {

    List<Prescription> getPrescriptionsByPatientId(int patientId);

}
