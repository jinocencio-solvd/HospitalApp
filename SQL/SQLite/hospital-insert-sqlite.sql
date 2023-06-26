INSERT INTO persons (id, first_name, last_name, dob)
VALUES (1, 'Michael', 'Scott', '1970-03-15'),
       (2, 'Creed', 'Bratton', '1943-02-08'),
       (3, 'Kevin', 'Malone', '1968-06-15'),
       (4, 'Jim', 'Halpert', '1978-10-01'),
       (5, 'Pam', 'Beesly', '1979-03-25'),
       (6, 'Dwight', 'Schrute', '1970-01-20'),
       (7, 'Angela', 'Martin', '1971-11-11'),
       (8, 'Andy', 'Bernard', '1973-07-22'),
       (9, 'Stanley', 'Hudson', '1958-02-19'),
       (10, 'Phyllis', 'Vance', '1965-08-15'),
       (11, 'Oscar', 'Martinez', '1972-09-15'),
       (12, 'Kelly', 'Kapoor', '1980-02-05'),
       (13, 'Drake', 'Ramoray', '1970-12-01'),
       (14, 'Rachel', 'Green', '1969-05-05'),
       (15, 'Monica', 'Geller', '1970-04-22'),
       (16, 'Phoebe', 'Buffay', '1967-07-16'),
       (17, 'Joey', 'Tribbiani', '1968-12-29'),
       (18, 'Chandler', 'Bing', '1967-04-08'),
       (19, 'Ross', 'Geller', '1966-10-18');


INSERT INTO patients (person_id)
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (11),
       (12);


INSERT INTO staff (person_id)
VALUES (13),
       (14),
       (15),
       (16),
       (17),
       (18),
       (19);


INSERT INTO specializations (specialization)
VALUES ('Cardiology'),
       ('Orthopedics'),
       ('General Medicine'),
       ('Infectious Diseases');


INSERT INTO professions (profession)
VALUES ('Physician'),
       ('Nurse'),
       ('Therapist'),
       ('Administration');


INSERT INTO clinicians (staff_id, specialization_id, profession_id)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1),
       (4, 4, 1),
       (5, 1, 1),
       (6, 2, 2),
       (7, 3, 3);


INSERT INTO departments (department_name)
VALUES ('Cardiology'),
       ('Orthopedics'),
       ('Outpatient');


INSERT INTO rooms (room_number, department_id)
VALUES ('101', 1),
       ('102', 1),
       ('103', 1),
       ('201', 2),
       ('202', 2),
       ('203', 2),
       ('301', 3),
       ('302', 3),
       ('303', 3);


INSERT INTO appointments (patient_id, clinician_id, room_id, appointment_date, appointment_time)
VALUES (1, 1, 1, '2023-06-01', '09:00:00'),
       (1, 1, 3, '2023-06-03', '09:00:00'),
       (1, 1, 1, '2023-06-05', '09:00:00'),
       (1, 1, 2, '2023-06-09', '09:00:00'),
       (2, 2, 2, '2023-06-02', '10:30:00'),
       (3, 3, 3, '2023-06-03', '11:00:00'),
       (4, 4, 4, '2023-06-04', '13:30:00'),
       (5, 5, 5, '2023-06-05', '10:00:00'),
       (6, 6, 6, '2023-06-06', '09:30:00'),
       (7, 7, 7, '2023-06-07', '12:00:00'),
       (8, 1, 8, '2023-06-08', '11:30:00'),
       (9, 2, 9, '2023-06-09', '14:00:00'),
       (10, 3, 1, '2023-06-10', '08:30:00'),
       (11, 4, 2, '2023-06-11', '10:00:00'),
       (12, 5, 3, '2023-06-12', '12:30:00');


INSERT INTO diagnosis (diagnosis_code, description)
VALUES ('D001', 'Non-Diagnosable'),
       ('D001', 'Hypertension'),
       ('D002', 'Fractured leg');


INSERT INTO treatments (id, treatment_name)
VALUES (1, 'No Treatment'),
       (2, 'Medication'),
       (3, 'Surgery'),
       (4, 'Lifestyle'),
       (5, 'Chemotherapy'),
       (6, 'Physical Therapy'),
       (7, 'Speech Therapy'),
       (8, 'Dietary'),
       (9, 'Dialysis'),
       (10, 'Rehabilitation');


INSERT INTO medical_records (appointment_id, diagnosis_id, treatment_id)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 2, 2),
       (4, 2, 4),
       (5, 1, 1),
       (6, 2, 2),
       (7, 3, 3),
       (8, 2, 3),
       (9, 2, 3),
       (10, 2, 3),
       (11, 1, 1),
       (12, 2, 3);


INSERT INTO medication_types (medication_type)
VALUES ('NSAIDs'),
       ('Antibiotics'),
       ('Analgesics'),
       ('Vaccines');


INSERT INTO medications (medication_name, medication_types_id)
VALUES ('Aspirin', 1),
       ('Ibuprofen', 1),
       ('Amoxicillin', 2),
       ('Influenza Vaccine', 4);


INSERT INTO prescriptions (id, treatment_id, medication_id, dosage, prescription_start_date,
                           prescription_expiration_date)
VALUES (1, 1, 1, '1 tablet daily', '2023-06-01', '2023-06-30'),
       (2, 2, 2, '2 tablets twice a day', '2023-06-01', '2023-06-30'),
       (3, 1, 1, '1 tablet daily', '2023-06-01', '2023-06-30'),
       (4, 1, 2, '2 tablets twice a day', '2023-06-01', '2023-06-30');
