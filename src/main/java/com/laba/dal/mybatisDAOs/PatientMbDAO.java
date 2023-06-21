package com.laba.dal.mybatisDAOs;

import com.laba.interfaces.daos.IPatientDAO;
import com.laba.models.Patient;
import com.laba.utils.mybatis.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;

public class PatientMbDAO extends EntityMbDAO<Patient> implements IPatientDAO {

    @Override
    public Patient getPatientByPersonId(int personId) {
        return session.selectOne(getNamespace() + ".getPatientByPersonId", personId);
    }
}
