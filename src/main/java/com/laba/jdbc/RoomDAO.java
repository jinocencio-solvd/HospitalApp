package com.laba.jdbc;

import com.laba.models.Room;

public class RoomDAO extends EntityDAO<Room>{

    @Override
    protected String getTableName() {
        return "rooms";
    }
}
