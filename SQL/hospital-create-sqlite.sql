DROP TABLE IF EXISTS `persons`;
CREATE TABLE IF NOT EXISTS `persons`
(
    `id`         INTEGER  PRIMARY KEY AUTOINCREMENT,
    `first_name` TEXT     NOT NULL,
    `last_name`  TEXT     NOT NULL,
    `dob`        DATE     NOT NULL
);

DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients`
(
    `id`        INTEGER  PRIMARY KEY AUTOINCREMENT,
    `person_id` INTEGER  NOT NULL,
    FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff`
(
    `id`        INTEGER  PRIMARY KEY AUTOINCREMENT,
    `person_id` INTEGER  NOT NULL,
    FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS `professions`;
CREATE TABLE IF NOT EXISTS `professions`
(
    `id`         INTEGER  PRIMARY KEY AUTOINCREMENT,
    `profession` TEXT     NULL
);

DROP TABLE IF EXISTS `specializations`;
CREATE TABLE IF NOT EXISTS `specializations`
(
    `id`             INTEGER  PRIMARY KEY AUTOINCREMENT,
    `specialization` TEXT     NULL
);

DROP TABLE IF EXISTS `clinicians`;
CREATE TABLE IF NOT EXISTS `clinicians`
(
    `id`                INTEGER  PRIMARY KEY AUTOINCREMENT,
    `staff_id`          INTEGER  NOT NULL,
    `profession_id`     INTEGER  NOT NULL,
    `specialization_id` INTEGER  NULL,
    FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`profession_id`) REFERENCES `professions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (`specialization_id`) REFERENCES `specializations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS `departments`;
CREATE TABLE IF NOT EXISTS `departments`
(
    `id`              INTEGER       PRIMARY KEY AUTOINCREMENT,
    `department_name` VARCHAR(100)  NOT NULL
);

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE IF NOT EXISTS `rooms`
(
    `id`            INTEGER       PRIMARY KEY AUTOINCREMENT,
    `room_number`   VARCHAR(10)   NOT NULL,
    `department_id` INTEGER       NOT NULL,
    FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION
);

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE IF NOT EXISTS `appointments`
(
    `id`               INTEGER       PRIMARY KEY AUTOINCREMENT,
    `patient_id`       INTEGER       NOT NULL,
    `clinician_id`     INTEGER       NOT NULL,
    `room_id`          INTEGER       NOT NULL,
    `appointment_date` TEXT          NOT NULL,
    `appointment_time` TEXT          NOT NULL,
    FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (`clinician_id`) REFERENCES `clinicians` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE IF NOT EXISTS `diagnosis`
(
    `id`             INTEGER      PRIMARY KEY AUTOINCREMENT,
    `diagnosis_code` VARCHAR(20)  NOT NULL,
    `description`    VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `treatments`;
CREATE TABLE IF NOT EXISTS `treatments`
(
    `id`             INTEGER      PRIMARY KEY AUTOINCREMENT,
    `treatment_name` VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS `medical_records`;
CREATE TABLE IF NOT EXISTS `medical_records`
(
    `id`             INTEGER       PRIMARY KEY AUTOINCREMENT,
    `appointment_id` INTEGER       NOT NULL,
    `diagnosis_id`   INTEGER       NOT NULL,
    `treatment_id`   INTEGER       NOT NULL,
    FOREIGN KEY (`diagnosis_id`) REFERENCES `diagnosis` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (`treatment_id`) REFERENCES `treatments` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS `medication_types`;
CREATE TABLE IF NOT EXISTS `medication_types`
(
    `id`              INTEGER       PRIMARY KEY AUTOINCREMENT,
    `medication_type` VARCHAR(45)   NOT NULL
);

DROP TABLE IF EXISTS `medications`;
CREATE TABLE IF NOT EXISTS `medications`
(
    `id`                  INTEGER       PRIMARY KEY AUTOINCREMENT,
    `medication_name`     VARCHAR(100)  NOT NULL,
    `medication_types_id` INTEGER       NOT NULL,
    FOREIGN KEY (`medication_types_id`) REFERENCES `medication_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS `prescriptions`;
CREATE TABLE IF NOT EXISTS `prescriptions`
(
    `id`                           INTEGER       PRIMARY KEY AUTOINCREMENT,
    `treatment_id`                 INTEGER       NOT NULL,
    `medication_id`                INTEGER       NOT NULL,
    `dosage`                       VARCHAR(50)   NOT NULL,
    `prescription_start_date`      TEXT          NOT NULL,
    `prescription_expiration_date` TEXT          NOT NULL,
    FOREIGN KEY (`treatment_id`) REFERENCES `treatments` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (`medication_id`) REFERENCES `medications` (`id`) ON UPDATE CASCADE ON DELETE NO ACTION
);

PRAGMA foreign_keys = ON;
