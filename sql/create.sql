
-- ----------------------------
-- Table structure for `student_info`
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`(
    id INT (11) AUTO_INCREMENT NOT NULL,
    school_code INT(10) NOT NULL,
    name VARCHAR (20),
    create_time DATETIME NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `teacher_info`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`(
    id INT (11) AUTO_INCREMENT NOT NULL,
    job_code INT(10) NOT NULL,
    name VARCHAR (20),
    create_time DATETIME NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `course_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info`(
    id INT (11) AUTO_INCREMENT NOT NULL,
    course_code INT(10) NOT NULL,
    name VARCHAR (20),
    create_time DATETIME NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `score_info`
-- ----------------------------
DROP TABLE IF EXISTS `score_info`;
CREATE TABLE `score_info`(
    id INT (11) AUTO_INCREMENT NOT NULL,
    student_info_id INT(11) NOT NULL,
    course_info_id INT(11) NOT NULL,
    score DOUBLE(3, 1) NOT NULL,
    create_time DATETIME NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;