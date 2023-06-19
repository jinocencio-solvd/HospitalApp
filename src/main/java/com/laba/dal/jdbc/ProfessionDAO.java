package com.laba.dal.jdbc;

import com.laba.interfaces.daos.IProfessionDAO;
import com.laba.models.Profession;

public class ProfessionDAO extends EntityDAO<Profession> implements IProfessionDAO {

    @Override
    protected String getTableName() {
        return "professions";
    }
}
