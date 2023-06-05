package com.laba.jdbc;

import com.laba.model.Room;

public class RoomDAO extends EntityDAO<Room>{

    @Override
    protected String getTableName() {
        return "rooms";
    }
}
