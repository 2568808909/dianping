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

CREATE TABLE `dianping_db`.`seller`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '商家名',
  `created_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0 COMMENT '商家评分',
  `disabled_flag` int(0) NOT NULL DEFAULT 0 COMMENT '上下架',
  PRIMARY KEY (`id`)
);


CREATE TABLE `dianping_db`.`category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '品类名',
  `icon_url` varchar(200) NOT NULL DEFAULT '' COMMENT '图标url',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序号',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique_index`(`name`) USING BTREE
);


CREATE TABLE `dianping_db`.`shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '门店名',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0 COMMENT '评分',
  `price_per_man` int(0) NOT NULL DEFAULT 0 COMMENT '人均消费',
  `latitude` decimal(10, 6) NOT NULL DEFAULT 0 COMMENT '纬度',
  `longitude` decimal(10, 6) NOT NULL DEFAULT 0 COMMENT '经度',
  `category_id` int(0) NOT NULL DEFAULT 0 COMMENT '品类id',
  `tags` varchar(2000) NOT NULL DEFAULT '' COMMENT '标签',
  `start_time` varchar(200) NOT NULL DEFAULT '',
  `end_time` varchar(200) NOT NULL DEFAULT '',
  `address` varchar(200) NOT NULL DEFAULT '' COMMENT '门店地址',
  `seller_id` int(0) NOT NULL DEFAULT 0 COMMENT '商家id',
  `icon_url` varchar(100) NOT NULL DEFAULT '' COMMENT '图标url',
  PRIMARY KEY (`id`)
);