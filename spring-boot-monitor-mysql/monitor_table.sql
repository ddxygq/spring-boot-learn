/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-26 11:53:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `monitor_table`
-- ----------------------------
DROP TABLE IF EXISTS `monitor_table`;
CREATE TABLE `monitor_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) NOT NULL DEFAULT '' COMMENT '表名',
  `date_column_name` varchar(255) NOT NULL COMMENT '日期列的列名',
  `status` varchar(255) NOT NULL DEFAULT '' COMMENT '是否启用',
  `realtime` varchar(255) NOT NULL DEFAULT '' COMMENT '是实时还是离线',
  `hour_column_name` varchar(255) DEFAULT '' COMMENT '如果是实时的话保存小时的列名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_33qgy7n8hu0us8ik8k7nu77sy` (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monitor_table
-- ----------------------------