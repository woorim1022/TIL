DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_c;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orders_detail;
DROP TABLE IF EXISTS favorite;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS qna;
DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS coupon_detail;

#테이블 생성
CREATE TABLE IF NOT EXISTS users(
   u_id NVARCHAR(10) PRIMARY KEY,
   u_pwd NVARCHAR(10),
   u_name NVARCHAR(20),
   u_age INT(10),
   u_addr NVARCHAR(20),
   u_mail NVARCHAR(20)
);

CREATE TABLE IF NOT EXISTS product(
   p_id INT(10) AUTO_INCREMENT PRIMARY KEY,
   pc_id INT(10),
   p_name NVARCHAR(10),
   p_price INT(10),
   p_regdate DATE,
   p_qt INT(10),
   p_detail NVARCHAR(500),
   p_image_path NVARCHAR(100),
   p_option NVARCHAR(20)
);

CREATE TABLE IF NOT EXISTS product_c(
   pc_id INT(10) AUTO_INCREMENT PRIMARY KEY,
   pc_name NVARCHAR(10),
   ppc_id INT(10)
);


CREATE TABLE IF NOT EXISTS cart(
   c_id INT(10) AUTO_INCREMENT PRIMARY KEY,
   u_id NVARCHAR(10),
   p_id INT(10),
   c_qt INT(10),
   c_regdate DATE
);

CREATE TABLE IF NOT EXISTS orders(
   o_id INT(10) AUTO_INCREMENT PRIMARY KEY,
   u_id NVARCHAR(10),
   o_name NVARCHAR(10),
   o_addr NVARCHAR(20),
   o_message NVARCHAR(100),
   o_cancel INT(1),
   o_regdate DATE,
   o_discount INT(10),
   o_allprice INT(10)
);

CREATE TABLE orders_detail(
   od_id INT(10) AUTO_INCREMENT UNIQUE, 
   p_id INT(10) NOT NULL,
   o_id INT(10) NOT NULL,
   od_qt INT(10) NOT NULL
);


CREATE TABLE IF NOT EXISTS favorite(
   f_id INT(10) AUTO_INCREMENT UNIQUE,
   u_id NVARCHAR(10),
   p_id INT(10)
);

CREATE TABLE IF NOT EXISTS review(
   r_id INT(10) AUTO_INCREMENT UNIQUE,
   u_id NVARCHAR(10),
   p_id INT(10),
   r_num INT(10),
   r_review NVARCHAR(100)
);

CREATE TABLE IF NOT EXISTS qna(
   q_id INT(10) AUTO_INCREMENT PRIMARY KEY,
   u_id NVARCHAR(10),
   p_id INT(10),
   q_detail NVARCHAR(200),
   q_public INT(1)
);

CREATE TABLE IF NOT EXISTS coupon_detail(
   cpd_id INT(10) AUTO_INCREMENT UNIQUE,
   cp_id INT(10),
   p_id INT(10)
);

CREATE TABLE IF NOT EXISTS coupon(
   cp_id INT(10) AUTO_INCREMENT PRIMARY KEY,
   cp_name INT(10),
   cp_count INT(10)
);



#FK 제약조건 설정
ALTER TABLE product
ADD CONSTRAINT FK_product_c_p FOREIGN KEY(pc_id) REFERENCES product_c(pc_id);

ALTER TABLE product_c
ADD CONSTRAINT FK_product_c_p_c FOREIGN KEY(pc_id) REFERENCES product_c(ppc_id);

ALTER TABLE cart
ADD CONSTRAINT FK_user_c FOREIGN KEY(u_id) REFERENCES users(u_id),
ADD CONSTRAINT FK_product_c FOREIGN KEY(p_id) REFERENCES product(p_id);

ALTER TABLE orders
ADD CONSTRAINT FK_users_o FOREIGN KEY(u_id) REFERENCES users(u_id);

ALTER TABLE orders_detail
ADD CONSTRAINT FK_product_od FOREIGN KEY (p_id) REFERENCES product(p_id),
ADD CONSTRAINT FK_orders_od FOREIGN KEY (o_id) REFERENCES orders(o_id);

ALTER TABLE favorite
ADD CONSTRAINT FK_users_f FOREIGN KEY(u_id) REFERENCES users(u_id),
ADD CONSTRAINT FK_product_f FOREIGN KEY(p_id) REFERENCES product(p_id);

ALTER TABLE review
ADD CONSTRAINT FK_users_review FOREIGN KEY (u_id) REFERENCES users(u_id),
ADD CONSTRAINT FK_product_review FOREIGN KEY (p_id) REFERENCES product(p_id);

ALTER TABLE qna
ADD CONSTRAINT FK_users_qna FOREIGN KEY (u_id) REFERENCES users(u_id),
ADD CONSTRAINT FK_product_qna FOREIGN KEY (p_id) REFERENCES product(p_id);

ALTER TABLE coupon_detail
ADD CONSTRAINT FK_coupon_cd FOREIGN KEY (cp_id) REFERENCES coupon(cp_id),
ADD CONSTRAINT FK_product_cd FOREIGN KEY (p_id) REFERENCES product(p_id);



#PK 묶어서 지정
ALTER TABLE orders_detail ADD CONSTRAINT PK_orders_detail PRIMARY KEY(p_id,o_id);
ALTER TABLE favorite ADD CONSTRAINT PK_favorite PRIMARY KEY(u_id,p_id);
ALTER TABLE review ADD CONSTRAINT PK_review PRIMARY KEY(u_id,p_id);
ALTER TABLE coupon_detail ADD CONSTRAINT PK_coupon_detail PRIMARY KEY(cp_id,p_id);



#DB생성
INSERT INTO users VALUES('user01',123,'한말숙',25,'서울','123ha@naver.com');
INSERT INTO users VALUES('user02',123,'김말숙',26,'부산','123ba@daum.com');
INSERT INTO users VALUES('user03',123,'박말숙',27,'대구','123ha@naver.com');
INSERT INTO users VALUES('user04',123,'송말숙',28,'대전','123ha@naver.com');
INSERT INTO users VALUES('user05',123,'공말숙',29,'평택','123ha@naver.com');

INSERT INTO product VALUES(p_id,2,'니트',1000,CURRENT_DATE,10,'이상품은 어쩌고저쩌고','C:\Users\USER-PC\Documents\image1','베이지');
INSERT INTO product VALUES(p_id,2,'셔츠',2000,CURRENT_DATE,'이상품은 어쩌고저쩌고','C:\Users\USER-PC\Documents\image2','베이지');
INSERT INTO product VALUES(p_id,3,'코트',3000,CURRENT_DATE,'이상품은 어쩌고저쩌고','C:\Users\USER-PC\Documents\image3','파랑');
INSERT INTO product VALUES(p_id,5,'양말',4000,CURRENT_DATE,'이상품은 어쩌고저쩌고','C:\Users\USER-PC\Documents\image4','빨강');
INSERT INTO product VALUES(p_id,4,'청바지',5000,CURRENT_DATE,'이상품은 어쩌고저쩌고','C:\Users\USER-PC\Documents\image5','검정');

INSERT INTO product_c VALUES(pc_id,'의류',NULL);
INSERT INTO product_c VALUES(pc_id,'상의',1);
INSERT INTO product_c VALUES(pc_id,'겉옷',1);
INSERT INTO product_c VALUES(pc_id,'하의',1);
INSERT INTO product_c VALUES(pc_id,'악세사리',1);


INSERT INTO cart VALUES(c_id,'user01',1,2,CURRENT_DATE);
INSERT INTO cart VALUES(c_id,'user02',2,1,CURRENT_DATE);
INSERT INTO cart VALUES(c_id,'user03',2,3,CURRENT_DATE);
INSERT INTO cart VALUES(c_id,'user02',3,1,CURRENT_DATE);
INSERT INTO cart VALUES(c_id,'user05',1,2,CURRENT_DATE);   

INSERT INTO orders VALUES(o_id,'user01','김동자','서울','문 앞에 놔주세요',0,CURRENT_DATE,'10000','100000');
INSERT INTO orders VALUES(o_id,'user01','김동자','서울','문 앞에 놔주세요',0,CURRENT_DATE,'10000','100000');
INSERT INTO orders VALUES(o_id,'user01','김동자','서울','문 앞에 놔주세요',0,CURRENT_DATE,'10000','100000');
INSERT INTO orders VALUES(o_id,'user01','김동자','서울','문 앞에 놔주세요',0,CURRENT_DATE,'10000','100000');
INSERT INTO orders VALUES(o_id,'user01','김동자','서울','문 앞에 놔주세요',0,CURRENT_DATE,'10000','100000');

INSERT INTO orders_detail VALUES(od_id,'user01',1,2);
INSERT INTO orders_detail VALUES(od_id,'user02',1,2);
INSERT INTO orders_detail VALUES(od_id,'user03',1,2);
INSERT INTO orders_detail VALUES(od_id,'user01',3,2);
INSERT INTO orders_detail VALUES(od_id,'user02',4,2);

INSERT INTO favorite VALUES(f_id,'user05',1);
INSERT INTO favorite VALUES(f_id,'user05',2);
INSERT INTO favorite VALUES(f_id,'user04',2);
INSERT INTO favorite VALUES(f_id,'user03',1);
INSERT INTO favorite VALUES(f_id,'user02',1);

INSERT INTO review VALUES(r_id,'user02',1,10,'재질이 좋아요');
INSERT INTO review VALUES(r_id,'user01',1,8,'재질이 좋아요');
INSERT INTO review VALUES(r_id,'user03',1,10,'재질이 좋아요');
INSERT INTO review VALUES(r_id,'user04',1,9,'재질이 좋아요');
INSERT INTO review VALUES(r_id,'user01',2,10,'디자인이 좋아요');

INSERT INTO qna VALUES(q_id,'user02',1,'재질이 어떻게 이루어져 있나요?',1);
INSERT INTO qna VALUES(q_id,'user03',1,'배송은 언제쯤 오나요?',1);
INSERT INTO qna VALUES(q_id,'user02',3,'배송은 언제쯤 오나요?',1);
INSERT INTO qna VALUES(q_id,'user04',1,'배송은 언제쯤 오나요?',1);
INSERT INTO qna VALUES(q_id,'user05',1,'배송은 언제쯤 오나요?',1);

INSERT INTO coupon VALUES(cp_id,'1000원 할인권',1000);
INSERT INTO coupon VALUES(cp_id,'2000원 할인권',2000);
INSERT INTO coupon VALUES(cp_id,'3000원 할인권',3000);
INSERT INTO coupon VALUES(cp_id,'4000원 할인권',4000);
INSERT INTO coupon VALUES(cp_id,'5000원 할인권',5000);

INSERT INTO coupon_detail VALUES(cpd_id,1,1);
INSERT INTO coupon_detail VALUES(cpd_id,1,2);
INSERT INTO coupon_detail VALUES(cpd_id,3,3);
INSERT INTO coupon_detail VALUES(cpd_id,4,4);
INSERT INTO coupon_detail VALUES(cpd_id,5,5);

#목록
SELECT * from users;
select * from product;

# 장바구니확인
select c.c_id,u.u_name,p.p_name,p.p_option,p.p_price,c.c_qt,c.c_regdate FROM cart c
INNER JOIN users u ON c.userid = u.u_id
INNER JOIN product p ON c.itemid = p.p_id;

# 주문목록확인
select o.id,u.name,i.name,o.qt,i.price,o.qt*i.price,u.addr From orders o
INNER JOIN users u ON o.u_id = u.id
INNER JOIN product i ON o.p_id = i.id;

#즐겨찾기목록확인
select f.id,u.name,i.name From favorite f
INNER JOIN users u ON f.userid = u.id
INNER JOIN items i ON f.itemid = i.id;

#평점목록확인
select r.id,u.name,i.name,r.rateNum From rate r
INNER JOIN users u ON r.userid = u.id
INNER JOIN items i ON r.itemid = i.id;