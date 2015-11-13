/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : t_db

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2015-11-13 18:37:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `building`
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `xmlId` int(11) DEFAULT NULL,
  `posX` int(11) DEFAULT NULL,
  `posY` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `goldNum` int(11) DEFAULT NULL,
  `elixirNum` int(11) DEFAULT NULL,
  `currHp` int(11) DEFAULT NULL,
  `endBuildingTime` datetime DEFAULT NULL,
  `lastCollectTime` datetime DEFAULT NULL,
  `buildId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building
-- ----------------------------

-- ----------------------------
-- Table structure for `platform_user`
-- ----------------------------
DROP TABLE IF EXISTS `platform_user`;
CREATE TABLE `platform_user` (
  `platformId` varchar(255) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`platformId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_user
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platformId` varchar(255) NOT NULL,
  `rank` int(11) DEFAULT NULL,
  `fame` int(11) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `dimaond` int(11) DEFAULT NULL,
  `buildingId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
