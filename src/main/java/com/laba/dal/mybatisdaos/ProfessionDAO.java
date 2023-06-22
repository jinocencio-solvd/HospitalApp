package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IProfessionDAO;
import com.laba.models.Profession;
import java.util.List;

public class ProfessionDAO extends EntityDAO<Profession> implements IProfessionDAO {

    @Override
    public List<Profession> getProfessionByDepartmentId(int departmentId) {
        return session.getMapper(IProfessionDAO.class).getProfessionByDepartmentId(departmentId);
    }

}
