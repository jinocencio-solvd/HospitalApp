package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IStaffDAO;
import com.laba.models.Staff;
import java.util.List;

public class StaffDAO extends EntityDAO<Staff> implements IStaffDAO {

    @Override
    protected String getTableName() {
        return "staff";
    }

    @Override
    public Staff getStaffByPersonId(int personId) {
        Staff staff = new Staff();
        String query = "SELECT * FROM " + getTableName() + " WHERE person_id = " + personId;
        return retrieveEntity(query, staff) ;
    }

    @Override
    public List<Staff> getStaffByDepartmentId(int departmentId) {
        String query = "SELECT *\n"
            + "FROM staff\n"
            + "JOIN clinicians c on staff.id = c.staff_id\n"
            + "JOIN appointments a on c.id = a.clinician_id\n"
            + "JOIN rooms r on r.id = a.room_id\n"
            + "JOIN departments d on d.id = r.department_id\n"
            + "WHERE d.id = " + departmentId;
        return retrieveEntities(query);
    }

}
