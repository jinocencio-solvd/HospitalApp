package com.laba.services;

import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.StaffDAO;
import com.laba.models.Staff;
import java.util.List;

public class StaffService implements IEntityService<Staff> {

    private final StaffDAO staffDAO = DAOFactory.getJDBCDAO("staff");

    @Override
    public List<Staff> getAll() {
        return staffDAO.getAll();
    }

    @Override
    public Staff getById(int id) {
        return staffDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        staffDAO.deleteById(id);
    }

    @Override
    public void save(Staff entity) {
        staffDAO.save(entity);
    }

    @Override
    public void update(Staff entity) {
        staffDAO.update(entity);
    }
}
