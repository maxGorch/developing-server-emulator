CREATE TABLE IF NOT EXISTS student_group(
    group_id BIGSERIAL PRIMARY KEY,
    group_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS student(
    student_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100) NOT NULL,

    group_id BIGINT NOT NULL REFERENCES student_group(group_id),
    
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS teacher(
    teacher_id BIGSERIAL PRIMARY KEY,

    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS subject(
    subject_id BIGSERIAL PRIMARY KEY,
    name_subject VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS lesson(
    lesson_Id BIGSERIAL PRIMARY KEY,
    lesson_date DATE NOT NULL,
    pair_number INT NOT NULL,

    teacher_id BIGINT NOT NULL REFERENCES teacher(teacher_id),
    group_id BIGINT NOT NULL REFERENCES student_group(group_id),
    subject_id BIGINT NOT NULL REFERENCES subject(subject_id),

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS lesson_attendance(
    lesson_attendance_id BIGSERIAL PRIMARY KEY, 
   
    lesson_id BIGINT NOT NULL REFERENCES lesson(lesson_id) ON DELETE CASCADE,
    student_id BIGINT NOT NULL REFERENCES student(student_id),

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_student_group_id ON student(group_id);

CREATE INDEX IF NOT EXISTS idx_lesson_teacher_id ON lesson(teacher_id);
CREATE INDEX IF NOT EXISTS idx_lesson_group_id ON lesson(group_id);
CREATE INDEX IF NOT EXISTS idx_lesson_subject_id ON lesson(subject_id);

CREATE INDEX IF NOT EXISTS idx_attendance_lesson_id ON lesson_attendance(lesson_id);
CREATE INDEX IF NOT EXISTS idx_attendance_student_id ON lesson_attendance(student_id);