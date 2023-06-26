package com.laba.interfaces.daos;

import com.laba.models.MedicationType;
import java.util.List;

public interface IMedicationTypeDAO extends IEntityDAO<MedicationType> {

    List<MedicationType> getMedicationTypesByClinicianId(int clinicianId);

}
