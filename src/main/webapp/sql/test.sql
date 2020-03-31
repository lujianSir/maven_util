/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50714
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-05-23 10:52:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ebook`
-- ----------------------------
DROP TABLE IF EXISTS `ebook`;
CREATE TABLE `ebook` (
  `eb_id` varchar(50) NOT NULL,
  `ebc_id` int(11) DEFAULT NULL,
  `eb_title` varchar(255) DEFAULT NULL,
  `eb_content` text,
  `eb_img` varchar(255) DEFAULT NULL,
  `eb_author` varchar(255) DEFAULT NULL,
  `eb_indt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `eb_outdt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `eb_status` int(11) DEFAULT NULL COMMENT '0－启用，1－禁用',
  `eb_type` int(11) DEFAULT NULL COMMENT '0－书、1－音频',
  `eb_fileSize` int(11) DEFAULT NULL COMMENT '文件大小',
  `eb_filetype` varchar(5) DEFAULT NULL COMMENT '文件类型，txt,pdf...',
  `eb_ifEncrypt` int(11) DEFAULT '0' COMMENT '是否加密,0－不加密，1－加密',
  `ebClosure` varchar(50) DEFAULT NULL COMMENT '上传文件的位置',
  `eb_sort` int(11) DEFAULT NULL COMMENT '电子书排序号',
  `eb_mp3` varchar(255) DEFAULT NULL COMMENT '对应音频文件',
  `eb_autowrap` int(11) DEFAULT NULL COMMENT '是否自动换行',
  PRIMARY KEY (`eb_id`),
  UNIQUE KEY `eb_title` (`eb_title`),
  KEY `FK_Relationship_1` (`ebc_id`),
  CONSTRAINT `ebook_ibfk_1` FOREIGN KEY (`ebc_id`) REFERENCES `ebookclass` (`ebc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ebook
-- ----------------------------
INSERT INTO `ebook` VALUES ('eb0227d18691c44e099d09c573e970dbec', '234', '黄鹤楼送孟浩然之广陵', '', '', '【唐】李白', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/黄鹤楼送孟浩然之广陵.txt', '11', null, '0');
INSERT INTO `ebook` VALUES ('eb08ca7b6a532f417ab5b72145adf5f365', '233', '一去二三里', '', '', '【宋】邵雍', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/一去二三里.txt', '1', null, '0');
INSERT INTO `ebook` VALUES ('eb09e42069ed5c4c7aad681278acafc7fd', '234', '客中作', '', '', '【唐】李白', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/客中作.txt', '37', null, '0');
INSERT INTO `ebook` VALUES ('eb0aef7703e25d4e598facb3ee4f149496', '234', '寻隐者不遇', '', '', '【唐】贾岛', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/寻隐者不遇.txt', '7', null, '0');
INSERT INTO `ebook` VALUES ('eb0b4a587db4a64b5cb671f857f74b141e', '234', '江村即事', '', '', '【唐】司空曙', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/江村即事.txt', '51', null, '0');
INSERT INTO `ebook` VALUES ('eb0e8eb3e2901b43aea5466a8091189df7', '234', '赠花卿', '', '', '【唐】杜甫', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/赠花卿.txt', '13', null, '0');
INSERT INTO `ebook` VALUES ('eb0ef42d6ddfae41a88be6fa81254dbc72', '234', '杂诗三首-其二', '', '', '【唐】王维', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/杂诗三首-其二.txt', '12', null, '0');
INSERT INTO `ebook` VALUES ('eb1d79d57ca6174438afc4f6963147e322', '234', '江畔独步寻花（2）', '', '', '【唐】杜甫', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/江畔独步寻花（2）.txt', '41', null, '0');
INSERT INTO `ebook` VALUES ('eb2212cad9d613458da05e4e4c0cd5ad82', '234', '十五夜望月', '', '', '【唐】王建', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/十五夜望月.txt', '33', null, '0');
INSERT INTO `ebook` VALUES ('eb2f670e4599c841dcb51e958772080764', '234', '闻官军收河南河北', '', '', '【唐】杜甫', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '206', 'txt', '0', 'E:/upload/HDWX/book/txt/闻官军收河南河北.txt', '55', null, '0');
INSERT INTO `ebook` VALUES ('eb32016461637b43f59679feb2e244e553', '235', '长歌行（节选）', '', '', '汉乐府民歌', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/长歌行（节选）.txt', '6', null, '0');
INSERT INTO `ebook` VALUES ('eb35d7d41c8a5e423da057da58d3e6449d', '234', '江南春', '', '', '【唐】杜牧', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/江南春.txt', '40', null, '0');
INSERT INTO `ebook` VALUES ('eb367e7a4095df4ba3bde30fd44509b7cd', '236', '所见', '', '', '【清】袁枚', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/所见.txt', '18', null, '0');
INSERT INTO `ebook` VALUES ('eb462ed6339f8d45e0b7b36c7bcd69268e', '234', '春晓', '', '', '【唐】孟浩然', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/春晓.txt', '4', null, '0');
INSERT INTO `ebook` VALUES ('eb47e97289546d402895cbf57a5ad6a408', '234', '登幽州台歌', '', '', '【唐】陈子昂', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '84', 'txt', '0', 'E:/upload/HDWX/book/txt/登幽州台歌.txt', '38', null, '0');
INSERT INTO `ebook` VALUES ('eb48a8d829b080474cb10db32704163c5d', '234', '鹿柴', '', '', '【唐】王维', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/鹿柴.txt', '19', null, '0');
INSERT INTO `ebook` VALUES ('eb4be971d96ea24db68a833572bcbe1d02', '234', '采莲曲', '', '', '【唐】王昌龄', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/采莲曲.txt', '16', null, '0');
INSERT INTO `ebook` VALUES ('eb4eb7fc4640ec4ff39a137d3447984792', '233', '书湖阴先生壁', '', '', '【宋】王安石', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/书湖阴先生壁.txt', '45', null, '0');
INSERT INTO `ebook` VALUES ('eb5ed496b5efe443c7ab749a63ed8726bc', '233', '西江月', '', '', '【宋】辛弃疾', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '188', 'txt', '0', 'E:/upload/HDWX/book/txt/西江月.txt', '56', null, '0');
INSERT INTO `ebook` VALUES ('eb60798e094afc43f7af797ec9313e7545', '234', '寒食', '', '', '【唐】韩翃', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/寒食.txt', '43', null, '0');
INSERT INTO `ebook` VALUES ('eb661df7d2f93e4c6c9e2ea9e6de4720cd', '234', '凉州词', '', '', '【唐】王翰', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/凉州词.txt', '50', null, '0');
INSERT INTO `ebook` VALUES ('eb6a22916c06a04d0bbcfacd7e53ef294c', '233', '花影', '', '', '【宋】苏轼', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/花影.txt', '15', null, '0');
INSERT INTO `ebook` VALUES ('eb70476c9a02b34495970e03678e372667', '233', '舟过安仁', '', '', '【宋】杨万里', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/舟过安仁.txt', '47', null, '0');
INSERT INTO `ebook` VALUES ('eb7203f35b7f4a4b7b8a1653458a3ccf3c', '234', '清明', '', '', '【唐】杜牧', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/清明.txt', '31', null, '0');
INSERT INTO `ebook` VALUES ('eb73d65ff60f3f4f5ea193c2d002aa76ec', '233', '梅花', '', '', '【宋】王安石', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/梅花.txt', '3', null, '0');
INSERT INTO `ebook` VALUES ('eb789046659f824d0a8278e17f881abdf4', '233', '秋夜将晓出篱门', '', '', '【宋】陆游', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '103', 'txt', '0', 'E:/upload/HDWX/book/txt/秋夜将晓出篱门.txt', '49', null, '0');
INSERT INTO `ebook` VALUES ('eb82071ce5a0c64812997d0f7e6a3fc5b1', '234', '逢雪宿芙蓉山主人', '', '', '【唐】刘长卿', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/逢雪宿芙蓉山主人.txt', '9', null, '0');
INSERT INTO `ebook` VALUES ('eb846acac4218143f2bee62a463031821c', '234', '观猎', '', '', '【唐】王维', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '158', 'txt', '0', 'E:/upload/HDWX/book/txt/观猎.txt', '54', null, '0');
INSERT INTO `ebook` VALUES ('eb8a0f7b551bd74958866d5474812ff4c5', '234', '渔歌子', '', '', '【唐】张志和', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/渔歌子.txt', '42', null, '0');
INSERT INTO `ebook` VALUES ('eb8d56fd7b5eec49d19312a4fe3b4d3106', '233', '约客', '', '', '【宋】赵师秀', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/约客.txt', '44', null, '0');
INSERT INTO `ebook` VALUES ('eb904db0165d584d509b8e4c32e83e131b', '234', '江畔独步寻花', '', '', '【唐】杜甫', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '189', 'txt', '0', 'E:/upload/HDWX/book/txt/江畔独步寻花.txt', '22', null, '0');
INSERT INTO `ebook` VALUES ('eb94120298557845f18c34bf8518ceed95', '234', '宿建德江', '', '', '【唐】孟浩然', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/宿建德江.txt', '25', null, '0');
INSERT INTO `ebook` VALUES ('eb990df44796cb44f7b00bd948d80aedc4', '234', '牧童', '', '', '【唐】吕岩', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/牧童.txt', '26', null, '0');
INSERT INTO `ebook` VALUES ('eb9c22c1d0916d4f0ba1cdb9c38fb81dc7', '234', '乐游原', '', '', '【唐】李商隐', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/乐游原.txt', '21', null, '0');
INSERT INTO `ebook` VALUES ('eba14cdd01bd204b7c90e03ea04a328475', '234', '滁州西涧', '', '', '【唐】韦应物', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/滁州西涧.txt', '46', null, '0');
INSERT INTO `ebook` VALUES ('eba403e059490b42dabe442002093eae79', '234', '赋得古草原送别', '', '', '【唐】白居易', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '154', 'txt', '0', 'E:/upload/HDWX/book/txt/赋得古草原送别.txt', '17', null, '0');
INSERT INTO `ebook` VALUES ('eba4c38c904e0b4bd0bb8888d8e4056db5', '234', '别董大', '', '', '【唐】高适', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/别董大.txt', '29', null, '0');
INSERT INTO `ebook` VALUES ('eba652397fd4bf4ca6af2e11015ce9b28d', '234', '大林寺桃花', '', '', '【唐】白居易', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/大林寺桃花.txt', '23', null, '0');
INSERT INTO `ebook` VALUES ('ebac88ddd255c24403818203654a5d20ff', '234', '子夜吴歌', '', '', '【唐】李白', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '115', 'txt', '0', 'E:/upload/HDWX/book/txt/子夜吴歌.txt', '28', null, '0');
INSERT INTO `ebook` VALUES ('ebb22d4425baa84899b4afa6944249aee5', '233', '冬夜读书示子聿', '', '', '【宋】陆游', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/冬夜读书示子聿.txt', '57', null, '0');
INSERT INTO `ebook` VALUES ('ebb2f72dceb4514a6c93acb673148fad1c', '233', '乡村四月', '', '', '【宋】翁卷', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/乡村四月.txt', '53', null, '0');
INSERT INTO `ebook` VALUES ('ebb97b0bb5b28e44618e1c548be863cac2', '233', '初秋行圃', '', '', '【宋】杨万里', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/初秋行圃.txt', '27', null, '0');
INSERT INTO `ebook` VALUES ('ebc3043387b19b4cc38bee0efb2d5bc483', '234', '峨眉山月歌', '', '', '【唐】李白', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/峨眉山月歌.txt', '24', null, '0');
INSERT INTO `ebook` VALUES ('ebc75bef23c22d4ce5804777aba75aa974', '234', '寄扬州韩绰判官', '', '', '【唐】杜牧', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/寄扬州韩绰判官.txt', '36', null, '0');
INSERT INTO `ebook` VALUES ('ebc8fbe81c2a18425db5883f4b0e6528b3', '237', '石灰吟', '', '', '【明】于谦', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/石灰吟.txt', '34', null, '0');
INSERT INTO `ebook` VALUES ('ebce6f8f97536c4db6a187161c0d0aa1dc', '234', '秋思', '', '', '【唐】张籍', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/秋思.txt', '35', null, '0');
INSERT INTO `ebook` VALUES ('ebd0ae786e67424010bf0022fca45aef37', '236', '舟夜书所见', '', '', '【清】查慎行', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '76', 'txt', '0', 'E:/upload/HDWX/book/txt/舟夜书所见.txt', '20', null, '0');
INSERT INTO `ebook` VALUES ('ebd5df31f85d2d4f28aac20e1bb57bc726', '236', '题画兰', '', '', '【清】郑燮', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/题画兰.txt', '52', null, '0');
INSERT INTO `ebook` VALUES ('ebdbd7cbd1c8ac40798444f7bfe7b3735c', '234', '终南望余雪', '', '', '【唐】祖咏', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '78', 'txt', '0', 'E:/upload/HDWX/book/txt/终南望余雪.txt', '39', null, '0');
INSERT INTO `ebook` VALUES ('ebdca5b381bcb04854966971391f60fd5a', '234', '碛中作', '', '', '【唐】岑参', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '102', 'txt', '0', 'E:/upload/HDWX/book/txt/碛中作.txt', '48', null, '0');
INSERT INTO `ebook` VALUES ('ebdd2cb2a32ac94d0aacb6aa5a4d0ca58a', '234', '小儿垂钓', '', '', '【唐】胡令能', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/小儿垂钓.txt', '14', null, '0');
INSERT INTO `ebook` VALUES ('ebe32174cba8ea40ce9e605e9e85e65c0d', '234', '送元二使安西', '', '', '【唐】王维', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/送元二使安西.txt', '32', null, '0');
INSERT INTO `ebook` VALUES ('ebea5a8f61b08a490996e727431ad7ed27', '234', '游子吟', '', '', '【唐】孟郊', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '115', 'txt', '0', 'E:/upload/HDWX/book/txt/游子吟.txt', '5', null, '0');
INSERT INTO `ebook` VALUES ('ebeb0d1ab9795c47088e17aa051b7a633d', '234', '回乡偶书', '', '', '【唐】贺知章', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/回乡偶书.txt', '10', null, '0');
INSERT INTO `ebook` VALUES ('ebf63ddba5eae046e0b312a35bfd3dba95', '234', '山行', '', '', '【唐】杜牧', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/山行.txt', '8', null, '0');
INSERT INTO `ebook` VALUES ('ebf72c4c96a37649c7b7cc89fc12523e68', '233', '泊船瓜洲', '', '', '【宋】王安石', '2019-05-21 13:50:59', '2019-05-21 13:50:59', '0', '0', '100', 'txt', '0', 'E:/upload/HDWX/book/txt/泊船瓜洲.txt', '30', null, '0');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `m_id` varchar(50) NOT NULL,
  `m_name` varchar(255) DEFAULT NULL,
  `m_pid` varchar(50) DEFAULT NULL,
  `m_url` varchar(50) DEFAULT NULL,
  `m_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `m_disable` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '权限管理', '0', null, '2019-05-22 11:14:12', '0');
INSERT INTO `menu` VALUES ('mu0107bba81ff1453fa915010004ff3708', '评论管理', 'mubd61af977fe240e0b4c122202a080591', 'audioComment/audioCommentMessage.do', '2019-03-20 17:58:44', '1');
INSERT INTO `menu` VALUES ('mu0851dc9a812c460089fa06e7f4c9739d', '微信配置', 'mufd79a632685d4f578f2f78102e1e27b9', 'system/wx/WxConfig.jsp', '2019-02-21 10:10:23', '0');
INSERT INTO `menu` VALUES ('mu0b4aa0af845745eab44af06fe05ebf85', '系统菜单', 'mu93f227ce747147f5a5363c9ad2428890', 'menu/menuMessage.do', '2019-02-20 10:22:02', '0');
INSERT INTO `menu` VALUES ('mu0deb8f01ac2046c9a0a8a8b3649499f2', '系统日志', 'mu6165efdbddbb4318904fcfee6f11764f', 'system/log/getLog.do', '2019-02-20 10:22:31', '0');
INSERT INTO `menu` VALUES ('mu12c0b649e8a24ccbbcf9695dea623d2c', '用户作品管理', 'mubd61af977fe240e0b4c122202a080591', 'entries/entriesMessage.do', '2019-02-20 10:17:41', '0');
INSERT INTO `menu` VALUES ('mu1458cdde14004267bd79ccb67a08914f', '机构管理', 'mu93f227ce747147f5a5363c9ad2428890', 'organization/organizationMessage.do', '2019-02-20 10:21:53', '0');
INSERT INTO `menu` VALUES ('mu1dd79c68eba74b55a12e3beb72e6631d', '应用服务管理', 'mu93f227ce747147f5a5363c9ad2428890', '/manager/index.jsp', '2019-02-22 11:15:10', '0');
INSERT INTO `menu` VALUES ('mu225bb67dc06049c482fd3de03abd59b6', '班级管理', 'mu93f227ce747147f5a5363c9ad2428890', 'schoolClass/schoolClassMessage.do', '2019-02-20 10:21:42', '0');
INSERT INTO `menu` VALUES ('mu3579eda65e24437c8d895460f414109e', '操作记录', 'mu6165efdbddbb4318904fcfee6f11764f', 'system/log/logOperation.do', '2019-03-01 14:45:51', '0');
INSERT INTO `menu` VALUES ('mu35bbf927170f490992ccb02d70b5b3ca', '资源分类', 'mucc35969c6c614661b8b0f0984c4d7a18', 'sinology/sinologyMessage.do', '2019-02-20 10:19:04', '0');
INSERT INTO `menu` VALUES ('mu436a832b8a744a56904dfccda05c2acc', '用户信息', 'mu74438e0a5ba34ea19349f50c065480e8', 'userInfo/userMessage.do', '2019-02-20 10:21:09', '0');
INSERT INTO `menu` VALUES ('mu514a8d0ad0ff409eaa635e461604ee29', '试用作品管理', 'mubd61af977fe240e0b4c122202a080591', 'trial/trialAudioAttachMessage.do', '2019-04-22 15:54:40', '0');
INSERT INTO `menu` VALUES ('mu5e10ed329e3541fd991f200fb539d65b', '资源包导入', 'mucc35969c6c614661b8b0f0984c4d7a18', 'ebook/ebookImport.do', '2019-02-20 10:19:35', '0');
INSERT INTO `menu` VALUES ('mu5f6095953e2249768160478b96f76f30', '配置管理', 'mu93f227ce747147f5a5363c9ad2428890', 'system/config/Config.jsp', '2019-02-20 10:21:31', '0');
INSERT INTO `menu` VALUES ('mu6165efdbddbb4318904fcfee6f11764f', '数据监控', '1', '', '2019-02-20 10:22:19', '0');
INSERT INTO `menu` VALUES ('mu626fd45036de4fd5933ca50678c6e133', '数据统计', 'mu6165efdbddbb4318904fcfee6f11764f', '/HDWX/system/stat/backstageData.jsp', '2019-02-20 10:22:40', '0');
INSERT INTO `menu` VALUES ('mu650a7e98c8b04d298545948bfb81afda', '内容管理', '1', '', '2019-02-20 10:18:13', '1');
INSERT INTO `menu` VALUES ('mu74438e0a5ba34ea19349f50c065480e8', '用户管理', '1', '', '2019-02-20 10:20:59', '0');
INSERT INTO `menu` VALUES ('mu75344f365cda4b53a8a32cd0b1349111', '书籍管理', 'mucc35969c6c614661b8b0f0984c4d7a18', 'ebook/ebookMessage.do', '2019-02-20 10:19:25', '0');
INSERT INTO `menu` VALUES ('mu7a23f10e88e143d88a6c99a2acfb09e1', '信息分类', 'mu650a7e98c8b04d298545948bfb81afda', '', '2019-02-20 10:18:29', '1');
INSERT INTO `menu` VALUES ('mu93f227ce747147f5a5363c9ad2428890', '系统管理', '1', '', '2019-02-20 10:21:19', '0');
INSERT INTO `menu` VALUES ('mu942922da22ba490e9bce618460850075', '活动内容管理', 'mubd61af977fe240e0b4c122202a080591', 'eventPlan/eventPlanMessage.do', '2019-02-20 10:17:30', '0');
INSERT INTO `menu` VALUES ('mu962bd2b00a39432fb190faa2cadec689', '微信菜单管理', 'mufd79a632685d4f578f2f78102e1e27b9', 'system/wx/WxMenu.jsp', '2019-02-20 10:17:08', '0');
INSERT INTO `menu` VALUES ('mubd61af977fe240e0b4c122202a080591', '活动管理', '1', '', '2019-02-20 10:17:20', '0');
INSERT INTO `menu` VALUES ('mucadc1128007d42e992f5fc77e21f0d66', '资讯管理', 'mu650a7e98c8b04d298545948bfb81afda', '', '2019-02-20 10:18:38', '1');
INSERT INTO `menu` VALUES ('mucc35969c6c614661b8b0f0984c4d7a18', '图书资源管理', '1', '', '2019-02-20 10:18:50', '0');
INSERT INTO `menu` VALUES ('mud06947dd959a4a318b1db5a98f2d084a', '首页', '1', 'system/Index.jsp', '2019-02-19 14:12:06', '0');
INSERT INTO `menu` VALUES ('mudfb148b3b76448a094d060793d30d177', '敏感词管理', 'mu93f227ce747147f5a5363c9ad2428890', 'sensitive/sensitiveMessage.do', '2019-03-21 11:13:12', '0');
INSERT INTO `menu` VALUES ('mue1f2af0c6f65415ab6923df87f321f8e', '意见反馈', 'mu6165efdbddbb4318904fcfee6f11764f', 'system/log/feedBack.do', '2019-03-12 09:58:34', '0');
INSERT INTO `menu` VALUES ('muee32e7799f25474c9e82ba8b86891f12', '资源包导出', 'mucc35969c6c614661b8b0f0984c4d7a18', 'ebook/ebookExport.do', '2019-03-19 09:47:24', '1');
INSERT INTO `menu` VALUES ('mufa4a3f8cb0d04cc1be00a3fe4e43d2ae', '班级字典', 'mu93f227ce747147f5a5363c9ad2428890', 'classInfo/classMessage.do', '2019-02-20 10:22:11', '0');
INSERT INTO `menu` VALUES ('mufd79a632685d4f578f2f78102e1e27b9', '微信管理', '1', '', '2019-02-19 14:12:15', '0');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `ui_id` varchar(50) NOT NULL,
  `m_id` varchar(50) NOT NULL,
  PRIMARY KEY (`ui_id`,`m_id`),
  KEY `FK_Relationship_17` (`m_id`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`ui_id`) REFERENCES `userinfo` (`ui_id`),
  CONSTRAINT `permission_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `menu` (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', '1');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu0b4aa0af845745eab44af06fe05ebf85');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu0deb8f01ac2046c9a0a8a8b3649499f2');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu1458cdde14004267bd79ccb67a08914f');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu1dd79c68eba74b55a12e3beb72e6631d');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu225bb67dc06049c482fd3de03abd59b6');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu3579eda65e24437c8d895460f414109e');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu35bbf927170f490992ccb02d70b5b3ca');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu436a832b8a744a56904dfccda05c2acc');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu5f6095953e2249768160478b96f76f30');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu6165efdbddbb4318904fcfee6f11764f');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu626fd45036de4fd5933ca50678c6e133');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu650a7e98c8b04d298545948bfb81afda');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu74438e0a5ba34ea19349f50c065480e8');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu75344f365cda4b53a8a32cd0b1349111');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu7a23f10e88e143d88a6c99a2acfb09e1');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu93f227ce747147f5a5363c9ad2428890');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu942922da22ba490e9bce618460850075');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mu962bd2b00a39432fb190faa2cadec689');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mubd61af977fe240e0b4c122202a080591');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mucadc1128007d42e992f5fc77e21f0d66');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mucc35969c6c614661b8b0f0984c4d7a18');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mud06947dd959a4a318b1db5a98f2d084a');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mudfb148b3b76448a094d060793d30d177');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mue1f2af0c6f65415ab6923df87f321f8e');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'muee32e7799f25474c9e82ba8b86891f12');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mufa4a3f8cb0d04cc1be00a3fe4e43d2ae');
INSERT INTO `permission` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', 'mufd79a632685d4f578f2f78102e1e27b9');

-- ----------------------------
-- Table structure for `picture`
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pId` varchar(50) COLLATE utf8_bin NOT NULL,
  `pUrlOne` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pUrlTwo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pUrlThree` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pathpUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pPath` text CHARACTER SET utf8,
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('903e6c3199f0474aa6a0c72755250a35', '../imgPath/headImg/155807970911410072c1a-4964-4e1c-be76-e12425256cff.jpg', '../imgPath/headImg/1558079709119783eaf31-8286-4b6e-a5dd-3c0a85513fa2.jpg', '../imgPath/headImg/15580797091258c68a3d4-0231-4f79-a322-9c7b1415525b.jpg', '../imgPath/headImg/1558079709108e2d9016c-e980-4ffb-a288-928e7638c9f2.jpg', '<iframe src=\"http://localhost:8090/maven-utils/kindeditor/plugins/baidumap/index.html?center=114.208153%2C30.516528&zoom=17&width=558&height=360&markers=114.208153%2C30.516528&markerStyles=l%2CA\" frameborder=\"0\" style=\"width:560px;height:362px;\">\n</iframe>');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `ui_id` varchar(50) NOT NULL,
  `o_id` varchar(50) DEFAULT NULL,
  `ui_login` varchar(20) DEFAULT NULL,
  `ui_pwd` varchar(32) DEFAULT NULL,
  `ui_username` varchar(20) DEFAULT NULL,
  `ui_sex` int(11) DEFAULT NULL,
  `ui_birthday` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ui_status` int(11) DEFAULT NULL,
  `ui_type` int(11) DEFAULT NULL COMMENT '-1－超级管理员，0－学生，1－教师，2－其他',
  `ui_visits` int(11) DEFAULT '0' COMMENT '用户访问次数',
  `ui_lastdt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最近访问时间',
  PRIMARY KEY (`ui_id`),
  KEY `FK_Relationship_5` (`o_id`),
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`o_id`) REFERENCES `organization` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('ui8c26c5b897eb439993ec3de20438af3d', null, 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '超级管理员', null, '2019-02-12 12:09:08', '1', '-1', '0', null);

-- ----------------------------
-- Table structure for `userinfo_copy`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo_copy`;
CREATE TABLE `userinfo_copy` (
  `ui_id` varchar(50) NOT NULL,
  `o_id` varchar(50) DEFAULT NULL,
  `ui_login` varchar(20) DEFAULT NULL,
  `ui_pwd` varchar(32) DEFAULT NULL,
  `ui_username` varchar(20) DEFAULT NULL,
  `ui_sex` int(11) DEFAULT NULL,
  `ui_birthday` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ui_status` int(11) DEFAULT NULL,
  `ui_type` int(11) DEFAULT NULL COMMENT '-1－超级管理员，0－学生，1－教师，2－其他',
  `ui_visits` int(11) DEFAULT '0' COMMENT '用户访问次数',
  `ui_lastdt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最近访问时间',
  PRIMARY KEY (`ui_id`),
  KEY `FK_Relationship_5` (`o_id`),
  CONSTRAINT `userinfo_copy_ibfk_1` FOREIGN KEY (`o_id`) REFERENCES `organization` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo_copy
-- ----------------------------
