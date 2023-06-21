package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IMedicalRecordDAO;
import com.laba.models.MedicalRecord;
import com.laba.models.Patient;
import com.laba.utils.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordDAO extends EntityDAO<MedicalRecord> implements IMedicalRecordDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    protected String getTableName() {
        return "medical_records";
    }

    public List<MedicalRecord> getMedicalRecordsForPatient(Patient p) {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        Map<String, String> columnMap = new LinkedHashMap<>();
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM " + getTableName()
            + " JOIN appointments a on a.id = medical_records.appointment_id"
            + " JOIN patients p on p.id = a.patient_id"
            + " WHERE p.id = ?;";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, p.getId());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    columnMap.put(columnName, rs.getString(columnName));
                }
                MedicalRecord toAdd = createModelFromMap(columnMap);
                medicalRecords.add(toAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecords;
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByAppointmentId(int appointmentId) {
        // TODO: impl JDBC method
        return null;
    }
}
