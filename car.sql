/*
 Navicat Premium Dump SQL

 Source Server         : spring-boot
 Source Server Type    : MySQL
 Source Server Version : 80406 (8.4.6)
 Source Host           : localhost:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 80406 (8.4.6)
 File Encoding         : 65001

 Date: 09/01/2026 11:03:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_back
-- ----------------------------
DROP TABLE IF EXISTS `tb_back`;
CREATE TABLE `tb_back`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '入库单ID',
  `back_sn` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入库单号',
  `return_date` date NULL DEFAULT NULL COMMENT '入库时间',
  `rent_id` int NULL DEFAULT NULL COMMENT '出租单ID',
  `problem` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存在问题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '问题描述',
  `pay_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '赔付金额',
  `oper_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作员',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '入库单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_back
-- ----------------------------
INSERT INTO `tb_back` VALUES (3, 'CZ_20260109105200758_68890', NULL, 11, 'wu', '', 0.00, 'admin', '2026-01-09 10:52:07', '2026-01-09 10:52:07');

-- ----------------------------
-- Table structure for tb_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_car`;
CREATE TABLE `tb_car`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '业务ID',
  `car_number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `brand` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型',
  `rent_price` decimal(10, 2) NOT NULL COMMENT '出租价格',
  `status` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态（未出租,已出租）',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `picture` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆图片',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rent_price`(`rent_price` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_car
-- ----------------------------
INSERT INTO `tb_car` VALUES (21, 'lwr', 'NetMusic', 'p3', 2999.99, '未禁用', '1', '20260109103034503.png', '2026-01-09 10:30:44', '2026-01-09 10:30:44');
INSERT INTO `tb_car` VALUES (22, 'wrl', 'pixiv', 'p2', 99.99, '未禁用', '1', '20260109103730075.png', '2026-01-09 10:37:40', '2026-01-09 10:37:40');
INSERT INTO `tb_car` VALUES (23, 'wrl', 'billbill', 'p2', 39.99, '未禁用', '1', '20260109103818802.png', '2026-01-09 10:38:19', '2026-01-09 10:40:27');
INSERT INTO `tb_car` VALUES (24, 'song', 'NetMusic', 'p2', 399.99, '已禁用', '1', '20260109104534789.png', '2026-01-09 10:45:35', '2026-01-09 10:52:07');

-- ----------------------------
-- Table structure for tb_car_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_car_customer`;
CREATE TABLE `tb_car_customer`  (
  `plan_type` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `plan_length` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rent_price` decimal(10, 2) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_car_customer
-- ----------------------------
INSERT INTO `tb_car_customer` VALUES ('p1', 'overMonth', 29.99);
INSERT INTO `tb_car_customer` VALUES ('p1', 'overMonth', 39.99);
INSERT INTO `tb_car_customer` VALUES ('p1', 'overMonth', 299.99);
INSERT INTO `tb_car_customer` VALUES ('p2', 'overQuarter', 99.99);
INSERT INTO `tb_car_customer` VALUES ('p2', 'overQuarter', 799.99);
INSERT INTO `tb_car_customer` VALUES ('p2', 'overQuarter', 79.99);
INSERT INTO `tb_car_customer` VALUES ('p3', 'overYear', 399.99);
INSERT INTO `tb_car_customer` VALUES ('p3', 'overYear', 2999.99);
INSERT INTO `tb_car_customer` VALUES ('p3', 'overYear', 299.99);

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `identity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证',
  `customer_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES (9, '4128240000000', 'lwr', '男性', '16639670807', '菜鸟驿站（中原工学院北校区）', NULL, '2026-01-09 10:28:35', NULL, '2026-01-09 10:28:35');
INSERT INTO `tb_customer` VALUES (10, '4128220055555555', 'wrl', '男性', '19212130807', '菜鸟驿站（中原工学院北校区）', NULL, '2026-01-09 10:38:58', NULL, '2026-01-09 10:38:58');
INSERT INTO `tb_customer` VALUES (11, '410101200105081234', 'song', '女性', '15800000000', '菜鸟驿站（中原工学院北校区）', NULL, '2026-01-09 10:39:23', NULL, '2026-01-09 10:39:23');

-- ----------------------------
-- Table structure for tb_rent
-- ----------------------------
DROP TABLE IF EXISTS `tb_rent`;
CREATE TABLE `tb_rent`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '出租单ID',
  `rent_sn` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出租单号',
  `car_id` int NULL DEFAULT NULL COMMENT '车辆ID',
  `customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
  `back_date` int NULL DEFAULT NULL COMMENT '归还时间',
  `rent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '出租价格',
  `status` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态（未归还,已归还）',
  `oper_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '出租单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_rent
-- ----------------------------
INSERT INTO `tb_rent` VALUES (10, 'CZ_20260109103927480_70687', 23, 10, 1, 299.99, '未入库', 'admin', '2026-01-09 10:39:46', '2026-01-09 10:39:46');
INSERT INTO `tb_rent` VALUES (11, 'CZ_20260109104542727_68730', 24, 11, 1, 399.99, '已入库', 'admin', '2026-01-09 10:45:54', '2026-01-09 10:45:54');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '管理员', '123', 'admin@qq.com', '15888888888', '2025-01-01 00:00:00', '2025-12-31 20:16:06');

SET FOREIGN_KEY_CHECKS = 1;
