package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IRoomDAO;
import com.laba.models.Room;

public class RoomDAO extends EntityDAO<Room> implements IRoomDAO {

    @Override
    protected String getTableName() {
        return "rooms";
    }
}