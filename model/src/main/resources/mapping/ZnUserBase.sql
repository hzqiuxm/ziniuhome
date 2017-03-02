-- auto Generated on 2017-03-02 10:10:28 
-- DROP TABLE IF EXISTS `zn_user_base`; 
CREATE TABLE `zn_user_base`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userName',
    `password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
    `nick_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'nickName',
    `sex` BLOB NOT NULL DEFAULT '' COMMENT 'sex',
    `phone` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'phone',
    `qq` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'qq',
    `email` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'email',
    `img_url` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'imgUrl',
    `permission` INT (11) NOT NULL DEFAULT -1 COMMENT 'permission',
    `login_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'loginTime',
    `login_ip` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'loginIp',
    `last_login_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'lastLoginTime',
    `last_login_ip` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lastLoginIp',
    `gmt_creat` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtCreat',
    `gmt_expire` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtExpire',
    `notes` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'notes',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`zn_user_base`';
