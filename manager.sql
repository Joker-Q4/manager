/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : manager

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 04/01/2021 14:48:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `admin_account_uindex`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for business_practice
-- ----------------------------
DROP TABLE IF EXISTS `business_practice`;
CREATE TABLE `business_practice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '企业名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `student_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生参加企业实践活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `file_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `combined_language` decimal(4, 2) NULL DEFAULT NULL COMMENT 'C语言',
  `combined_language_plus` decimal(4, 2) NULL DEFAULT NULL COMMENT 'C++',
  `advanced_mathematics` decimal(4, 2) NULL DEFAULT NULL COMMENT '高等数学',
  `english` decimal(4, 2) NULL DEFAULT NULL COMMENT '英语',
  `data_structure` decimal(4, 2) NULL DEFAULT NULL COMMENT '数据结构',
  `java` decimal(4, 2) NULL DEFAULT NULL,
  `computer_principles` decimal(4, 2) NULL DEFAULT NULL COMMENT '计算机原理',
  `computer_network` decimal(4, 2) NULL DEFAULT NULL COMMENT '计算机网络',
  `oracle` decimal(4, 2) NULL DEFAULT NULL COMMENT 'oracle数据库',
  `web` decimal(4, 2) NULL DEFAULT NULL COMMENT 'web应用程序设计',
  `student_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生成绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for industry_experience
-- ----------------------------
DROP TABLE IF EXISTS `industry_experience`;
CREATE TABLE `industry_experience`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实践描述',
  `time` date NULL DEFAULT NULL COMMENT '实践时间',
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实践地点',
  `teacher_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师行业实践经历' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for patent_authorization
-- ----------------------------
DROP TABLE IF EXISTS `patent_authorization`;
CREATE TABLE `patent_authorization`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `file_id` int(0) NULL DEFAULT NULL COMMENT '绑定文件',
  `student_id` int(0) NULL DEFAULT NULL COMMENT '绑定学生',
  `teacher_id` int(0) NULL DEFAULT NULL COMMENT '绑定教师',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '专利授权' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for prize
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL,
  `student_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生获奖表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_achievement
-- ----------------------------
DROP TABLE IF EXISTS `project_achievement`;
CREATE TABLE `project_achievement`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `file_id` int(0) NULL DEFAULT NULL COMMENT '文件',
  `student_id` int(0) NULL DEFAULT NULL COMMENT '所属学生',
  `teacher_id` int(0) NULL DEFAULT NULL COMMENT '所属教师',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目成果（教师&学生）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for science_technology_award
-- ----------------------------
DROP TABLE IF EXISTS `science_technology_award`;
CREATE TABLE `science_technology_award`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名字',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `file_id` int(0) NULL DEFAULT NULL COMMENT '文件',
  `student_id` int(0) NULL DEFAULT NULL COMMENT '所属学生',
  `teacher_id` int(0) NULL DEFAULT NULL COMMENT '所属教师',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '科技成果奖（教师&学生）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父ID',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单图标',
  `href` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '链接',
  `target` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '_self' COMMENT '链接打开方式',
  `sort` int(0) NULL DEFAULT 0 COMMENT '菜单排序',
  `status` tinyint(0) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0:禁用,1:启用)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_at` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_at` timestamp(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `title`(`title`) USING BTREE,
  INDEX `href`(`href`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 252 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES (1, 0, '首页', 'fa fa-adjust', 'login.html', '_self', 0, 1, '', '2020-04-13 15:40:57', NULL, NULL);
INSERT INTO `system_menu` VALUES (2, 1, '管理', 'fa fa-adjust', '', '_self', 0, 1, '', '2020-04-13 19:27:02', NULL, NULL);
INSERT INTO `system_menu` VALUES (3, 2, '学生信息', 'fa fa-adjust', 'pages/student/student.html', '_self', 0, 1, '', '2020-04-14 09:40:35', NULL, NULL);
INSERT INTO `system_menu` VALUES (4, 2, '教师信息', 'fa fa-adjust', 'pages/teacher/teacher.html', '_self', 1, 1, '', '2020-04-14 14:22:04', NULL, NULL);
INSERT INTO `system_menu` VALUES (5, 1, '接口查看', 'fa fa-adjust', 'pages/interface.html', '_self', 1, 1, '', '2020-04-14 14:22:04', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for system_setting
-- ----------------------------
DROP TABLE IF EXISTS `system_setting`;
CREATE TABLE `system_setting`  (
  `key` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `value` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_setting
-- ----------------------------
INSERT INTO `system_setting` VALUES ('home_href', 'pages/welcome.html');
INSERT INTO `system_setting` VALUES ('home_title', '首页');
INSERT INTO `system_setting` VALUES ('logo_href', 'images/logo.png');
INSERT INTO `system_setting` VALUES ('logo_title', 'GYY');

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教师编号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `academic_degree` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学位',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '高级职称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teaching_situation
-- ----------------------------
DROP TABLE IF EXISTS `teaching_situation`;
CREATE TABLE `teaching_situation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `combined_language` tinyint(0) NULL DEFAULT NULL COMMENT 'C语言 0没有;1有',
  `combined_language_plus` tinyint(0) NULL DEFAULT NULL COMMENT 'C++ 0没有;1有',
  `advanced_mathematics` tinyint(0) NULL DEFAULT NULL COMMENT '高等数学 0没有;1有',
  `english` tinyint(0) NULL DEFAULT NULL COMMENT '英语 0没有;1有',
  `data_structure` tinyint(0) NULL DEFAULT NULL COMMENT '数据结构 0没有;1有',
  `java` tinyint(0) NULL DEFAULT NULL COMMENT 'Java 0没有;1有',
  `computer_principles` tinyint(0) NULL DEFAULT NULL COMMENT '计算机原理 0没有;1有',
  `computer_network` tinyint(0) NULL DEFAULT NULL COMMENT '计算机网络 0没有;1有',
  `oracle` tinyint(0) NULL DEFAULT NULL COMMENT 'Oracle数据库 0没有;1有',
  `web` tinyint(0) NULL DEFAULT NULL COMMENT 'web应用程序设计 0没有;1有',
  `teacher_id` int(0) NOT NULL COMMENT '所属教师',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师授课情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thesis
-- ----------------------------
DROP TABLE IF EXISTS `thesis`;
CREATE TABLE `thesis`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '论文题目',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细描述',
  `file_id` int(0) NULL DEFAULT NULL COMMENT '文件',
  `student_id` int(0) NULL DEFAULT NULL COMMENT '所属学生',
  `teacher_id` int(0) NULL DEFAULT NULL COMMENT '所属教师',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生发表论文表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
