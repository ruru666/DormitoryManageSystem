/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 06/01/2020 17:35:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `a_uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `a_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `a_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `a_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `a_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '罗方', '男', '15079110117');
INSERT INTO `admin` VALUES (2, 'admin1', 'admin1', '单爽', '女', '15322445689');
INSERT INTO `admin` VALUES (3, 'admin2', 'admin2', '赵文轩', '男', '18970581279');
INSERT INTO `admin` VALUES (4, 'admin3', 'admin3', '罗旭东', '男', '15352851258');
INSERT INTO `admin` VALUES (5, 'admin4', 'admin4', '吴青青', '女', '15589851702');
INSERT INTO `admin` VALUES (6, 'admin5', 'admin5', '邹子政', '男', '17258051285');
INSERT INTO `admin` VALUES (7, 'admin6', 'admin6', '刘建阳', '男', '18022981105');
INSERT INTO `admin` VALUES (8, 'admin7', 'admin7', '张欢', '女', '17755081297');
INSERT INTO `admin` VALUES (9, 'admin8', 'admin8', '刘泽', '男', '18950781259');
INSERT INTO `admin` VALUES (10, 'admin9', 'admin9', '涂龙龙', '男', '15278469958');
INSERT INTO `admin` VALUES (11, 'admin10', 'admin10', '刘世瑞', '男', '17598501248');
INSERT INTO `admin` VALUES (12, 'admin11', 'admin11', '邱佳威', '男', '18870589468');
INSERT INTO `admin` VALUES (13, 'admin12', 'admin12', '罗旭欣', '女', '15877592479');
INSERT INTO `admin` VALUES (14, 'admin13', 'admin13', '郑子成', '男', '17955084579');
INSERT INTO `admin` VALUES (15, 'admin14', 'admin14', '涂威', '男', '15822067946');
INSERT INTO `admin` VALUES (16, 'admin15', 'admin15', '罗龙', '男', '18870586429');
INSERT INTO `admin` VALUES (17, 'admin16', 'admin16', '刘韩湘', '女', '15344791279');
INSERT INTO `admin` VALUES (18, 'admin17', 'admin17', '戴志远', '男', '17956891246');
INSERT INTO `admin` VALUES (19, 'admin18', 'admin18', '余坤龙	', '男', '15501347856');
INSERT INTO `admin` VALUES (20, 'admin19', 'admin19', '朱承毅', '男', '18970581246');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKAE9476D4D4BDD935`(`b_id`) USING BTREE,
  INDEX `FKAABA12B4D4BDD935`(`b_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, '学生公寓01楼', '男生宿舍', 1);
INSERT INTO `building` VALUES (2, '学生公寓02楼', '男生宿舍', 2);
INSERT INTO `building` VALUES (3, '学生公寓03楼', '女生宿舍', 3);
INSERT INTO `building` VALUES (4, '学生公寓04楼', '女生宿舍', 4);
INSERT INTO `building` VALUES (5, '学生公寓05楼', '男生宿舍', 5);
INSERT INTO `building` VALUES (6, '学生公寓06楼', '男生宿舍', 6);
INSERT INTO `building` VALUES (7, '学生公寓07楼', '男生宿舍', 7);
INSERT INTO `building` VALUES (8, '学生公寓08楼', '男生宿舍', 8);
INSERT INTO `building` VALUES (9, '学生公寓09楼', '女生宿舍', 9);
INSERT INTO `building` VALUES (10, '学生公寓10楼', '男生宿舍', 10);
INSERT INTO `building` VALUES (11, '学生公寓11楼', '女生宿舍', 11);
INSERT INTO `building` VALUES (12, '学生公寓12楼', '女生宿舍', 12);
INSERT INTO `building` VALUES (13, '学生公寓13楼', '男生宿舍', 13);
INSERT INTO `building` VALUES (14, '学生公寓14楼', '男生宿舍', 14);
INSERT INTO `building` VALUES (15, '学生公寓15楼', '男生宿舍', 15);
INSERT INTO `building` VALUES (16, '学生公寓16楼', '女生宿舍', 16);
INSERT INTO `building` VALUES (17, '学生公寓17楼', '女生宿舍', 17);
INSERT INTO `building` VALUES (18, '学生公寓18楼', '男生宿舍', 18);
INSERT INTO `building` VALUES (19, '学生公寓19楼', '男生宿舍', 19);
INSERT INTO `building` VALUES (20, '学生公寓20楼', '男生宿舍', 20);
INSERT INTO `building` VALUES (21, '学生公寓21楼', '男生宿舍', 21);

-- ----------------------------
-- Table structure for buildingadmin
-- ----------------------------
DROP TABLE IF EXISTS `buildingadmin`;
CREATE TABLE `buildingadmin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `b_uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buildingadmin
-- ----------------------------
INSERT INTO `buildingadmin` VALUES (1, 'teacher', 'teacher', ' 朱自清', '男', '13979022333');
INSERT INTO `buildingadmin` VALUES (2, 'teacher1', 'teacher1', ' 曾雨', '男', '18379522370');
INSERT INTO `buildingadmin` VALUES (3, 'teacher2', 'teacher2', '冯绍薇', '女', '15979162405');
INSERT INTO `buildingadmin` VALUES (4, 'teacher3', 'teacher3', '曾雨超', '女', '17770844008');
INSERT INTO `buildingadmin` VALUES (5, 'teacher4', 'teacher4', '鞠晓朋', '男', '15797639137');
INSERT INTO `buildingadmin` VALUES (6, 'teacher5', 'teacher5', '黄晓', '女', '15970384949');
INSERT INTO `buildingadmin` VALUES (7, 'teacher6', 'teacher6', '李薇民', '女', '15797639618');
INSERT INTO `buildingadmin` VALUES (8, 'teacher7', 'teacher7', '甘雨赓', '女', '17770046638');
INSERT INTO `buildingadmin` VALUES (9, 'teacher8', 'teacher8', '黄晓清', '女', '15797704304');
INSERT INTO `buildingadmin` VALUES (10, 'teacher9', 'teacher9', '郭雨元', '女', '15180604700');
INSERT INTO `buildingadmin` VALUES (11, 'teacher10', 'teacher10', '赖薇文', '女', '18307947489');
INSERT INTO `buildingadmin` VALUES (12, 'teacher11', 'teacher11', '王晓', '女', '15216007017');
INSERT INTO `buildingadmin` VALUES (13, 'teacher12', 'teacher12', '詹薇霖', '女', '15770683657');
INSERT INTO `buildingadmin` VALUES (14, 'teacher13', 'teacher13', '胡雨', '女', '15083505510');
INSERT INTO `buildingadmin` VALUES (15, 'teacher14', 'teacher14', '魏辽', '女', '15180401521');
INSERT INTO `buildingadmin` VALUES (16, 'teacher15', 'teacher15', '胡晓', '女', '17770046774');
INSERT INTO `buildingadmin` VALUES (17, 'teacher16', 'teacher16', '刘霆晓', '男', '15279464013');
INSERT INTO `buildingadmin` VALUES (18, 'teacher17', 'teacher17', '郑薇亮', '女', '15970650221');
INSERT INTO `buildingadmin` VALUES (19, 'teacher18', 'teacher18', '付薇平', '女', '15970650519');
INSERT INTO `buildingadmin` VALUES (20, 'teacher19', 'teacher19', '蓝勇薇', '女', '15180111574');
INSERT INTO `buildingadmin` VALUES (21, 'teacher21', 'teacher21', '朱楠', '女', '15093846995');
INSERT INTO `buildingadmin` VALUES (22, 'teacher22', 'teacher22', '周浩', '女', '15074152695');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `building_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKBB549D85B7DD6DD8`(`building_id`) USING BTREE,
  INDEX `FK43E27DA5B7DD6DD8`(`building_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES (1, '16425', '3人寝', 16);
INSERT INTO `dormitory` VALUES (2, '15402', '四人寝', 15);
INSERT INTO `dormitory` VALUES (3, '15403', '四人寝', 15);
INSERT INTO `dormitory` VALUES (4, '4405', '8人寝', 4);
INSERT INTO `dormitory` VALUES (5, '5507', '8人寝', 3);

-- ----------------------------
-- Table structure for leaveschool
-- ----------------------------
DROP TABLE IF EXISTS `leaveschool`;
CREATE TABLE `leaveschool`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) NULL DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK16B318EB935A4644`(`s_id`) USING BTREE,
  INDEX `FKE9E484EB935A4644`(`s_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leaveschool
-- ----------------------------
INSERT INTO `leaveschool` VALUES (1, 2, '王五', '2019-12-17 22:36:41', '迁出');
INSERT INTO `leaveschool` VALUES (2, 1, '刘一', '2019-12-22 00:29:17', '迁出');
INSERT INTO `leaveschool` VALUES (3, 12, '王一博', '2019-12-23 14:39:59', '迁出');

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `s_id` int(11) NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK36819AB935A4644`(`s_id`) USING BTREE,
  INDEX `FKFF8DB58B935A4644`(`s_id`) USING BTREE,
  INDEX `FKFF8DB58B93264AAB`(`sid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES (1, '16号楼4楼', '楼道里面的灯坏了', '15093845050', '2019-12-17 22:35:32', 1, '已维修', NULL);
INSERT INTO `maintain` VALUES (4, '66', '66', '66', NULL, 1, NULL, NULL);
INSERT INTO `maintain` VALUES (3, '99', '99', '99', '2019-12-10 12:33:20', 1, '我', NULL);
INSERT INTO `maintain` VALUES (5, '77', '77', '77', NULL, 1, NULL, NULL);
INSERT INTO `maintain` VALUES (6, '77', '77', '77', NULL, 1, NULL, NULL);
INSERT INTO `maintain` VALUES (7, '66', '去11', '1111', NULL, 1, NULL, NULL);
INSERT INTO `maintain` VALUES (8, '66', '去11', '1111', NULL, 1, NULL, NULL);
INSERT INTO `maintain` VALUES (9, '15号楼3楼', '楼道灯坏了', '15093846995', NULL, 1, NULL, NULL);
INSERT INTO `maintain` VALUES (10, '15号楼2楼', '15203宿舍的灯不亮了', '15023698456', '2019-12-22 14:01:21', 1, NULL, NULL);
INSERT INTO `maintain` VALUES (11, '15号楼1楼', '楼道电路不良', '15678945236', '2019-12-22 14:03:31', 1, NULL, NULL);
INSERT INTO `maintain` VALUES (12, '15号楼4楼', '15236', '15094567852', '2019-12-22 14:24:34', 1, NULL, NULL);
INSERT INTO `maintain` VALUES (13, '99', '99', '11', '2019-12-23 14:42:14', 1, '未维修', NULL);
INSERT INTO `maintain` VALUES (14, '99', '99', '1', '2019-12-23 14:45:34', 1, '未维修', NULL);

-- ----------------------------
-- Table structure for sleeprecords
-- ----------------------------
DROP TABLE IF EXISTS `sleeprecords`;
CREATE TABLE `sleeprecords`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `b_id` int(11) NULL DEFAULT NULL,
  `s_id` int(11) NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK4550CB8B935A4644`(`s_id`) USING BTREE,
  INDEX `FK4550CB8BD4BDD935`(`b_id`) USING BTREE,
  INDEX `FKD84CDF8B935A4644`(`s_id`) USING BTREE,
  INDEX `FKD84CDF8BD4BDD935`(`b_id`) USING BTREE,
  INDEX `FKD84CDF8B93264AAB`(`sid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sleeprecords
-- ----------------------------
INSERT INTO `sleeprecords` VALUES (1, '刘一', '2019-12-17 22:33:29', 1, 1, '缺寝', 1);
INSERT INTO `sleeprecords` VALUES (2, '高明', '2019-12-22 01:14:59', 6, 11, '缺寝', 2);
INSERT INTO `sleeprecords` VALUES (3, '苗苗', '2019-12-23 13:46:09', 1, 7, '缺勤', NULL);
INSERT INTO `sleeprecords` VALUES (4, '浩浩', '2019-12-23 14:19:24', 1, 6, '缺勤', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_building` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `s_dormitory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `FK8FFE823BD4BDD935`(`b_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '171530311', '171530311', '刘一', '男', '15093846995', '16', '16423', 16);
INSERT INTO `student` VALUES (2, '171530312', '171530312', '腾西', '男', '15093846997', '16', '16423', 16);
INSERT INTO `student` VALUES (3, '171530322', '171530322', '王五', '女', '15093846999', '2', '2303', 2);
INSERT INTO `student` VALUES (5, '171530336', '123456', '刘淼', '男', '15093621256', '1', '1123', 1);
INSERT INTO `student` VALUES (6, '171830302', '171830302', '浩浩', '男', '15023647516', '1', '1506', 1);
INSERT INTO `student` VALUES (7, '171530331', '171530331', '苗苗', '女', '15093847895', '1', '15207', 15);
INSERT INTO `student` VALUES (8, '171530332', '171530332', '高天', '男', '15093967562', '1', '13502', 1);
INSERT INTO `student` VALUES (9, '171530340', '171530340', '刘啊', '女', '15074123695', '1', '18203', 1);
INSERT INTO `student` VALUES (10, '171530341', '171530341', '闫冰运', '男', '15074123697', '1', '13506', 1);
INSERT INTO `student` VALUES (11, '171530220', '171530220', '高明', '女', '15012365489', '1', '6203', 1);
INSERT INTO `student` VALUES (12, '171530236', '171530236', '王一博', '男', '15093847897', '16', '16425', NULL);

SET FOREIGN_KEY_CHECKS = 1;
