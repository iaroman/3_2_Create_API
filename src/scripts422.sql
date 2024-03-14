CREATE TABLE brand_cars (
    id SERIAL PRIMARY KEY,
    name_brands_cars VARCHAR(100) NOT NULL
);

INSERT INTO brand_cars(name_brands_cars) VALUES
                                                    ('Honda'),
                                                    ('Kia'),
                                                    ('Audi'),
                                                    ('BMW');

SELECT * FROM brand_cars;

CREATE TABLE model_brands (
    id SERIAL PRIMARY KEY,
    name_model_brands VARCHAR(100) NOT NULL,
    brand_cars_id INT NOT NULL,
    CONSTRAINT fk_model_brands FOREIGN KEY(brand_cars_id) REFERENCES brand_cars(id));

SELECT * FROM model_brands;

INSERT INTO model_brands(name_model_brands, brand_cars_id) VALUES
                                             ('Civic', 1),
                                             ('Sportage', 2),
                                             ('A1', 3),
                                             ('A2', 3),
                                             ('A2', 3),
                                             ('2 серия', 4);

CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    model_cars_id INT NOT NULL,
    prise INT NOT NULL,
    CONSTRAINT fk_cars FOREIGN KEY(model_cars_id) REFERENCES model_brands(id));

SELECT * FROM cars;

INSERT INTO cars(model_cars_id, prise) VALUES
                                           (1, 1000000),
                                           (2, 2000000),
                                           (3, 10000000),
                                           (4, 20000000),
                                           (4, 210000000);

CREATE TABLE drivers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    soname VARCHAR(100) NOT NULL,
    license BOOLEAN NOT NULL,
    cars_id INT NOT NULL,
    CONSTRAINT fk_drivers FOREIGN KEY(cars_id) REFERENCES cars(id));

SELECT * FROM drivers;

INSERT INTO drivers(name, soname, license, cars_id) VALUES
                                                        ('Bob', 'Dilan', 'true', 1),
                                                        ('Jon', 'Born', 'true', 2),
                                                        ('Alisa', 'Potter', 'true', 2),
                                                        ('Viki', 'Bush', 'true', 2),
                                                        ('Ron', 'Man', 'true', 3),
                                                        ('Will', 'Smith', 'true', 3);

select drivers.name, drivers.soname, drivers.license, bc.name_brands_cars, mb.name_model_brands, c.prise
from drivers
    left join cars c on drivers.cars_id = c.id
    left join model_brands mb on c.model_cars_id = mb.id
    left join brand_cars bc on mb.brand_cars_id = bc.id
;

DROP TABLE cars;