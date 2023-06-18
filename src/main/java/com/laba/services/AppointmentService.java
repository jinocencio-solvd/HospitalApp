package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IAppointmentDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.AppointmentDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.mybatisDAOs.AppointmentMbDAO;
import com.laba.models.Appointment;
import java.util.List;

public class AppointmentService implements IEntityService<Appointment> {

    private static IAppointmentDAO dao;

    public AppointmentService(DaoType daoType) {
        String model = "appointment";
        switch (daoType) {
            case JDBC:
                dao = (AppointmentDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (AppointmentMbDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Appointment> getAll() {
        return dao.getAll();
    }

    @Override
    public Appointment getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Appointment entity) {
        dao.save(entity);
    }

    @Override
    public void update(Appointment entity) {
        dao.update(entity);
    }
}
