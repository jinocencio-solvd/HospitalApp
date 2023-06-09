
DROP SCHEMA IF EXISTS `hospital`;

CREATE SCHEMA IF NOT EXISTS `hospital` DEFAULT CHARACTER SET latin1;
USE `hospital`;

DROP TABLE IF EXISTS `hospital`.`persons`;

CREATE TABLE IF NOT EXISTS `hospital`.`persons`
(
    `id`         INT(11)     NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name`  VARCHAR(50) NOT NULL,
    `dob`        DATE        NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`patients`;

CREATE TABLE IF NOT EXISTS `hospital`.`patients`
(
    `id`        INT(11) NOT NULL AUTO_INCREMENT,
    `person_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `person_id` (`person_id` ASC),
    CONSTRAINT `patients_ibfk_1`
        FOREIGN KEY (`person_id`)
            REFERENCES `hospital`.`persons` (`id`)
            ON UPDATE CASCADE
            ON DELETE CASCADE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;

DROP TABLE IF EXISTS `hospital`.`staff`;

CREATE TABLE IF NOT EXISTS `hospital`.`staff`
(
    `id`        INT(11) NOT NULL AUTO_INCREMENT,
    `person_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `person_id` (`person_id` ASC),
    CONSTRAINT `staff_ibfk_1`
        FOREIGN KEY (`person_id`)
            REFERENCES `hospital`.`persons` (`id`)
            ON UPDATE CASCADE
            ON DELETE CASCADE
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`professions`;

CREATE TABLE IF NOT EXISTS `hospital`.`professions`
(
    `id`         INT(11)     NOT NULL AUTO_INCREMENT,
    `profession` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


DROP TABLE IF EXISTS `hospital`.`specializations`;

CREATE TABLE IF NOT EXISTS `hospital`.`specializations`
(
    `id`             INT(11)     NOT NULL AUTO_INCREMENT,
    `specialization` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


DROP TABLE IF EXISTS `hospital`.`clinicians`;

CREATE TABLE IF NOT EXISTS `hospital`.`clinicians`
(
    `id`                INT(11) NOT NULL AUTO_INCREMENT,
    `staff_id`          INT(11) NOT NULL,
    `profession_id`     INT(11) NOT NULL,
    `specialization_id` INT(11) NULL,
    PRIMARY KEY (`id`),
    INDEX `staff_id` (`staff_id` ASC),
    INDEX `fk_clinicians_professions1_idx` (`profession_id` ASC),
    INDEX `fk_clinicians_specializations1_idx` (`specialization_id` ASC),
    CONSTRAINT `clinicians_ibfk_1`
        FOREIGN KEY (`staff_id`)
            REFERENCES `hospital`.`staff` (`id`)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    CONSTRAINT `fk_clinicians_professions1`
        FOREIGN KEY (`profession_id`)
            REFERENCES `hospital`.`professions` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_clinicians_specializations1`
        FOREIGN KEY (`specialization_id`)
            REFERENCES `hospital`.`specializations` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`departments`;

CREATE TABLE IF NOT EXISTS `hospital`.`departments`
(
    `id`              INT(11)      NOT NULL AUTO_INCREMENT,
    `department_name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`rooms`;

CREATE TABLE IF NOT EXISTS `hospital`.`rooms`
(
    `id`            INT(11)     NOT NULL AUTO_INCREMENT,
    `room_number`   VARCHAR(10) NOT NULL,
    `department_id` INT(11)     NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `department_id` (`department_id` ASC),
    CONSTRAINT `rooms_ibfk_1`
        FOREIGN KEY (`department_id`)
            REFERENCES `hospital`.`departments` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`appointments`;

CREATE TABLE IF NOT EXISTS `hospital`.`appointments`
(
    `id`               INT(11) NOT NULL AUTO_INCREMENT,
    `patient_id`       INT(11) NOT NULL,
    `clinician_id`     INT(11) NOT NULL,
    `room_id`          INT(11) NOT NULL,
    `appointment_date` DATE    NOT NULL,
    `appointment_time` TIME    NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `patient_id` (`patient_id` ASC),
    INDEX `clinician_id` (`clinician_id` ASC),
    INDEX `room_id` (`room_id` ASC),
    CONSTRAINT `appointments_ibfk_1`
        FOREIGN KEY (`patient_id`)
            REFERENCES `hospital`.`patients` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION,
    CONSTRAINT `appointments_ibfk_2`
        FOREIGN KEY (`clinician_id`)
            REFERENCES `hospital`.`clinicians` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION,
    CONSTRAINT `appointments_ibfk_3`
        FOREIGN KEY (`room_id`)
            REFERENCES `hospital`.`rooms` (`id`)
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`diagnosis`;

CREATE TABLE IF NOT EXISTS `hospital`.`diagnosis`
(
    `id`             INT(11)      NOT NULL AUTO_INCREMENT,
    `diagnosis_code` VARCHAR(20)  NOT NULL,
    `description`    VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`treatments`;

CREATE TABLE IF NOT EXISTS `hospital`.`treatments`
(
    `id`             INT(11)      NOT NULL AUTO_INCREMENT,
    `treatment_name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`medical_records`;

CREATE TABLE IF NOT EXISTS `hospital`.`medical_records`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `appointment_id` INT(11) NOT NULL,
    `diagnosis_id`   INT(11) NOT NULL,
    `treatment_id`   INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `diagnosis_id` (`diagnosis_id` ASC),
    INDEX `treatment_id` (`treatment_id` ASC),
    INDEX `fk_medical_records_appointments1_idx` (`appointment_id` ASC),
    CONSTRAINT `medical_records_ibfk_2`
        FOREIGN KEY (`diagnosis_id`)
            REFERENCES `hospital`.`diagnosis` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION,
    CONSTRAINT `medical_records_ibfk_3`
        FOREIGN KEY (`treatment_id`)
            REFERENCES `hospital`.`treatments` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION,
    CONSTRAINT `fk_medical_records_appointments1`
        FOREIGN KEY (`appointment_id`)
            REFERENCES `hospital`.`appointments` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;


DROP TABLE IF EXISTS `hospital`.`medication_types`;

CREATE TABLE IF NOT EXISTS `hospital`.`medication_types`
(
    `id`              INT         NOT NULL AUTO_INCREMENT,
    `medication_type` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


DROP TABLE IF EXISTS `hospital`.`medications`;

CREATE TABLE IF NOT EXISTS `hospital`.`medications`
(
    `id`                  INT(11)      NOT NULL AUTO_INCREMENT,
    `medication_name`     VARCHAR(100) NOT NULL,
    `medication_types_id` INT          NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_medications_medication_types1_idx` (`medication_types_id` ASC),
    CONSTRAINT `fk_medications_medication_types1`
        FOREIGN KEY (`medication_types_id`)
            REFERENCES `hospital`.`medication_types` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;

DROP TABLE IF EXISTS `hospital`.`prescriptions`;

CREATE TABLE IF NOT EXISTS `hospital`.`prescriptions`
(
    `id`                           INT(11)     NOT NULL AUTO_INCREMENT,
    `treatment_id`                 INT(11)     NOT NULL,
    `medication_id`                INT(11)     NOT NULL,
    `dosage`                       VARCHAR(50) NOT NULL,
    `prescription_start_date`      DATE        NOT NULL,
    `prescription_expiration_date` DATE        NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `treatment_id` (`treatment_id` ASC),
    INDEX `medication_id` (`medication_id` ASC),
    CONSTRAINT `prescriptions_ibfk_1`
        FOREIGN KEY (`treatment_id`)
            REFERENCES `hospital`.`treatments` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION,
    CONSTRAINT `prescriptions_ibfk_2`
        FOREIGN KEY (`medication_id`)
            REFERENCES `hospital`.`medications` (`id`)
            ON UPDATE CASCADE
            ON DELETE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1;