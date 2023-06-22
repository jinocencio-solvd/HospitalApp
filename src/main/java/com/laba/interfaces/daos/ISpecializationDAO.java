package com.laba.interfaces.daos;

import com.laba.models.Specialization;

public interface ISpecializationDAO extends IEntityDAO<Specialization> {

    Specialization getSpecializationByClinicianId(int clinicianId);

}
