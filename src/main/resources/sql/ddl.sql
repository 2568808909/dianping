DROP TABLE IF EXISTS dianping_db.`user`;
CREATE TABLE dianping_db.`user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updated_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `telephone` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nick_name` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `telephone_unique_index` (`telephone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;