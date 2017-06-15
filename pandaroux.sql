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

  INSERT INTO pandaRoux.question_type (id, name) VALUES
    (1, 'Short Answer'),
    (2, 'Paragraph'),
    (3, 'Radio Boxes'),
    (4, 'Check Boxes'),
    (5, 'Dropdown List');

  INSERT INTO pandaRoux.question (id, id_teacher, name, has_commentary, mandatory, id_question_type, json_parameters) VALUES
    (1, 1, 'Question 1', true, true, 1, null),
    (2, 1, 'Question 2', true, true, 2, null),
    (3, 1, 'Question 3', true, true, 3, '{"user-options":[{"name":"user-radio-1","value":"Option 1"},{"name":"user-radio-2","value":"Option 2"}],"user-default":[1]}'),
    (4, 1, 'Question 4', true, true, 4, '{"user-options":[{"name":"user-checkbox-1","value":"Option 1"},{"name":"user-checkbox-2","value":"Option 2"},{"name":"user-checkbox-3","value":"Option 3"},{"name":"user-checkbox-4","value":"Option 4"}],"user-default":[1,3]}'),
    (5, 1, 'Question 5', true, true, 5, '{"user-property-dropdown-multiple":"checked","user-options":[{"name":"user-dropdown-1","value":"Option 1"},{"name":"user-dropdown-2","value":"Option 2"},{"name":"user-dropdown-3","value":"Option 3"}],"user-default":[]}');

  INSERT INTO pandaRoux.quiz (id, name, active, date_start, date_end, id_groupe, id_teacher) VALUES
    (1, 'Quiz 1', true, '2017-06-13', '2017-06-20', 1, 1),
    (2, 'Quiz 2', false, '2017-06-13', '2017-06-20', 1, 1),
    (3, 'Quiz 3', true, '2017-06-13', '2017-06-20', 1, 1),
    (4, 'Quiz 4', true, '2017-07-06', '2017-07-07', 1, 1),
    (5, 'Quiz 5', true, '2017-03-06', '2017-03-07', 1, 1),
    (6, 'Quiz 6', true, '2017-08-06', '2017-08-20', 1, 1);

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