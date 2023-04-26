-- Info about all inserted data
-- Rooms 5
-- Timeslots 25
-- Professors 5
-- Subjects: 6
-- Subject_professor: 13
-- Groups: 5
-- Group_subject: 26

-- insert rooms
-- Amount of rooms: 5
insert into rooms (room_number, capacity)
VALUES ('A1', 15),
       ('B1', 30),
       ('D1', 20),
       ('F1', 25);


-- insert timeslots to Monday
-- Amount of timeslots for Monday: 5
insert into timeslots (weekday, duration)
VALUES ('monday', '9:00-10:30'),
       ('monday', '11:00-12:30'),
       ('monday', '13:30-15:00'),
       ('monday', '15:30-17:00'),
       ('monday', '17:30-19:00');

-- insert timeslots to Tuesday
-- Amount of timeslots for Tuesday: 5
insert into timeslots (weekday, duration)
VALUES ('tuesday', '9:00-10:30'),
       ('tuesday', '11:00-12:30'),
       ('tuesday', '13:30-15:00'),
       ('tuesday', '15:30-17:00'),
       ('tuesday', '17:30-19:00');

-- insert timeslots to Wednesday
-- Amount of timeslots for Wednesday: 5
insert into timeslots (weekday, duration)
VALUES ('wednesday', '9:00-10:30'),
       ('wednesday', '11:00-12:30'),
       ('wednesday', '13:30-15:00'),
       ('wednesday', '15:30-17:00'),
       ('wednesday', '17:30-19:00');

-- insert timeslots to Thursday
-- Amount of timeslots for Thursday: 5
insert into timeslots (weekday, duration)
VALUES ('thursday', '9:00-10:30'),
       ('thursday', '11:00-12:30'),
       ('thursday', '13:30-15:00'),
       ('thursday', '15:30-17:00'),
       ('thursday', '17:30-19:00');

-- insert timeslots to Friday
-- Amount of timeslots for Friday: 5
insert into timeslots (weekday, duration)
VALUES ('friday', '9:00-10:30'),
       ('friday', '11:00-12:30'),
       ('friday', '13:30-15:00'),
       ('friday', '15:30-17:00'),
       ('friday', '17:30-19:00');


-- insert professors
-- Amount of professors: 5
insert into professors (professor_name)
VALUES ('Dr. P.Smith'),
       ('Mrs E.Mitchell'),
       ('Dr. R.Williams'),
       ('Mr A.Thompson'),
       ('Mr. Carrick');

-- insert subjects
-- Amount of subjects: 6
insert into subjects (subject_code, subject_name)
VALUES ('cs1', 'Computer Science'),
       ('en1', 'English'),
       ('ma1', 'Maths'),
       ('ph1', 'Physics'),
       ('hi1', 'History'),
       ('dr1', 'Drama');

-- for 1s subject there are 1,2 and 5  professors
-- Amount of subject_professor: 3
insert into subject_professor (subject_id, professor_id)
VALUES (1, 1),
       (1, 2),
       (1, 5);

-- for 2s subject there are 1 and 3 professors
-- Amount of subject_professor: 2
insert into subject_professor (subject_id, professor_id)
VALUES (2, 1),
       (2, 3);

-- for 3s subject there are 1,2 and 5 professors
-- Amount of subject_professor: 3
insert into subject_professor (subject_id, professor_id)
VALUES (3, 1),
       (3, 2),
       (3, 5);

-- for 4s subject there are 3 and 4 professors
-- Amount of subject_professor: 2
insert into subject_professor (subject_id, professor_id)
VALUES (4, 3),
       (4, 4);

-- for 5s subject there are only 4 professors
-- Amount of subject_professor: 1
insert into subject_professor (subject_id, professor_id)
VALUES (5, 4);

-- for 6s subject there are 1 and 4 professors
-- Amount of subject_professor: 2
insert into subject_professor (subject_id, professor_id)
VALUES (6, 1),
       (6, 4);

-- insert groups
-- Amount of groups: 5
insert into groups (group_name, grade)
VALUES ('ce-1', 1),
       ('ce-2', 1),
       ('ce-3', 1),
       ('ce-4', 1),
       ('ce-5', 1);

-- 1s group takes 1,2,3,4 and 5 subjects
-- Amount of group_subject: 5
insert into group_subject (group_id, subject_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5);

-- 2s group takes 1,2,3,4 and 5 subjects
-- Amount of group_subject: 5
insert into group_subject (group_id, subject_id)
VALUES (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5);

-- 3s group takes 2,3,4,5 and 6 subjects
-- Amount of group_subject: 5
insert into group_subject (group_id, subject_id)
VALUES (3, 2),
       (3, 3),
       (3, 4),
       (3, 5),
       (3, 6);

-- 4s group takes 2,3,4,5 and 6 subjects
-- Amount of group_subject: 5
insert into group_subject (group_id, subject_id)
VALUES (4, 2),
       (4, 3),
       (4, 4),
       (4, 5),
       (4, 6);

-- 5s group takes 1,2,3,4,5 and 6 subjects
-- Amount of group_subject: 6
insert into group_subject (group_id, subject_id)
VALUES (5, 1),
       (5, 2),
       (5, 3),
       (5, 4),
       (5, 5),
       (5, 6);

insert into students (student_name, last_name, age, group_id)
VALUES ('student_1', 'last_1', 20, 1),
       ('student_2', 'last_2', 20, 1),
       ('student_3', 'last_3', 20, 1),
       ('student_4', 'last_4', 20, 1),
       ('student_5', 'last_5', 20, 1);

insert into students (student_name, last_name, age, group_id)
VALUES ('student_6', 'last_6', 20, 2),
       ('student_7', 'last_7', 20, 2),
       ('student_8', 'last_8', 20, 2),
       ('student_9', 'last_9', 20, 2),
       ('student_10', 'last_10', 20, 2);

insert into students (student_name, last_name, age, group_id)
VALUES ('student_11', 'last_11', 20, 3),
       ('student_12', 'last_12', 20, 3),
       ('student_13', 'last_13', 20, 3),
       ('student_14', 'last_14', 20, 3),
       ('student_15', 'last_15', 20, 3);

insert into students (student_name, last_name, age, group_id)
VALUES ('student_16', 'last_16', 20, 4),
       ('student_17', 'last_17', 20, 4),
       ('student_18', 'last_18', 20, 4),
       ('student_19', 'last_19', 20, 4),
       ('student_20', 'last_20', 20, 4);

insert into students (student_name, last_name, age, group_id)
VALUES ('student_21', 'last_21', 20, 5),
       ('student_22', 'last_22', 20, 5),
       ('student_23', 'last_23', 20, 5),
       ('student_24', 'last_24', 20, 5),
       ('student_25', 'last_25', 20, 5);
