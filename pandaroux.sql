INSERT INTO pandaRoux.role(id, name) VALUES 
	(1, 'eleve'), (2, 'prof'), (3, 'administration');

INSERT INTO pandaRoux.user (id, first_name, id_isep, name, id_role) VALUES 
	(1, 'Teacher', 1, 'Teacher', 2), (2, 'Vincent', 9604, 'HAYS', 1), (3, 'Alexandre', 9607, 'GAY', 1);


INSERT INTO pandaRoux.question_type (id, name) VALUES 
	(1, 'Short Answer'), (2, 'Paragraph'), (3, 'Radio Boxes'), (4, 'Check Boxes'), (5, 'Dropdown List');


