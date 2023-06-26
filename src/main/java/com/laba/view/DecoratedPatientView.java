package com.laba.view;

import com.laba.models.DecoratedPatient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DecoratedPatientView extends EntityView<DecoratedPatient> {
    private static final Logger LOG = LogManager.getLogger(DecoratedPatientView.class);

    public void simplePatientMedicalRecordsSysOutView(String data) {
        LOG.info("Simplified Medical Record:");
        LOG.info(data);
    }

}
