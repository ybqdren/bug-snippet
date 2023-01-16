CREATE DATABASE `bug_snippet` default character set utf8 collate utf8_general_ci;


use `bug_snippet`;

DROP TABLE  IF EXISTS `order`;
DROP TABLE  IF EXISTS `user`;

CREATE table `user` (
    id VARCHAR(10) PRIMARY KEY COMMENT '用户编号',
    user_name VARCHAR(10) NOT NULL COMMENT '用户名',
    usable BOOLEAN NOT NULL DEFAULT True COMMENT '用户状态'
);

INSERT INTO user(id, user_name)
values
    ("000001" , "阿珍"),
    ("000002" , "阿强"),
    ("000003" , "小明")
;

CREATE table `order` (
    id VARCHAR(10) PRIMARY KEY COMMENT '订单编号',
    user_id VARCHAR(10) NOT NULL COMMENT '用户编号',
    order_status ENUM('OPEN','COMPLETED','CLOSE') NOT NULL  COMMENT '订单状态',
    FOREIGN KEY(user_id) references user(id)
);

INSERT INTO `order`(id, user_id,order_status)
values
    ("000001" , "000001",'OPEN'),
    ("000002" , "000002" , 'COMPLETED'),
    ("000003" , "000003" , 'CLOSE'),
    ("000004" , "000001",'COMPLETED'),
    ("000005" , "000002" , 'CLOSE'),
    ("000006" , "000003" , 'CLOSE')
;


-- 000001 COMPLETED  || 1 row retrieved
select id , user_id , order_status from `order`
where user_id = (?) and order_status = (?);