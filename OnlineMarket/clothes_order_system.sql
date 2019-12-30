/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : clothes_order_system

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-31 17:34:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1e20c739-b307-40da-946e-db4a73523333', '裙子', '女孩子穿的');
INSERT INTO `category` VALUES ('34764acf-0579-484e-b160-3eb2adc681c7', '帽子', '头戴的');
INSERT INTO `category` VALUES ('893a179e-3e9b-4c62-aa40-e327152e4cbb', '短袖', '短袖子的上衣');
INSERT INTO `category` VALUES ('ac42ce46-21a2-45a8-8893-5c2ab431a7bb', '裤子', '下身的衣服');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `brand` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `price` double NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `category_id_FK` (`category_id`),
  CONSTRAINT `category_id_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('00a434ca-8136-4313-888d-422e986b8384', '短袖2', '中国造', '150', '4b03f4ed-6bf5-449f-967c-aa0d46d991fe.jpg', '中国造短袖2', '893a179e-3e9b-4c62-aa40-e327152e4cbb');
INSERT INTO `clothes` VALUES ('3a588112-5dad-4523-9c32-7a16ea0cbc19', '帽子1', '中国造', '20', '1126d842-7f6c-4bd7-a9e8-ebb2e3caa923.jpg', '中国造帽子1', '34764acf-0579-484e-b160-3eb2adc681c7');
INSERT INTO `clothes` VALUES ('457017aa-fc0d-4324-98e6-b83b7bada8a5', '短袖1', '中国牌', '100', 'ee211830-e732-4e96-80f9-b19a3e47b5b5.jpeg', '中国牌短袖1', '893a179e-3e9b-4c62-aa40-e327152e4cbb');
INSERT INTO `clothes` VALUES ('98374957-08df-4a7a-bcd6-b744ca4f33cd', '裙子1', '中国造', '200', 'c5a4276e-15f2-40e6-99e8-f020735556e7.jpg', '中国造裙子1', '1e20c739-b307-40da-946e-db4a73523333');
INSERT INTO `clothes` VALUES ('c101eec7-bb02-4318-83c1-0025cb1ca682', '帽子2', '中国造', '70', '8a348c16-8129-4775-8755-611c4319b401.jpg', '中国造帽子2', '34764acf-0579-484e-b160-3eb2adc681c7');
INSERT INTO `clothes` VALUES ('db107cab-2211-4702-b233-ac96f27594ee', '裤子1', '中国造', '200', '7fbc0188-9232-4851-b937-4e75092f1d4c.jpg', '中国造裤子1', 'ac42ce46-21a2-45a8-8893-5c2ab431a7bb');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `order_id` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clothes_id` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id_FK` (`order_id`),
  KEY `book_id_FK` (`clothes_id`),
  CONSTRAINT `book_id_FK` FOREIGN KEY (`clothes_id`) REFERENCES `clothes` (`id`),
  CONSTRAINT `order_id_FK` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('080d95d7-0ea3-4ee7-8f2f-77c709454c1b', '1', '20', '282be6c2-c0bb-4e4f-99de-38bc612df0ef', '3a588112-5dad-4523-9c32-7a16ea0cbc19');
INSERT INTO `orderitem` VALUES ('5e3cc3a1-0a94-4c8b-a6bd-2c0981684ac2', '1', '100', 'dd3185c2-6428-49ed-b4e5-3ff3cd5f29fa', '457017aa-fc0d-4324-98e6-b83b7bada8a5');
INSERT INTO `orderitem` VALUES ('6751731f-dcf7-420a-aac7-891e4b447cd1', '2', '300', '282be6c2-c0bb-4e4f-99de-38bc612df0ef', '00a434ca-8136-4313-888d-422e986b8384');
INSERT INTO `orderitem` VALUES ('8c07c0b7-d7ba-457e-8fd9-594f2a4f671b', '1', '20', 'dd3185c2-6428-49ed-b4e5-3ff3cd5f29fa', '3a588112-5dad-4523-9c32-7a16ea0cbc19');
INSERT INTO `orderitem` VALUES ('9603beb0-6bd6-46ae-b82b-bd86dda9f10e', '1', '200', '1e7d9a9e-306d-4086-948e-3e2cb0258ff0', '98374957-08df-4a7a-bcd6-b744ca4f33cd');
INSERT INTO `orderitem` VALUES ('ade84b48-efd8-4fad-ab70-f836117aedd5', '1', '150', 'dd3185c2-6428-49ed-b4e5-3ff3cd5f29fa', '00a434ca-8136-4313-888d-422e986b8384');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `ordertime` datetime NOT NULL,
  `price` double NOT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `user_id` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_FK` (`user_id`),
  CONSTRAINT `user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1e7d9a9e-306d-4086-948e-3e2cb0258ff0', '2017-07-05 19:47:55', '200', '1', '09352b7b-2c92-46c3-ad98-0538c3fe8f7c');
INSERT INTO `orders` VALUES ('282be6c2-c0bb-4e4f-99de-38bc612df0ef', '2017-07-05 20:23:57', '320', '0', '09352b7b-2c92-46c3-ad98-0538c3fe8f7c');
INSERT INTO `orders` VALUES ('dd3185c2-6428-49ed-b4e5-3ff3cd5f29fa', '2017-07-05 17:25:30', '270', '1', '09352b7b-2c92-46c3-ad98-0538c3fe8f7c');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `cellphone` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('09352b7b-2c92-46c3-ad98-0538c3fe8f7c', '李四', '666666', '123456', '13177778888', '123456@mail.com', '中国北京市');
