package com.laba.jdbc;

import com.laba.model.Appointment;
import java.util.Map;

public class AppointmentsDAO extends EntityDAO<Appointment> {

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected Appointment createModelFromMap(Map<String, String> columnMap) {
        return null;
    }

    @Override
    protected Map<String, Object> mapEntityToModelGetters(Appointment entity) {
        return null;
    }
}
