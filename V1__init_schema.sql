CREATE TABLE school(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title VARCHAR(100),
    address VARCHAR(100)
   );

CREATE TABLE student(
   id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name VARCHAR(100),
    age SMALLINT,
    gender CHAR(1),
    CONSTRAINT check_gender CHECK
        (gender IN ('М', 'Ж')),
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES school(id)
   );

CREATE TABLE teacher(
   id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name VARCHAR(100),
    age SMALLINT,
    gender CHAR(1),
    CONSTRAINT check_gender CHECK
        (gender IN ('М', 'Ж')),
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES school(id)
   );

CREATE TABLE subject(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    fullName VARCHAR(70)
);

CREATE TABLE student_subject(
    student_id INT,
    subject_id INT,
    UNIQUE(student_id, subject_id),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE TABLE teacher_subject(
    teacher_id INT,
    subject_id INT,
    UNIQUE(teacher_id, subject_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
   );

