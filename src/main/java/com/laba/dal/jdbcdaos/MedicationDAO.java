package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IMedicationDAO;
import com.laba.models.Medication;

public class MedicationDAO extends EntityDAO<Medication> implements IMedicationDAO {

    @Override
    protected String getTableName() {
        return "medications";
    }

}
