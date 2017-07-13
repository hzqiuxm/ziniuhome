-- auto Generated on 2017-05-07 15:32:06 
-- DROP TABLE IF EXISTS `um_sec_role`; 
CREATE TABLE `um_sec_role`(
    `id` INT (11) UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
    `role_name` VARCHAR (20) NOT NULL DEFAULT '' COMMENT '角色名称必须大写以ROLE打头：ROLE_ADMIN ROLE_USER ',
    `describer` VARCHAR (200) NOT NULL DEFAULT '' COMMENT '表述RoleName具体含义',
    `status` TINYINT NOT NULL DEFAULT 0 COMMENT '0 生效 1 失效 ',
    `gmt_create` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtCreate',
    `gmt_modify` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtModify',
    `i_ext` INT (11) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'iExt',
    `str_ext` VARCHAR (200) NOT NULL DEFAULT '' COMMENT 'strExt',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`um_sec_role`';
