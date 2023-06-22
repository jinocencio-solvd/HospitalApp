package com.laba.dal.mybatisdaos;

import com.laba.interfaces.daos.IRoomDAO;
import com.laba.models.Room;
import java.util.List;

public class RoomDAO extends EntityDAO<Room> implements IRoomDAO {

    @Override
    public List<Room> getRoomsByDepartmentId(int departmentId) {
        return session.getMapper(IRoomDAO.class).getRoomsByDepartmentId(departmentId);
    }

}
