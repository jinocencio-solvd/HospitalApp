package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IPrescriptionDAO;
import com.laba.models.Prescription;

public class PrescriptionDAO extends EntityDAO<Prescription> implements IPrescriptionDAO {

    @Override
    protected String getTableName() {
        return "prescriptions";
    }
}