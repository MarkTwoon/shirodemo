/*
 Navicat Premium Data Transfer

 Source Server         : mysqlDemo
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : shirodemo

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 17/02/2021 06:11:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission_info
-- ----------------------------
DROP TABLE IF EXISTS `permission_info`;
CREATE TABLE `permission_info`  (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID（主键、自增）',
  `permission_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '权限编号',
  `permission_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`permission_id`) USING BTREE,
  UNIQUE INDEX `permission_code`(`permission_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '权限信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission_info
-- ----------------------------
INSERT INTO `permission_info` VALUES (1, 'user:list', '用户列表');
INSERT INTO `permission_info` VALUES (2, 'user:detail', '用户详情');
INSERT INTO `permission_info` VALUES (3, 'user:add', '新增用户');
INSERT INTO `permission_info` VALUES (4, 'user:edit', '编辑用户');
INSERT INTO `permission_info` VALUES (5, 'user:delete', '删除用户');
INSERT INTO `permission_info` VALUES (6, 'user:summarize', '用户统计');
INSERT INTO `permission_info` VALUES (7, 'system:info', '系统信息');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID（主键、自增）',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色编号',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, '2001', '用户管理员');
INSERT INTO `role_info` VALUES (2, '2002', '数据分析员');
INSERT INTO `role_info` VALUES (3, '2003', '系统管理员');

-- ----------------------------
-- Table structure for role_permission_mapping
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_mapping`;
CREATE TABLE `role_permission_mapping`  (
  `mapping_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '映射ID（主键、自增）',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`mapping_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色与权限映射表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission_mapping
-- ----------------------------
INSERT INTO `role_permission_mapping` VALUES (1, 1, 1);
INSERT INTO `role_permission_mapping` VALUES (2, 1, 2);
INSERT INTO `role_permission_mapping` VALUES (3, 1, 3);
INSERT INTO `role_permission_mapping` VALUES (4, 1, 4);
INSERT INTO `role_permission_mapping` VALUES (5, 1, 5);
INSERT INTO `role_permission_mapping` VALUES (6, 2, 6);
INSERT INTO `role_permission_mapping` VALUES (7, 3, 7);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID（主键、自增）',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户姓名',
  `PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '盐',
  `state` char(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0' COMMENT '状态（0：禁用；1：锁定；2：启用）',
  `blog_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '博客地址',
  `blog_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '博客信息',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'pan_junbiao的博客', 'ab2d90c1307e8a2733d8332710b0ca16', 'ca4f8a8f17f0e2f80698ba3005b2df15', '2', 'https://blog.csdn.net/pan_junbiao', '您好，欢迎访问 pan_junbiao的博客');
INSERT INTO `user_info` VALUES (2, 'pan_junbiao的博客_02', '820dd3529d8b2a21a81a1bce328f6fe2', '33fb0d2515def8c4674d5a7b555b6ad0', '2', 'https://blog.csdn.net/pan_junbiao', '您好，欢迎访问 pan_junbiao的博客');

-- ----------------------------
-- Table structure for user_role_mapping
-- ----------------------------
DROP TABLE IF EXISTS `user_role_mapping`;
CREATE TABLE `user_role_mapping`  (
  `mapping_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '映射ID（主键、自增）',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`mapping_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户与角色映射表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_mapping
-- ----------------------------
INSERT INTO `user_role_mapping` VALUES (1, 1, 1);
INSERT INTO `user_role_mapping` VALUES (2, 1, 3);

SET FOREIGN_KEY_CHECKS = 1;
