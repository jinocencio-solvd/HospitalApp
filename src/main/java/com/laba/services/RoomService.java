package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IRoomDAO;
import com.laba.models.Room;

public class RoomService extends EntityService<Room, IRoomDAO> implements
    IRoomDAO {

    public RoomService(DaoType daoType) {
        super(daoType);
    }

    @Override
    protected String getModelName() {
        return "room";
    }

}
