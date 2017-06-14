  INSERT INTO pandaRoux.role(id, name) VALUES
    (1, 'eleve'),
    (2, 'prof'),
    (3, 'administration');

  INSERT INTO pandaRoux.user (id, first_name, id_isep, name, id_role) VALUES
    (1, 'Teacher', 1, 'TEACHER', 2),
    (2, 'Vincent', 2, 'HAYS', 1),
    (3, 'Alexandre', 3, 'GAY', 1),
    (4, 'Vincent', 4, 'CARPE', 1),
    (5, 'Benjamin', 5, 'FOSSE', 1);

  INSERT INTO pandaRoux.groupe (id, name, id_teacher) VALUES
    (1, 'Group 1', 1),
    (2, 'Group 2', 1),
    (3, 'Group 3', 1),
    (4, 'Group 4', 1),
    (5, 'Group 5', 1);

  INSERT INTO pandaroux.lecture (id, name, commentary, date, rate, id_groupe) VALUES
    (1, 'lecture 1', 'Great lecture', '2017-03-05', 5, 1),
    (2, 'lecture 2', 'Great lecture', '2017-03-05', 2, 1),
    (3, 'lecture 3', 'Great lecture', '2017-03-05', 3, 1),
    (4, 'lecture 4', 'Great lecture', '2017-03-05', 2, 1);

  INSERT INTO pandaRoux.student_groupe(id_student, id_groupe) VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1);

  INSERT INTO pandaRoux.question_type (id, name, json_parameters, json_answer) VALUES
    (1, 'Short Answer', null, 'I love this course ...'),
    (2, 'Paragraph', null, 'I love this course ...'),
    (3, 'Radio Boxes', '{"options": ["option 1", "option 2", "option 3"], "default": 1}', '2'),
    (4, 'Check Boxes', '{"options": ["option 1", "option 2", "option 3"]}', '[0, 2]'),
    (5, 'Dropdown List', '{"options": ["option 1", "option 2", "option 3"], "default": 1}', '1');

  INSERT INTO pandaRoux.question (id, name, has_commentary, mandatory, id_question_type, json_parameters, id_teacher) VALUES
    (1, 'Question 1', true, true, 1, null, 1),
    (2, 'Question 2', true, true, 2, null, 1),
    (3, 'Question 3', true, true, 3, '{"options": ["option 1", "option 2", "option 3"], "default": 1}', 1),
    (4, 'Question 4', true, true, 4, '{"options": ["option 1", "option 2", "option 3"]}', 1),
    (5, 'Question 5', true, true, 5, '{"options": ["option 1", "option 2", "option 3"], "default": 1}', 1);

  INSERT INTO pandaRoux.quiz (id, name, active, date_start, date_end, id_groupe, id_teacher) VALUES
    (1, 'Quiz 1', true, '2017-03-03', '2017-03-05', 1, 1),
    (2, 'Quiz 2', true, '2017-03-06', '2017-03-07', 1, 1);

  INSERT INTO pandaRoux.quiz_question (id, id_question, id_quiz) VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 1),
    (4, 4, 1),
    (5, 5, 1);

  INSERT INTO pandaroux.answer (id, id_quiz_question, date, json_parameters, text, id_student) VALUES
    (1, 1, '2017-03-03', null, 'I love this course ...', 2),
    (2, 2, '2017-03-03', null, 'I love this course ...', 2),
    (3, 3, '2017-03-03', '2', null, 2),
    (4, 4, '2017-03-03', '[0, 2]', null, 2),
    (5, 5, '2017-03-03', '1', null, 2);
