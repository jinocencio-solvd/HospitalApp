package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.ISpecializationDAO;
import com.laba.models.Specialization;

public class SpecializationDAO extends EntityDAO<Specialization> implements ISpecializationDAO {

    @Override
    protected String getTableName() {
        return "specializations";
    }
}
