INSERT INTO organization(key_organization, full_name_organization, inn_organization, name_organization) VALUES (1, 'АСС Бизнес - Софт', '123123', 'АСС Бизнес - Софт');
INSERT INTO employee(key_employee, name_employee, patronymic_employee, surname_employee, key_organization) VALUES (1, 'Денис', 'Андреевич', 'Ваганов', 1);
INSERT INTO organization(key_organization, full_name_organization, inn_organization, name_organization) VALUES (2, 'Тестовая', '123123', 'Тестовая');
INSERT INTO employee(key_employee, name_employee, patronymic_employee, surname_employee, key_organization) VALUES (2, 'Тест', 'Тест', 'Тест', 2);

INSERT INTO tuser(userid_tuser, password_tuser, key_employee) VALUES ('admin', 'admin', 1);    
INSERT INTO tgroup(groupid_tgroup, userid_tuser) VALUES ('admin', 'admin');

INSERT INTO tuser(userid_tuser, password_tuser, key_employee) VALUES ('user', 'user', 2);    
INSERT INTO tgroup(groupid_tgroup, userid_tuser) VALUES ('user', 'user');

INSERT INTO person(key_person, birthday_person, name_person, patronymic_person, surname_person, issue_date_passport_person, issue_passport_person, number_passport_person, registration_possport_person, serial_passport_person) VALUES (nextval('person_gen_id'), '12.12.12', 'Имя', 'Отчество', 'Фамилия', '11.11.11', 'Выдан', '123123', 'регистрация', '123123');
INSERT INTO person(key_person, birthday_person, name_person, patronymic_person, surname_person, issue_date_passport_person, issue_passport_person, number_passport_person, registration_possport_person, serial_passport_person) VALUES (nextval('person_gen_id'), '12.12.12', 'Имя', 'Отчество', 'Фамилия', '11.11.11', 'Выдан', '123123', 'регистрация', '123123');         
INSERT INTO person(key_person, birthday_person, name_person, patronymic_person, surname_person, issue_date_passport_person, issue_passport_person, number_passport_person, registration_possport_person, serial_passport_person) VALUES (nextval('person_gen_id'), '12.12.12', 'Имя', 'Отчество', 'Фамилия', '11.11.11', 'Выдан', '123123', 'регистрация', '123123');

INSERT INTO person_organization(key_person_organization, key_organization, key_person) VALUES (nextval('person_organization_gen_id'), 1, 1);
INSERT INTO person_organization(key_person_organization, key_organization, key_person) VALUES (nextval('person_organization_gen_id'), 1, 2);
INSERT INTO person_organization(key_person_organization, key_organization, key_person) VALUES (nextval('person_organization_gen_id'), 1, 3);

INSERT INTO person_disability(key_person_disability, setting_date_person_disability, document_create_date_person_disability, document_number_person_disability, document_serial_person_disability, group_person_disability, limitation_date_person_disability, reason_person_disability, setting_type_person_disability, key_person) VALUES (nextval('PERSON_DISABILITY_GEN_ID'), '12.12.12', '12.12.12', '123123', '123123', 1, '12.12.12', 'Причина', 1, 1);

INSERT INTO income(key_income, name_income) VALUES (nextval('income_gen_id'), 'Пенсия');
INSERT INTO person_income(key_person_income, date_person_income, sum_person_income, key_income, key_person) VALUES (nextval('person_income_gen_id'), '12.12.12', 12.1, 1, 1);

INSERT INTO education(key_education, name_education) VALUES (nextval('education_gen_id'), 'Высшее');
INSERT INTO person_education(key_person_education, exp_date_person_education, institution_person_education, specialty_person_education, key_education, key_person) VALUES (nextval('person_education_gen_id'), '12.12.12', 'МИФИ', 'Электромонтер', 1, 1);

INSERT INTO profession(key_profession, name_profession) VALUES (nextval('profession_gen_id'), 'Плотник');
INSERT INTO person_profession(key_person_profession, address_person_profession, organization_person_profession, key_person, key_profession) VALUES (nextval('person_profession_gen_id'), 'Орг', 'Адрес', 1, 1);

INSERT INTO person_document(key_person_document, copy_person_document, ext_person_document, feature_person_document, name_person_document, need_recovery_person_document, number_person_document, serial_person_document, key_person) VALUES (nextval('person_document_gen_id'), null, 'exe', 'sdsdasdad', 'asdasdsd', true, '123123', '123123', 1);
