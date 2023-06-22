package com.laba.interfaces.daos;

import com.laba.models.Room;
import java.util.List;

public interface IRoomDAO extends IEntityDAO<Room> {

    List<Room> getRoomsByDepartmentId(int departmentId);

}
