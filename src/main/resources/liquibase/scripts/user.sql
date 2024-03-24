-- liquibase formatted sql

-- changeset roman:1
CREATE INDEX student_n_idx ON student(name);

CREATE INDEX faculty_nc_inx ON faculty(name, color);
