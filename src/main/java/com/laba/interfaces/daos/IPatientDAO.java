package com.laba.interfaces.daos;

import com.laba.models.Patient;

public interface IPatientDAO extends IEntityDAO<Patient> {
    Patient getPatientByPersonId(int personId);
}
