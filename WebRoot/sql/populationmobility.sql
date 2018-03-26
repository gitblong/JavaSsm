/*
Navicat MySQL Data Transfer

Source Server         : Blong
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : populationmobility

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-12-01 16:56:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for assistant
-- ----------------------------
DROP TABLE IF EXISTS `assistant`;
CREATE TABLE `assistant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assistant_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint(255) DEFAULT NULL,
  `zone_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_assistant_role` (`role_id`),
  KEY `fk_assistant_zone` (`zone_id`),
  CONSTRAINT `fk_assistant_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_assistant_zone` FOREIGN KEY (`zone_id`) REFERENCES `zone` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assistant
-- ----------------------------
INSERT INTO `assistant` VALUES ('1', '大一', '666', '5', '1');
INSERT INTO `assistant` VALUES ('2', '大二', '666', '5', '2');
INSERT INTO `assistant` VALUES ('3', '大三', '666', '5', '3');
INSERT INTO `assistant` VALUES ('4', '大四', '666', '5', '4');
INSERT INTO `assistant` VALUES ('5', '大五', '666', '5', '5');
INSERT INTO `assistant` VALUES ('6', '大六', '666', '5', '6');
INSERT INTO `assistant` VALUES ('7', '大七', '666', '5', '7');
INSERT INTO `assistant` VALUES ('8', '大八', '666', '5', '8');
INSERT INTO `assistant` VALUES ('9', '大九', '666', '5', '9');
INSERT INTO `assistant` VALUES ('10', '大师', '666', '5', '10');
INSERT INTO `assistant` VALUES ('11', '阿大', '666', '5', '11');
INSERT INTO `assistant` VALUES ('12', 'test', 'test', '5', '1');

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL,
  `permission` varchar(255) NOT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu` (`menu_id`),
  CONSTRAINT `fk_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '角色权限', '1', 'role');
INSERT INTO `authority` VALUES ('2', '账号管理', '1', 'accountManger');
INSERT INTO `authority` VALUES ('3', '修改密码', '1', 'password');
INSERT INTO `authority` VALUES ('4', '房东账户管理', '2', 'landlord');
INSERT INTO `authority` VALUES ('5', '房客信息', '2', 'tenant');
INSERT INTO `authority` VALUES ('6', '分区管理', '2', 'distinctManager');
INSERT INTO `authority` VALUES ('7', '协管员账号', '2', 'assistantManager');

-- ----------------------------
-- Table structure for landlord
-- ----------------------------
DROP TABLE IF EXISTS `landlord`;
CREATE TABLE `landlord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `landlord_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zone_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_zone_id` (`zone_id`),
  CONSTRAINT `fk_zone_id` FOREIGN KEY (`zone_id`) REFERENCES `zone` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of landlord
-- ----------------------------
INSERT INTO `landlord` VALUES ('1', '小一', '666', '15888988972', '330702199009264116K', '丹光东路528号徐斌', '1');
INSERT INTO `landlord` VALUES ('2', '小二', '666', '13095797678', '330702196412080014J', '丹光东路519号郑苏姣', '2');
INSERT INTO `landlord` VALUES ('3', '小三', '666', '13516963311', '330702196412080014I', '丹光东路519号郑苏姣', '2');
INSERT INTO `landlord` VALUES ('4', '小四', '666', '13516963312', '330702196412080014H', '丹光东路528号徐斌', '1');
INSERT INTO `landlord` VALUES ('5', '小五', '666', '13516963313', '330702196412080014G', '丹光东路528号徐斌', '1');
INSERT INTO `landlord` VALUES ('6', '小六', '666', '13516963314', '330702196412080014F', '丹光东路519号郑苏姣', '2');
INSERT INTO `landlord` VALUES ('7', '小七', '666', '13516963318', '330702196412080014E', '丹光东路528号徐斌', '1');
INSERT INTO `landlord` VALUES ('8', '小八', '666', '13516963319', '330702196412080014D', '丹光东路519号郑苏姣', '2');
INSERT INTO `landlord` VALUES ('9', '小九', '666', '13516963315', '330702196412080014C', '丹光东路528号徐斌', '1');
INSERT INTO `landlord` VALUES ('10', '小石', '666', '13516963316', '330702196412080014B', '丹光东路528号徐斌', '1');
INSERT INTO `landlord` VALUES ('11', '十一', '666', '13516963317', '330702196412080014A', '丹光东路519号郑苏姣', '2');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统设置');
INSERT INTO `menu` VALUES ('2', '流动人口');
INSERT INTO `menu` VALUES ('3', '申报统计');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `role_authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', '1,2,3,4,5,6,7,');
INSERT INTO `role` VALUES ('2', '普通用户', '');
INSERT INTO `role` VALUES ('3', '派出所', '4,5,6,7,');
INSERT INTO `role` VALUES ('4', '房东', '5,');
INSERT INTO `role` VALUES ('5', '协管员', '4,5,');

-- ----------------------------
-- Table structure for tenant
-- ----------------------------
DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(255) DEFAULT NULL,
  `room_number` varchar(11) DEFAULT NULL,
  `landlord_id` int(11) DEFAULT NULL,
  `check_in_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `check_out_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_landlord_id` (`landlord_id`),
  CONSTRAINT `fk_landlord_id` FOREIGN KEY (`landlord_id`) REFERENCES `landlord` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant
-- ----------------------------
INSERT INTO `tenant` VALUES ('1', 'user1', '101', '1', '2016-11-29 21:40:52', '2016-11-29 21:40:52', '金華市');
INSERT INTO `tenant` VALUES ('2', 'user2', '102', '2', '2016-11-29 21:40:53', '2016-11-29 21:40:53', '金華市');
INSERT INTO `tenant` VALUES ('3', 'user3', '103', '1', '2016-11-29 21:40:53', '2016-11-29 21:40:53', '金華市');
INSERT INTO `tenant` VALUES ('4', 'user4', '104', '3', '2016-11-29 21:40:54', '2016-11-29 21:40:54', '金華市');
INSERT INTO `tenant` VALUES ('5', 'user5', '105', '3', '2016-11-29 21:40:58', '2016-11-29 21:40:58', '金華市');
INSERT INTO `tenant` VALUES ('6', 'user6', '106', '2', '2016-11-29 21:40:58', '2016-11-29 21:40:58', '金華市');
INSERT INTO `tenant` VALUES ('7', 'user7', '107', '1', '2016-11-29 21:40:59', '2016-11-29 21:40:59', '金華市');
INSERT INTO `tenant` VALUES ('8', 'user8', '108', '2', '2016-11-29 21:40:59', '2016-11-29 21:40:59', '金華市');
INSERT INTO `tenant` VALUES ('9', 'user9', '109', '1', '2016-11-29 21:41:00', '2016-11-29 21:41:00', '金華市');
INSERT INTO `tenant` VALUES ('12', 'user12', '113', '2', '2016-11-30 14:54:58', '2016-11-30 14:54:58', '金華市');
INSERT INTO `tenant` VALUES ('13', 'user13', '113', '1', '2016-11-29 21:41:01', '2016-11-29 21:41:01', '金華市');
INSERT INTO `tenant` VALUES ('14', 'user14', '114', '2', '2016-11-29 21:41:02', '2016-11-29 21:41:02', '金華市');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` bigint(255) DEFAULT NULL,
  `landlord_id` int(11) DEFAULT NULL,
  `zone_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_id` (`role_id`),
  KEY `fk_user_landlord_id` (`landlord_id`),
  KEY `fk_user_zone` (`zone_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_landlord_id` FOREIGN KEY (`landlord_id`) REFERENCES `landlord` (`id`),
  CONSTRAINT `fk_user_zone` FOREIGN KEY (`zone_id`) REFERENCES `zone` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '1', null, null);
INSERT INTO `user` VALUES ('2', 'xiaoquan', '666', '1', null, null);
INSERT INTO `user` VALUES ('3', 'xiaolong', '666', '1', null, null);
INSERT INTO `user` VALUES ('4', 'yelaoshi ', '666', '3', null, null);
INSERT INTO `user` VALUES ('5', 'hanglaoshi', '666', '3', null, null);
INSERT INTO `user` VALUES ('6', 'banzhang', '666', '4', '1', null);
INSERT INTO `user` VALUES ('7', 'gaigai', '666', '4', '2', null);
INSERT INTO `user` VALUES ('8', 'zhixiu', '666', '5', null, '1');
INSERT INTO `user` VALUES ('9', 'xiaohong', '666', '5', null, '2');
INSERT INTO `user` VALUES ('10', 'tingting', '666', '2', null, null);
INSERT INTO `user` VALUES ('11', 'wangzhe', '666', '2', null, null);
INSERT INTO `user` VALUES ('12', 'xiaoyu', '666', '2', null, null);
INSERT INTO `user` VALUES ('13', 'yanghaorui', '666', '2', null, null);
INSERT INTO `user` VALUES ('14', 'chenjialin', '666', '2', null, null);
INSERT INTO `user` VALUES ('15', 'haohuijun', '666', '2', null, null);
INSERT INTO `user` VALUES ('16', 'xiaoyanzi', '666', '2', null, null);
INSERT INTO `user` VALUES ('17', 'wangjiao', '666', '2', null, null);
INSERT INTO `user` VALUES ('18', 'jingjing', '666', '2', null, null);
INSERT INTO `user` VALUES ('19', 'bingyi', '666', '2', null, null);
INSERT INTO `user` VALUES ('20', 'fulaoda', '666', '2', null, null);
INSERT INTO `user` VALUES ('21', 'xuping', '666', '2', null, null);

-- ----------------------------
-- Table structure for zone
-- ----------------------------
DROP TABLE IF EXISTS `zone`;
CREATE TABLE `zone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zone_name` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zone
-- ----------------------------
INSERT INTO `zone` VALUES ('1', '婺城区', '金华市');
INSERT INTO `zone` VALUES ('2', '金东区', '金华市');
INSERT INTO `zone` VALUES ('3', '武义县', '金华市');
INSERT INTO `zone` VALUES ('4', '浦江县', '金华市');
INSERT INTO `zone` VALUES ('5', '磐安县', '金华市');
INSERT INTO `zone` VALUES ('6', '兰溪县', '金华市');
INSERT INTO `zone` VALUES ('7', '义务县', '金华市');
INSERT INTO `zone` VALUES ('8', '东阳县', '金华市');
INSERT INTO `zone` VALUES ('9', '永康县', '金华市');
INSERT INTO `zone` VALUES ('10', '永康县', '金华市');
INSERT INTO `zone` VALUES ('11', '永康县', '金华市');
INSERT INTO `zone` VALUES ('12', 'test', 'test');
INSERT INTO `zone` VALUES ('13', 'test', 'test');
SET FOREIGN_KEY_CHECKS=1;
