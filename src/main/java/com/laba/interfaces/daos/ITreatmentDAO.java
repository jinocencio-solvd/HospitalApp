package com.laba.interfaces.daos;

import com.laba.models.Treatment;
import java.util.List;

public interface ITreatmentDAO extends IEntityDAO<Treatment> {

    List<Treatment> getTreatmentsByPatientId(int patientId);

}
