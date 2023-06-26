package com.laba.dal.daofactories;


import com.laba.interfaces.daos.IEntityDAO;

public abstract class AbstractDAOFactory {

    public abstract IEntityDAO<?> getDAO(String type);

}
