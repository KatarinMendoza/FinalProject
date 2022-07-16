INSERT INTO affiliation_type (id, name) values (1,'PRIMA');
INSERT INTO affiliation_type (id, name) VALUES (2,'INTEGRA');
INSERT INTO affiliation_type (id, name) VALUES (3, 'PROFUTURO');
INSERT INTO affiliation_type (id, name) VALUES (4, 'HABITAT');
INSERT INTO customer(id,dni,mail,name,surnames,telephone,affiliation_type_id) VALUES (1,'72321158','','KATARIN','MENDOZA',997574594,1);
INSERT INTO associationafp (id, date_withdrawal, amount_available,dni,customer_id) VALUES (1,'2022-06-06',800,'72321158',1);

