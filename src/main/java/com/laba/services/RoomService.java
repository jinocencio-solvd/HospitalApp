package com.laba.services;

import com.laba.interfaces.services.IEntityService;
import com.laba.jdbc.DAOFactory;
import com.laba.jdbc.RoomDAO;
import com.laba.models.Room;
import java.util.List;

public class RoomService implements IEntityService<Room> {

    private final RoomDAO roomDAO = DAOFactory.getJDBCDAO("room");

    @Override
    public List<Room> getAll() {
        return roomDAO.getAll();
    }

    @Override
    public Room getById(int id) {
        return roomDAO.getById(id);
    }

    @Override
    public void deleteById(int id) {
        roomDAO.deleteById(id);
    }

    @Override
    public void save(Room entity) {
        roomDAO.save(entity);
    }

    @Override
    public void update(Room entity) {
        roomDAO.update(entity);
    }
}
