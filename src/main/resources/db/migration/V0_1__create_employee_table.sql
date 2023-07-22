CREATE TABLE employee (
    id serial PRIMARY KEY,
    serial_number VARCHAR(255) UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birthdate DATE,
    gender VARCHAR(255),
    address VARCHAR(1000),
    cin_number VARCHAR(255) UNIQUE,
    cin_issuance_date DATE,
    cin_issuance_place VARCHAR(1000),
    position VARCHAR(255),
    dependent_children INT,
    hire_date DATE,
    departure_date DATE,
    salary DOUBLE PRECISION,
    benefits DOUBLE PRECISION,
    allowances DOUBLE PRECISION,
    social_security_contributions DOUBLE PRECISION,
    taxable_income DOUBLE PRECISION,
    tax_rate DOUBLE PRECISION,
    net_income DOUBLE PRECISION,
    cnaps VARCHAR(255) UNIQUE,
    photo TEXT
);

CREATE TABLE employee_phone_numbers (
    employee_id INT,
    phone_numbers VARCHAR(255),
    UNIQUE (phone_numbers),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE employee_emails (
    employee_id INT,
    emails VARCHAR(255),
    UNIQUE (emails),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);

ALTER sequence employee_id_seq restart WITH 21;
