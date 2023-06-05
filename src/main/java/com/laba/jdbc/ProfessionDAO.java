package com.laba.jdbc;

import com.laba.model.Profession;

public class ProfessionDAO extends EntityDAO<Profession>{

    @Override
    protected String getTableName() {
        return "professions";
    }
}
