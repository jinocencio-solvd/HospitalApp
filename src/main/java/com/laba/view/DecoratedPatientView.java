package com.laba.view;

import com.laba.models.DecoratedPatient;

public class DecoratedPatientView extends EntityView<DecoratedPatient> {

    public void simplePatientMedicalRecordsSysOutView(String data) {
        System.out.println("Simplified Medical Record:");
        System.out.println(data);
    }

}
