-- auto Generated on 2017-03-02 19:36:46 
-- DROP TABLE IF EXISTS `zn_lessons`; 
CREATE TABLE `zn_lessons`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `lesson_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonName',
    `lesson_type` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonType',
    `lesson_des` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lessonDes',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    `is_cycle` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'isCycle',
    `state` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'state',
    `notes` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'notes',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`zn_lessons`';
