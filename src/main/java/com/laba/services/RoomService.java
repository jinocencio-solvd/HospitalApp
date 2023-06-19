package com.laba.services;

import com.laba.enums.DaoType;
import com.laba.interfaces.daos.IRoomDAO;
import com.laba.interfaces.services.IEntityService;
import com.laba.dal.DAOFactory;
import com.laba.dal.jdbc.RoomDAO;
import com.laba.dal.mybatisDAOs.RoomMbDAO;
import com.laba.models.Room;
import java.util.List;

public class RoomService implements IEntityService<Room> {

    private static IRoomDAO dao;

    public RoomService(DaoType daoType) {
        String model = "room";
        switch (daoType) {
            case JDBC:
                dao = (RoomDAO) DAOFactory.getJDBCDAO(model);
                break;
            case MYBATIS:
                dao = (RoomMbDAO) DAOFactory.getMyBatisDAO(model);
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
