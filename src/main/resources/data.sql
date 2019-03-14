INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD,DETAILS)
VALUES ('trainer@gmail.com', 'Trainer_First', 'Trainer_Last', '{noop}trainer','license: PRO'),
       ('admin@javaops.ru', 'Admin_First', 'Admin_Last', '{noop}admin','position: director'),
       ('pupil@mail.ru', 'Pupil_First', 'Pupil_Last', '{noop}pupil','нырок:70 ,скорость:82 ,рефлексы:73');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_TRAINER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_PUPIL', 3);
