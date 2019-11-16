/*
 Navicat Premium Data Transfer

 Source Server         : alibaba
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 120.78.206.78:3306
 Source Schema         : studentmanagesystem

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 16/11/2019 22:54:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `aage` int(11) NULL DEFAULT NULL,
  `identifyNum` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `passwd` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'root', 25, '320622111111111111', 'Root111');
INSERT INTO `administrator` VALUES (15, '李四', 25, '320622111111111111', 'Root111');

-- ----------------------------
-- Table structure for applyRoom
-- ----------------------------
DROP TABLE IF EXISTS `applyRoom`;
CREATE TABLE `applyRoom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fun` int(8) NULL DEFAULT NULL COMMENT '0为住宿申请，1为退宿申请',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of applyRoom
-- ----------------------------
INSERT INTO `applyRoom` VALUES (1, 'ss', NULL);
INSERT INTO `applyRoom` VALUES (22, '20161234', 1);

-- ----------------------------
-- Table structure for bankCard
-- ----------------------------
DROP TABLE IF EXISTS `bankCard`;
CREATE TABLE `bankCard`  (
  `cardNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bankCard
-- ----------------------------
INSERT INTO `bankCard` VALUES ('12223355522', '552255');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `buildingNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enterTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enterPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `room` VALUES (13, '12', 'A111', '20161234', '2019-10-16', '111');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `stuNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sage` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `birthdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identifyNum` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `check` int(11) NULL DEFAULT NULL COMMENT '0为注销状态',
  `clazz` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `passwd` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `balance` double(255, 0) NULL DEFAULT NULL,
  `roomId` int(255) NULL DEFAULT NULL,
  `academic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastBalance` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (10, '123', '匹配', '13', '2017-1-1', '2312414142131412412', '江苏', '13127723113', 0, '1232', '123', 0, 0, '计算机', NULL);
INSERT INTO `student` VALUES (11, '20161111', '11', '11', '11', '2131214241', 'eeeee', '12321321313', 1, '1232', '20161111', 0, 0, '计算机', NULL);
INSERT INTO `student` VALUES (12, '20161234', '张三', '12', '2017-1-1', '123142432412411214421', '', '', 1, '123131', '1234', 2871, 1, '计算机', 122);
INSERT INTO `student` VALUES (13, '2016124', '匹配', '11111', '11', 'dsad', '上海', '13127778025', 1, '123', '2016124', 0, 0, '计算机', 0);

SET FOREIGN_KEY_CHECKS = 1;
