package com.laba.dal.jdbc;

import com.laba.interfaces.daos.IMedicationTypeDAO;
import com.laba.models.MedicationType;

public class MedicationTypeDAO extends EntityDAO<MedicationType> implements IMedicationTypeDAO {

    @Override
    protected String getTableName() {
        return "medication_types";
    }

}
