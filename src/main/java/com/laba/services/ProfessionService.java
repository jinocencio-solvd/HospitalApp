package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IProfessionDAO;
import com.laba.models.Profession;
import java.util.List;

public class ProfessionService extends EntityService<Profession, IProfessionDAO> implements
    IProfessionDAO {

    public ProfessionService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "profession";
    }

    @Override
    public List<Profession> getProfessionByDepartmentId(int departmentId) {
        return dao.getProfessionByDepartmentId(departmentId);
    }

}
