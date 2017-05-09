-- auto Generated on 2017-05-07 17:16:09 
-- DROP TABLE IF EXISTS `um_sec_user_role`; 
CREATE TABLE `um_sec_user_role`(
    `id` INT (11) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` INT (11) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'userId',
    `role_id` INT (11) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'roleId',
    `gmt_create` DATETIME NOT NULL DEFAULT current_timestamp COMMENT 'gmtCreate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`um_sec_user_role`';
