USE pandaroux;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Records of `answer`
-- ----------------------------
BEGIN;
INSERT INTO `answer` VALUES ('1', '2017-03-03', null, 'I love this course ...', '1', '2'), ('2', '2017-03-03', null, 'I love this course ...', '2', '2'), ('3', '2017-03-03', '2', null, '3', '2'), ('4', '2017-03-03', '[0, 2]', null, '4', '2'), ('5', '2017-03-03', '1', null, '5', '2');
COMMIT;

-- ----------------------------
--  Records of `groupe`
-- ----------------------------
BEGIN;
INSERT INTO `groupe` VALUES ('1', 'WEB Technologies', '1'), ('2', 'Microsystem', '1'), ('3', 'Network Security', '1'), ('4', 'Database & Bigdata', '1'), ('5', 'Advanced Algorithm', '1');
COMMIT;

-- ----------------------------
--  Records of `lecture`
-- ----------------------------
BEGIN;
INSERT INTO `lecture` VALUES ('1', 'Great lecture', '2017-03-05', 'lecture 1', '5', '1'), ('2', 'Great lecture', '2017-03-05', 'lecture 2', '2', '1'), ('3', 'Great lecture', '2017-03-05', 'lecture 3', '3', '1'), ('4', 'Great lecture', '2017-03-05', 'lecture 4', '2', '1'), ('5', null, '2017-06-01', 'Session 1', '0', '3'), ('6', null, '2017-06-08', 'Session 2', '0', '3'), ('7', null, '2017-06-15', 'Session 3', '0', '3'), ('8', null, '2017-06-22', 'Session 4', '0', '3'), ('9', null, '2017-06-29', 'Session 5', '0', '3'), ('10', null, '2017-06-02', 'Session 1', '0', '4'), ('12', null, '2017-06-09', 'Session 2', '0', '4'), ('13', null, '2017-06-16', 'Session 3', '0', '4'), ('14', null, '2017-06-23', 'Session 4', '0', '4'), ('15', null, '2017-06-30', 'Session 5', '0', '4'), ('16', null, '2017-06-04', 'Special Session 1', '0', '5'), ('17', 'Hello, this  is a special session provided by 82Flex.com', '2017-06-18', 'Special Session 2', '5', '5');
COMMIT;

-- ----------------------------
--  Records of `question`
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES ('1', b'1', '{\"user-property-short-placeholder\":\"It is the placeholder of the short answer...\",\"user-options\":[],\"user-default\":[]}', b'1', 'Question 1', '1', '1'), ('2', b'1', '{\"user-property-short-placeholder\":\"It is the placeholder of the paragraph...\",\"user-options\":[],\"user-default\":[]}', b'1', 'Question 2', '2', '1'), ('3', b'1', '{\"user-options\":[{\"name\":\"user-radio-1\",\"value\":\"Option 1\"},{\"name\":\"user-radio-2\",\"value\":\"Option 2\"}],\"user-default\":[1]}', b'1', 'Question 3', '3', '1'), ('4', b'1', '{\"user-options\":[{\"name\":\"user-checkbox-1\",\"value\":\"Option 1\"},{\"name\":\"user-checkbox-2\",\"value\":\"Option 2\"},{\"name\":\"user-checkbox-3\",\"value\":\"Option 3\"},{\"name\":\"user-checkbox-4\",\"value\":\"Option 4\"}],\"user-default\":[1,3]}', b'1', 'Question 4', '4', '1'), ('5', b'1', '{\"user-property-dropdown-multiple\":\"checked\",\"user-options\":[{\"name\":\"user-dropdown-1\",\"value\":\"Option 1\"},{\"name\":\"user-dropdown-2\",\"value\":\"Option 2\"},{\"name\":\"user-dropdown-3\",\"value\":\"Option 3\"}],\"user-default\":[]}', b'1', 'Question 5', '5', '1'), ('6', b'0', '{\"user-property-short-placeholder\":\"Red, Green, Blue, Yellow, etc...\",\"user-options\":[],\"user-default\":[]}', b'1', 'What is your favourite color?', '1', '1'), ('7', b'0', '{\"user-property-short-placeholder\":\"It is the placeholder for the paragraph...\",\"user-options\":[],\"user-default\":[]}', b'1', 'Do you have some better ideas or advices?', '2', '1'), ('8', b'0', '{\"user-property-checkbox-min\":\"1\",\"user-property-checkbox-max\":\"3\",\"user-options\":[{\"name\":\"user-checkbox-1\",\"value\":\"C\"},{\"name\":\"user-checkbox-2\",\"value\":\"C++\"},{\"name\":\"user-checkbox-3\",\"value\":\"Java\"},{\"name\":\"user-checkbox-4\",\"value\":\"Objective-C\"},{\"name\":\"user-checkbox-5\",\"value\":\"PHP\"},{\"name\":\"user-checkbox-6\",\"value\":\"Javascript\"},{\"name\":\"user-checkbox-7\",\"value\":\"Swift\"},{\"name\":\"user-checkbox-8\",\"value\":\"C#\"},{\"name\":\"user-checkbox-9\",\"value\":\"Python\"}],\"user-default\":[2,3,4]}', b'1', 'Select your favourite programming languages.', '4', '1'), ('9', b'0', '{\"user-options\":[{\"name\":\"user-radio-1\",\"value\":\"Male\"},{\"name\":\"user-radio-2\",\"value\":\"Female\"},{\"name\":\"user-radio-3\",\"value\":\"Asexual\"}],\"user-default\":[1]}', b'1', 'Your gender?', '3', '1'), ('10', b'0', '{\"user-options\":[{\"name\":\"user-dropdown-1\",\"value\":\"France\"},{\"name\":\"user-dropdown-2\",\"value\":\"Korean\"},{\"name\":\"user-dropdown-3\",\"value\":\"China\"}],\"user-default\":[]}', b'1', 'Where do you come from?', '5', '1');
COMMIT;

-- ----------------------------
--  Records of `question_type`
-- ----------------------------
BEGIN;
INSERT INTO `question_type` VALUES ('1', 'I love this course ...', null, 'Short Answer'), ('2', 'I love this course ...', null, 'Paragraph'), ('3', '2', '{\"options\": [\"option 1\", \"option 2\", \"option 3\"], \"default\": 1}', 'Radio Boxes'), ('4', '[0, 2]', '{\"options\": [\"option 1\", \"option 2\", \"option 3\"]}', 'Check Boxes'), ('5', '1', '{\"options\": [\"option 1\", \"option 2\", \"option 3\"], \"default\": 1}', 'Dropdown List');
COMMIT;

-- ----------------------------
--  Records of `quiz`
-- ----------------------------
BEGIN;
INSERT INTO `quiz` VALUES ('1', b'1', '2017-03-05', '2017-03-03', 'Quiz 1', '1', '1'), ('2', b'0', '2017-06-20', '2017-06-13', 'Quiz 2', '1', '1'), ('3', b'1', '2017-06-20', '2017-06-13', 'Quiz 3', '1', '1'), ('4', b'1', '2017-07-07', '2017-07-06', 'Quiz 4', '1', '1'), ('5', b'1', '2017-03-07', '2017-03-06', 'Quiz 5', '1', '1'), ('6', b'1', '2017-08-20', '2017-08-06', 'Quiz 6', '1', '1'), ('7', b'1', '2017-06-21', '2017-06-14', 'My First Quiz', '5', '1'), ('8', b'1', '2017-06-21', '2017-06-14', 'My Second Quiz', '3', '1'), ('9', b'1', '2017-06-21', '2017-06-14', 'My First Questionnaire', null, '6'), ('10', b'1', '2017-06-22', '2017-06-15', 'My Third Quiz', '5', '1'), ('11', b'1', '2017-06-07', '2017-06-01', 'My Outdated Quiz', '5', '1'), ('12', b'1', '2017-06-22', '2017-06-15', 'Demo Questionnaire', '5', '1');
COMMIT;

-- ----------------------------
--  Records of `quiz_question`
-- ----------------------------
BEGIN;
INSERT INTO `quiz_question` VALUES ('1', '1', '1'), ('2', '2', '1'), ('3', '3', '1'), ('4', '4', '1'), ('5', '5', '1'), ('6', '1', '7'), ('7', '2', '7'), ('8', '3', '7'), ('9', '4', '7'), ('10', '5', '7'), ('11', '1', '8'), ('12', '5', '8'), ('13', '1', '10'), ('14', '2', '10'), ('15', '3', '10'), ('16', '4', '10'), ('17', '4', '11'), ('18', '5', '11'), ('19', '6', '12'), ('20', '8', '12'), ('21', '7', '12'), ('22', '9', '12'), ('23', '10', '12');
COMMIT;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'eleve'), ('2', 'prof'), ('3', 'administration');
COMMIT;

-- ----------------------------
--  Records of `student_groupe`
-- ----------------------------
BEGIN;
INSERT INTO `student_groupe` VALUES ('1', '1'), ('2', '1'), ('3', '1'), ('4', '1'), ('5', '1'), ('6', '3'), ('6', '4'), ('6', '5'), ('6', '1');
COMMIT;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'Teacher', '1', 'TEACHER', '2'), ('2', 'Vincent', '2', 'HAYS', '1'), ('3', 'Alexandre', '3', 'GAY', '1'), ('4', 'Vincent', '4', 'CARPE', '1'), ('5', 'Benjamin', '5', 'FOSSE', '1'), ('6', 'Zheng', '6', 'WU', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
