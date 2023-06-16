package com.laba.services;

import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.AppointmentDAO;
import com.laba.jdbc.DAOFactory;
import com.laba.models.Appointment;
import java.util.List;

public class AppointmentService implements IEntityService<Appointment> {

    private final AppointmentDAO appointmentDAO = DAOFactory.getJDBCDAO("appointment");

    @Override
    public List<Appointment> getAll() {
        return appointmentDAO.getAll();
    }

    @Override
    public Appointment getById(int id) {
        return appointmentDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        appointmentDAO.deleteById(id);
    }

    @Override
    public void save(Appointment entity) {
        appointmentDAO.save(entity);
    }

    @Override
    public void update(Appointment entity) {
        appointmentDAO.update(entity);
    }
}
