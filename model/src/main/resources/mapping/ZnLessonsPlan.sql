-- auto Generated on 2017-03-02 19:39:26 
-- DROP TABLE IF EXISTS `zn_lessons_plan`; 
CREATE TABLE `zn_lessons_plan`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `lesson_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonName',
    `lesson_title` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonTitle',
    `lesson_des` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonDes',
    `lesson_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'lessonTime',
    `lesson_teacher` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonTeacher',
    `lesson_grade` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonGrade',
    `lesson_score` DOUBLE (16,4) NOT NULL DEFAULT -1.0 COMMENT 'lessonScore',
    `lesson_place` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonPlace',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    `state` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'state',
    `notes` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'notes',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`zn_lessons_plan`';
