package com.laba.dal.jdbcdaos;

import com.laba.interfaces.daos.IMedicationTypeDAO;
import com.laba.models.MedicationType;
import java.util.List;

public class MedicationTypeDAO extends EntityDAO<MedicationType> implements IMedicationTypeDAO {

    @Override
    protected String getTableName() {
        return "medication_types";
    }

    @Override
    public List<MedicationType> getMedicationTypesByClinicianId(int clinicianId) {
        String query = "SELECT *\n"
            + "FROM medication_types\n"
            + "JOIN medications m on medication_types.id = m.medication_types_id\n"
            + "JOIN prescriptions p on m.id = p.medication_id\n"
            + "JOIN medical_records mr on p.treatment_id = mr.treatment_id\n"
            + "JOIN appointments a on a.id = mr.appointment_id\n"
            + "JOIN clinicians c on c.id = a.clinician_id\n"
            + "WHERE c.id = " + clinicianId;
        return retrieveEntities(query);
    }

}
