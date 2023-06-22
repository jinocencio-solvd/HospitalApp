package com.laba.interfaces.daos;


import com.laba.models.Profession;
import java.util.List;

public interface IProfessionDAO extends IEntityDAO<Profession> {

    List<Profession> getProfessionByDepartmentId(int departmentId);

}
