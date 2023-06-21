package com.laba.dal.mybatisDAOs;

import com.laba.interfaces.daos.IAppointmentDAO;
import com.laba.models.Appointment;
import com.laba.utils.mybatis.MyBatisSqlFactory;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class AppointmentMbDAO extends EntityMbDAO<Appointment> implements IAppointmentDAO {

    @Override
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return session.selectList(getNamespace() + ".getAppointmentsByPatientId", patientId);
    }
}
