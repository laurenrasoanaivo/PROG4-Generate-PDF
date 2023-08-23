INSERT INTO employee (id, serial_number, first_name, last_name, birthdate, gender, address, cin_number, cin_issuance_date, cin_issuance_place, position, dependent_children, hire_date, departure_date, salary, benefits, allowances, social_security_contributions, taxable_income, tax_rate, net_income, photo)
VALUES
(1, 'EMP-2021-01-10-00001', 'John', 'Doe', '1990-05-15', 'H', '123 Main Street', '123456789012', '2005-08-23', 'City A', 'Manager', 2, '2021-01-10', NULL, 50000.0, 5000.0, 2000.0, 1000.0, 47000.0, 0.1, 42300.0, NULL);

INSERT INTO all_phone_numbers (employee_id, phone_numbers)
VALUES
(1, '+261 033 12 345 67'),
(1, '+33 33 12 33 45 62');

INSERT INTO all_emails (employee_id, emails)
VALUES
(1, 'john@gmail.com'),
(1, 'john@techsolutions.com');

INSERT INTO all_phone_numbers (company_id, phone_numbers)
VALUES
(1, '+261 034 11 222 33');

/*INSERT INTO employee (id, serial_number, first_name, last_name, birthdate, gender, address, cin_number, cin_issuance_date, cin_issuance_place, position, dependent_children, hire_date, departure_date, salary, benefits, allowances, social_security_contributions, taxable_income, tax_rate, net_income, photo, cnaps, end_to_end_id)
VALUES
(1, 'EMP-2021-01-10-00001', 'John', 'Doe', '1990-05-15', 'H', '123 Main Street', '123456789012', '2005-08-23', 'City A', 'Manager', 2, '2021-01-10', NULL, 50000.0, 5000.0, 2000.0, 1000.0, 47000.0, 0.1, 42300.0, NULL, 'CNAPS-001-23451', 1);*/

--update cnaps in db cnaps
--update employee set cnaps='CNAPS-001-23452' where end_to_end_id=1;