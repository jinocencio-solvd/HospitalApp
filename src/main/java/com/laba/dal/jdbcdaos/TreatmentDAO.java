package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.ITreatmentDAO;
import com.laba.models.Treatment;

public class TreatmentDAO extends EntityDAO<Treatment> implements ITreatmentDAO {

    @Override
    protected String getTableName() {
        return "treatments";
    }
}
