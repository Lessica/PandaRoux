INSERT INTO pandaroux.role (id, name) VALUES
  (1, 'eleve'),
  (2, 'prof'),
  (3, 'administration');

INSERT INTO pandaroux.user (id, first_name, id_isep, name, id_role) VALUES
  (1, 'Teacher', 1, 'TEACHER', 2),
  (2, 'Vincent', 2, 'HAYS', 1),
  (3, 'Alexandre', 3, 'GAY', 1),
  (4, 'Vincent', 4, 'CARPE', 1),
  (5, 'Benjamin', 5, 'FOSSE', 1);

INSERT INTO pandaroux.groupe (id, name, id_teacher) VALUES
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

INSERT INTO pandaroux.student_groupe (id_student, id_groupe) VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 1);

INSERT INTO pandaroux.question_type (id, name, json_parameters, json_answer) VALUES
  (1, 'Short Answer', NULL, 'I love this course ...'),
  (2, 'Paragraph', NULL, 'I love this course ...'),
  (3, 'Radio Boxes', '{"options": ["option 1", "option 2", "option 3"], "default": 1}', '2'),
  (4, 'Check Boxes', '{"options": ["option 1", "option 2", "option 3"]}', '[0, 2]'),
  (5, 'Dropdown List', '{"options": ["option 1", "option 2", "option 3"], "default": 1}', '1');

INSERT INTO pandaroux.question (has_commentary, json_parameters, mandatory, name, id_question_type, id_teacher)
VALUES (TRUE, NULL, TRUE, 'Question 1', 1, 1);
INSERT INTO pandaroux.question (has_commentary, json_parameters, mandatory, name, id_question_type, id_teacher)
VALUES (TRUE, NULL, TRUE, 'Question 2', 2, 1);
INSERT INTO pandaroux.question (has_commentary, json_parameters, mandatory, name, id_question_type, id_teacher) VALUES
  (TRUE,
   '{"user-options":[{"name":"user-radio-1","value":"Option 1"},{"name":"user-radio-2","value":"Option 2"}],"user-default":[1]}',
   TRUE, 'Question 3', 3, 1);
INSERT INTO pandaroux.question (has_commentary, json_parameters, mandatory, name, id_question_type, id_teacher) VALUES
  (TRUE,
   '{"user-options":[{"name":"user-checkbox-1","value":"Option 1"},{"name":"user-checkbox-2","value":"Option 2"},{"name":"user-checkbox-3","value":"Option 3"},{"name":"user-checkbox-4","value":"Option 4"}],"user-default":[1,3]}',
   TRUE, 'Question 4', 4, 1);
INSERT INTO pandaroux.question (has_commentary, json_parameters, mandatory, name, id_question_type, id_teacher) VALUES
  (TRUE,
   '{"user-property-dropdown-multiple":"checked","user-options":[{"name":"user-dropdown-1","value":"Option 1"},{"name":"user-dropdown-2","value":"Option 2"},{"name":"user-dropdown-3","value":"Option 3"}],"user-default":[]}',
   TRUE, 'Question 5', 5, 1);

INSERT INTO pandaroux.quiz (id, name, active, date_start, date_end, id_groupe, id_teacher) VALUES
  (1, 'Quiz 1', TRUE, '2017-03-03', '2017-03-05', 1, 1),
  (2, 'Quiz 2', FALSE, '2017-06-13', '2017-06-20', 1, 1),
  (3, 'Quiz 3', TRUE, '2017-06-13', '2017-06-20', 1, 1),
  (4, 'Quiz 4', TRUE, '2017-07-06', '2017-07-07', 1, 1),
  (5, 'Quiz 5', TRUE, '2017-03-06', '2017-03-07', 1, 1),
  (6, 'Quiz 6', TRUE, '2017-08-06', '2017-08-20', 1, 1);

INSERT INTO pandaroux.quiz_question (id, id_question, id_quiz) VALUES
  (1, 1, 1),
  (2, 2, 1),
  (3, 3, 1),
  (4, 4, 1),
  (5, 5, 1);

INSERT INTO pandaroux.answer (id, id_quiz_question, date, json_parameters, text, id_student) VALUES
  (1, 1, '2017-03-03', NULL, 'I love this course ...', 2),
  (2, 2, '2017-03-03', NULL, 'I love this course ...', 2),
  (3, 3, '2017-03-03', '2', NULL, 2),
  (4, 4, '2017-03-03', '[0, 2]', NULL, 2),
  (5, 5, '2017-03-03', '1', NULL, 2);
