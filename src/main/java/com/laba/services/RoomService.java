package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IRoomDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.mybatisdaos.RoomDAO;
import com.laba.models.Room;
import java.util.List;

public class RoomService implements IEntityService<Room> {

    private static IRoomDAO dao;

    public RoomService(DaoType daoType) {
        String model = "room";
        switch (daoType) {
            case JDBC:
                dao = (com.laba.dal.jdbcdaos.RoomDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (RoomDAO) DAOFactory.getMyBatisDAO(model);
                break;
        }
    }

    @Override
    public List<Room> getAll() {
        return dao.getAll();
    }

    @Override
    public Room getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void save(Room entity) {
        dao.save(entity);
    }

    @Override
    public void update(Room entity) {
        dao.update(entity);
    }
}
