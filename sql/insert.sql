
INSERT INTO course_info (course_code, name, create_time) VALUES (101, '语文', '2019/01/17 15:04:11');
INSERT INTO course_info (course_code, name, create_time) VALUES (102, '数学', '2019/01/17 15:04:12');
INSERT INTO course_info (course_code, name, create_time) VALUES (103, '英语', '2019/01/17 15:04:13');


INSERT INTO student_info(school_code, name, create_time) VALUES (1001, '李雷', '2019-01-16 15:23:17');
INSERT INTO student_info(school_code, name, create_time) VALUES (1002, '韩梅梅', '2019-01-16 15:23:17');


INSERT INTO teacher_info(job_code, name, create_time) VALUES (201, '张三', '2019-01-16 15:23:17');
INSERT INTO teacher_info(job_code, name, create_time) VALUES (202, '李四', '2019-01-17 15:23:17');
INSERT INTO teacher_info(job_code, name, create_time) VALUES (203, '王五', '2019-01-18 15:23:17');


INSERT INTO score_info(student_info_id, course_info_id, score, create_time) VALUES (1, 1, 80, '2019-01-18 15:23:17');
INSERT INTO score_info(student_info_id, course_info_id, score, create_time) VALUES (1, 2, 81, '2019-01-18 15:23:17');
INSERT INTO score_info(student_info_id, course_info_id, score, create_time) VALUES (1, 3, 82, '2019-01-18 15:23:17');
INSERT INTO score_info(student_info_id, course_info_id, score, create_time) VALUES (2, 1, 73, '2019-01-18 15:23:17');
INSERT INTO score_info(student_info_id, course_info_id, score, create_time) VALUES (2, 2, 88, '2019-01-18 15:23:17');
INSERT INTO score_info(student_info_id, course_info_id, score, create_time) VALUES (2, 3, 87, '2019-01-18 15:23:17');