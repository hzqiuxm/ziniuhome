-- auto Generated on 2017-05-06 22:06:25 
-- DROP TABLE IF EXISTS `um_user_base`; 
CREATE TABLE `um_user_base`(
    `user_id` INT (11)  UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `user_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户姓名',
    `cell_num` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '手机号码',
    `password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '登录密码',
    `status` TINYINT NOT NULL  COMMENT '记录状态 0 审核中 1 审核通过正常使用 2 冻结使用',
    `gmt_create` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtCreate',
    `gmt_modfiy` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtModfiy',
    `reserve` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '备注字段',
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`um_user_base`';
