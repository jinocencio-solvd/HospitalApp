package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IRoomDAO;
import com.laba.models.Room;
import java.util.List;

public class RoomDAO extends EntityDAO<Room> implements IRoomDAO {

    @Override
    protected String getTableName() {
        return "rooms";
    }

    @Override
    public List<Room> getRoomsByDepartmentId(int departmentId) {
        String query = "SELECT *\n"
            + "FROM rooms\n"
            + "JOIN departments d ON d.id = rooms.department_id\n"
            + "WHERE d.id = " + departmentId;
        return retrieveEntities(query);
    }

}
