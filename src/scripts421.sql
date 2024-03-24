ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK (age > 16),
    ADD CONSTRAINT name_unique UNIQUE (name),
    ALTER COLUMN name SET NOT NULL;

ALTER TABLE faculty
    ADD CONSTRAINT color_constraint UNIQUE (color),
    ADD CONSTRAINT name_constraint UNIQUE (name);

ALTER TABLE student
    ALTER COLUMN age SET DEFAULT 20;