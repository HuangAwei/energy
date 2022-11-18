/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : tzh

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 18/11/2022 15:44:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(20) NULL DEFAULT NULL COMMENT '上级ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, 0, '武汉天之和科技科技有限公司', '2022-11-18 14:10:35', '2022-11-18 14:10:38');
INSERT INTO `dept` VALUES (2, 1, '财务部', '2022-11-18 14:10:35', '2022-11-18 14:10:38');
INSERT INTO `dept` VALUES (3, 1, '行政人事部', '2022-11-18 14:10:35', '2022-11-18 14:10:38');
INSERT INTO `dept` VALUES (4, 1, '工程技术部', '2022-11-18 14:10:35', '2022-11-18 14:10:38');
INSERT INTO `dept` VALUES (5, 1, '法务部', '2022-11-18 14:10:35', '2022-11-18 14:10:38');
INSERT INTO `dept` VALUES (6, 1, '研发部', '2022-11-18 14:10:35', '2022-11-18 14:10:38');
INSERT INTO `dept` VALUES (7, 1, '江西办事处', '2022-11-18 14:10:35', '2022-11-18 14:10:38');

-- ----------------------------
-- Table structure for dict_data
-- ----------------------------
DROP TABLE IF EXISTS `dict_data`;
CREATE TABLE `dict_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典类型ID',
  `dict_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典标签',
  `dict_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典值',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_dict_type_value`(`dict_type`, `dict_value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_data
-- ----------------------------
INSERT INTO `dict_data` VALUES (37, 'gender', '男', '0', '2022-11-18 14:08:31', '2022-11-18 14:08:33');
INSERT INTO `dict_data` VALUES (38, 'gender', '女', '1', '2022-11-18 14:08:31', '2022-11-18 14:08:33');
INSERT INTO `dict_data` VALUES (39, 'gender', '保密', '2', '2022-11-18 14:08:31', '2022-11-18 14:08:33');

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典类型',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '字典名称',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES (5, 'gender', '性别', '2022-11-18 14:06:10', '2022-11-18 14:06:12');

-- ----------------------------
-- Table structure for energy_consumption
-- ----------------------------
DROP TABLE IF EXISTS `energy_consumption`;
CREATE TABLE `energy_consumption`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institution_id` int(11) NOT NULL,
  `e` double NULL DEFAULT NULL COMMENT '统计期内综合能耗，单位为千克标准煤每年（kgce/a）',
  `emz` double NULL DEFAULT NULL COMMENT '单位建筑面积综合能耗，单位为千克标准煤每平方米年（kgce/m2·a）',
  `emd` double NULL DEFAULT NULL COMMENT '单位建筑面积电耗，单位为千瓦时每平方米年（kW·h/m2·a）',
  `erz` double NULL DEFAULT NULL COMMENT '人均综合能耗，单位为千克标准煤每人年（kgce/per·a）',
  `m` double NULL DEFAULT NULL COMMENT '建筑面积，单位为平方米（m2）',
  `ed` double NULL DEFAULT NULL COMMENT '统计期内电力消耗总量，单位为千瓦时每年（kW·h/a）',
  `n` int(11) NULL DEFAULT NULL COMMENT '总人数',
  `t` double NULL DEFAULT NULL COMMENT '年实际使用时间，单位为小时每年（h/a）',
  `q` double NULL DEFAULT NULL COMMENT '住院人均住院部面积',
  `date` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间（统计年份）',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of energy_consumption
-- ----------------------------
INSERT INTO `energy_consumption` VALUES (4, 1, 317.14, 0.1119138726140457, 1.2894409110541811, 1.066245354129545, 2565, 3654, 266, 5321, 12564, '2022', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (16, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2025', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (17, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2026', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (18, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2027', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (19, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2028', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (20, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2029', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (21, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (22, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (23, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2024', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (24, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (25, 1, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2030', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (26, 2, 0, 0, 42.75517132075472, 0, 106000, 3684592, 2000, 0, NULL, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (27, 6, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_consumption` VALUES (28, 6, 0, 0, 34.760301886792455, 0, 106000, 3684592, 2000, 0, NULL, '2021', '2022-11-18 13:49:00');

-- ----------------------------
-- Table structure for energy_institution
-- ----------------------------
DROP TABLE IF EXISTS `energy_institution`;
CREATE TABLE `energy_institution`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `energy_id` int(11) NOT NULL,
  `institution_id` int(11) NOT NULL,
  `value` double NOT NULL DEFAULT 0 COMMENT '消耗量',
  `date` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间（统计年份）',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of energy_institution
-- ----------------------------
INSERT INTO `energy_institution` VALUES (1, 37, 1, 100, '2022', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (2, 38, 1, 100, '2022', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (9, 37, 3, 0, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (10, 38, 3, 0, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (11, 37, 6, 0, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (12, 38, 6, 0, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (13, 37, 5, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (14, 38, 5, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (15, 37, 5, 0, '2024', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (16, 38, 5, 0, '2024', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (17, 37, 5, 0, '2025', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (18, 38, 5, 0, '2025', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (25, 37, 1, 0, '2025', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (26, 38, 1, 0, '2025', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (27, 37, 1, 0, '2026', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (28, 38, 1, 0, '2026', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (29, 37, 1, 0, '2027', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (30, 38, 1, 0, '2027', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (31, 37, 1, 0, '2028', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (32, 38, 1, 0, '2028', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (33, 37, 1, 0, '2029', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (34, 38, 1, 0, '2029', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (35, 37, 1, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (36, 38, 1, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (37, 37, 1, 0, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (38, 38, 1, 0, '2023', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (39, 37, 1, 0, '2024', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (40, 38, 1, 0, '2024', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (41, 37, 1, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (42, 38, 1, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (43, 37, 1, 0, '2030', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (44, 38, 1, 0, '2030', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (45, 37, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (46, 38, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (47, 55, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (48, 56, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (49, 57, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (50, 58, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (51, 59, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (52, 60, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (53, 61, 2, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (54, 37, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (55, 38, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (56, 55, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (57, 56, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (58, 57, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (59, 58, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (60, 59, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (61, 60, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (62, 61, 6, 0, '2020', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (63, 37, 6, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (64, 38, 6, 0, '2021', '2022-11-18 13:49:00');
INSERT INTO `energy_institution` VALUES (65, 55, 6, 0, '2021', '2022-11-18 13:49:01');
INSERT INTO `energy_institution` VALUES (66, 56, 6, 0, '2021', '2022-11-18 13:49:01');
INSERT INTO `energy_institution` VALUES (67, 57, 6, 0, '2021', '2022-11-18 13:49:01');
INSERT INTO `energy_institution` VALUES (68, 58, 6, 0, '2021', '2022-11-18 13:49:01');
INSERT INTO `energy_institution` VALUES (69, 59, 6, 0, '2021', '2022-11-18 13:49:01');
INSERT INTO `energy_institution` VALUES (70, 60, 6, 0, '2021', '2022-11-18 13:49:01');
INSERT INTO `energy_institution` VALUES (71, 61, 6, 0, '2021', '2022-11-18 13:49:01');

-- ----------------------------
-- Table structure for energy_type
-- ----------------------------
DROP TABLE IF EXISTS `energy_type`;
CREATE TABLE `energy_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `p` double NOT NULL COMMENT '标准煤系数',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '能源类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of energy_type
-- ----------------------------
INSERT INTO `energy_type` VALUES (37, '柴油', 1.4571, '2022-11-10 12:03:30', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (38, '液化石油气', 1.7143, '2022-11-11 12:03:36', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (55, '天然气', 1.2, '2022-11-17 13:41:15', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (56, '液化天然气', 1.7572, '2022-11-17 13:41:49', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (57, '汽油', 1.4714, '2022-11-17 13:42:14', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (58, '燃料油', 1.4286, '2022-11-17 13:42:36', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (59, '热力（当量）', 0.0341, '2022-11-17 13:43:07', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (60, '电力（当量）', 0.1229, '2022-11-17 13:43:31', '2022-11-18 13:52:52');
INSERT INTO `energy_type` VALUES (61, '生物乙醇', 0.9286, '2022-11-17 13:43:53', '2022-11-18 13:52:52');

-- ----------------------------
-- Table structure for institutions
-- ----------------------------
DROP TABLE IF EXISTS `institutions`;
CREATE TABLE `institutions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` int(11) NOT NULL COMMENT '机构类型id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构名称',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of institutions
-- ----------------------------
INSERT INTO `institutions` VALUES (1, 1, '哈哈', '2022-11-11 14:13:01', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (2, 2, 't2', '2022-11-11 14:13:13', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (3, 3, 't3', '2022-11-11 14:13:18', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (5, 1, 't5', '2022-11-11 14:13:31', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (6, 1, '答复', '2022-11-15 11:20:26', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (7, 2, '阿斯蒂芬', '2022-11-15 11:20:34', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (8, 4, '阿嘎', '2022-11-15 11:20:39', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (9, 3, '撒旦飞洒给', '2022-11-15 11:20:43', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (10, 1, '萨嘎', '2022-11-15 11:20:51', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (12, 2, '跟他说', '2022-11-15 11:29:00', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (13, 3, '的萨芬', '2022-11-15 13:56:17', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (14, 11, 'hhhh', '2022-11-15 15:06:17', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (15, 2, '112', '2022-11-18 13:50:11', '2022-11-18 13:51:36');
INSERT INTO `institutions` VALUES (16, 4, '123213', '2022-11-18 13:52:32', '2022-11-18 13:52:32');

-- ----------------------------
-- Table structure for institutions_type
-- ----------------------------
DROP TABLE IF EXISTS `institutions_type`;
CREATE TABLE `institutions_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构类型名称',
  `T0` int(11) NULL DEFAULT NULL COMMENT '年使用时间',
  `S0` int(11) NULL DEFAULT NULL COMMENT '人均建筑面积',
  `Q0` int(11) NULL DEFAULT NULL COMMENT '住院人均住院部面积',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of institutions_type
-- ----------------------------
INSERT INTO `institutions_type` VALUES (1, '高等教育', 4600, 53, NULL, '2022-11-11 15:01:22', NULL);
INSERT INTO `institutions_type` VALUES (2, '中等职业学校', 3880, 30, NULL, '2022-11-11 15:01:25', NULL);
INSERT INTO `institutions_type` VALUES (3, '乡镇高级中学', 3360, 30, NULL, '2022-11-11 15:01:28', NULL);
INSERT INTO `institutions_type` VALUES (4, '市县高级中学', 3360, 25, NULL, '2022-11-11 15:01:31', NULL);
INSERT INTO `institutions_type` VALUES (5, '乡镇初级中学', 1750, 25, NULL, '2022-11-11 15:01:34', NULL);
INSERT INTO `institutions_type` VALUES (6, '市县初级中学', 1750, 20, NULL, '2022-11-11 15:01:36', NULL);
INSERT INTO `institutions_type` VALUES (7, '乡镇完全小学', 1540, 20, NULL, '2022-11-11 15:01:39', NULL);
INSERT INTO `institutions_type` VALUES (8, '市县完全小学', 1540, 15, NULL, '2022-11-11 15:01:41', NULL);
INSERT INTO `institutions_type` VALUES (9, '乡镇中心学校', 1650, 25, NULL, '2022-11-11 15:01:44', NULL);
INSERT INTO `institutions_type` VALUES (10, '学前教育', 1880, 33, NULL, '2022-11-11 15:01:46', NULL);
INSERT INTO `institutions_type` VALUES (11, '一级医院', NULL, 34, 9, '2022-11-11 15:01:49', NULL);
INSERT INTO `institutions_type` VALUES (12, '二级医院', NULL, 38, 9, '2022-11-11 15:01:52', NULL);
INSERT INTO `institutions_type` VALUES (13, '三级医院', NULL, 38, 9, '2022-11-11 15:01:54', NULL);
INSERT INTO `institutions_type` VALUES (14, '党政机关', 2500, 10, NULL, '2022-11-11 15:01:56', NULL);
INSERT INTO `institutions_type` VALUES (15, '场馆', 3000, 15, NULL, '2022-11-11 15:01:59', NULL);

-- ----------------------------
-- Table structure for risk_history
-- ----------------------------
DROP TABLE IF EXISTS `risk_history`;
CREATE TABLE `risk_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coefficient` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '风险系数',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名',
  `create_date` datetime(0) NOT NULL,
  `R` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of risk_history
-- ----------------------------
INSERT INTO `risk_history` VALUES (79, '3.86', '试', '2022-11-14 14:56:18', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (86, '3.86', 'aa', '2022-11-16 10:26:42', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (88, '3.86', 'bb', '2022-11-16 10:39:27', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (90, '3.86', 'cc', '2022-11-16 14:10:47', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (91, '3.86', 'dd', '2022-11-16 14:10:49', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (92, '3.86', 'ee', '2022-11-16 14:10:52', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (93, '3.86', 'ff', '2022-11-16 14:10:54', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (94, '3.86', 'gg', '2022-11-16 14:10:58', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (95, '3.86', 'hh', '2022-11-16 14:11:01', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (96, '3.86', 'ii', '2022-11-16 14:11:04', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (98, '3.86', 'aa', '2022-11-18 09:35:29', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');
INSERT INTO `risk_history` VALUES (99, '3.86', '啊啊', '2022-11-18 13:53:31', '{\"r1\":[[0.0,0.3,0.5,0.2,0.0],[0.1,0.4,0.4,0.1,0.0],[0.0,0.1,0.4,0.4,0.1]],\"r2\":[[0.2,0.5,0.2,0.1,0.0],[0.2,0.3,0.3,0.2,0.0],[0.2,0.5,0.2,0.1,0.0]],\"r3\":[[0.1,0.2,0.4,0.3,0.0],[0.1,0.4,0.3,0.2,0.0],[0.1,0.6,0.2,0.1,0.0]],\"r4\":[[0.6,0.3,0.1,0.0,0.0],[0.5,0.4,0.1,0.0,0.0],[0.4,0.5,0.1,0.0,0.0]],\"r5\":[[0.3,0.4,0.3,0.0,0.0],[0.3,0.5,0.2,0.0,0.0],[0.2,0.3,0.3,0.2,0.0],[0.3,0.4,0.2,0.1,0.0]],\"r6\":[[0.0,0.5,0.4,0.1,0.0],[0.3,0.6,0.1,0.0,0.0],[0.7,0.3,0.0,0.0,0.0]]}');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '性别   0：男   1：女   2：保密',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `dept_id` int(20) NULL DEFAULT NULL COMMENT '部门ID',
  `super_admin` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '超级管理员   0：否   1：是',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：停用   1：正常',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username`) USING BTREE,
  INDEX `idx_create_date`(`create_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (107, NULL, NULL, 0, '231', '13213', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (108, NULL, 'adadad', 1, '121312414', 'a9b4ca5250465955b816e4b9c39faf4da65b2af4', NULL, NULL, 1, NULL, NULL, '2022-11-18 15:11:06', '2022-11-18 15:11:06');
INSERT INTO `user` VALUES (109, NULL, 'adadad', 1, 'add', 'a9b4ca5250465955b816e4b9c39faf4da65b2af4', NULL, NULL, 1, NULL, NULL, '2022-11-18 15:11:52', '2022-11-18 15:11:52');

SET FOREIGN_KEY_CHECKS = 1;
