DROP TABLE FOOD_DRINK;

CREATE TABLE FOOD_RAMEN(
   NAME VARCHAR2(50),
   PRICE NUMBER,
   ETC DATE
);
INSERT INTO FOOD_RAMEN VALUES ('단무지', 100, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('공기밥', 1000, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('신라면', 2500, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('너구리', 2500, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('참깨라면', 2500, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('짜파게티', 2500, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('신라면(컵)', 2000, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('너구리(컵)', 2000, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('참깨라면(컵)', 2000, SYSDATE);
INSERT INTO FOOD_RAMEN VALUES ('짜파게티(컵)', 2000, SYSDATE);

select * from FOOD_RAMEN;

CREATE TABLE FOOD_HAM(
   NAME VARCHAR2(50),
   PRICE NUMBER,
   ETC DATE
);
INSERT INTO FOOD_HAM VALUES ('불고기버거', 3000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('어니언버거', 3000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('치즈버거', 4000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('머쉬룸버거', 4000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('불고기세트', 5000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('어니언세트', 5000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('치즈세트', 5500, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('머쉬룸세트', 5500, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('토마토머핀', 2000, SYSDATE);
INSERT INTO FOOD_HAM VALUES ('에그머핀', 2000, SYSDATE);


CREATE TABLE FOOD_DRINK(
   NAME VARCHAR2(50),
   PRICE NUMBER,
   ETC DATE
);
INSERT INTO FOOD_DRINK VALUES ('사과드링크', 1000, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('쿠우쿠우', 800, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('포카리스웨트', 1200, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('비타500', 900, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('파워에이드', 1500, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('수박소다', 1000, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('데미소다', 800, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('솔의눈', 800, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('사이다', 1000, SYSDATE);
INSERT INTO FOOD_DRINK VALUES ('갈아만든배', 900, SYSDATE);

DROP TABLE INVEN_DRINK;

CREATE TABLE INVEN_RAMEN(
   NAME VARCHAR2(50),
   AMOUNT NUMBER,
   ETC DATE
);
INSERT INTO INVEN_RAMEN VALUES ('단무지', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('공기밥', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('신라면', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('너구리', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('참깨라면', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('짜파게티', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('신라면(컵)', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('너구리(컵)', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('참깨라면(컵)', 100, SYSDATE);
INSERT INTO INVEN_RAMEN VALUES ('짜파게티(컵)', 100, SYSDATE);


CREATE TABLE INVEN_HAM(
   NAME VARCHAR2(50),
   AMOUNT NUMBER,
   ETC DATE
);
INSERT INTO INVEN_HAM VALUES ('불고기버거', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('어니언버거', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('치즈버거', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('머쉬룸버거', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('불고기세트', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('어니언세트', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('치즈세트', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('머쉬룸세트', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('토마토머핀', 100, SYSDATE);
INSERT INTO INVEN_HAM VALUES ('에그머핀', 100, SYSDATE);


CREATE TABLE INVEN_DRINK(
   NAME VARCHAR2(50),
   AMOUNT NUMBER,
   ETC DATE
);
INSERT INTO INVEN_DRINK VALUES ('사과드링크', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('쿠우쿠우', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('포카리스웨트', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('비타500', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('파워에이드', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('수박소다', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('데미소다', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('솔의눈', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('사이다', 100, SYSDATE);
INSERT INTO INVEN_DRINK VALUES ('갈아만든배', 100, SYSDATE);

DELETE FROM INVEN_DRINK;
select * from INVEN_DRINK;
DROP TABLE SELLIST;

CREATE TABLE SELLIST(
   kINDS VARCHAR2(20),
   NAME VARCHAR2(50),
   PRICE NUMBER,
   AMOUNT NUMBER,
   TOTAL NUMBER
);

select * from SELLIST;

DELETE FROM SELLIST;

DROP TABLE ROWLIST;

CREATE TABLE ROWLIST(
   NUM12 NUMBER,
   kINDS VARCHAR2(20),
   NAME VARCHAR2(50),
   PRICE NUMBER,
   AMOUNT NUMBER,
   TOTAL NUMBER
);

select * from ROWLIST;

DELETE FROM ROWLIST;

INSERT INTO SELLIST SELECT * FROM ROWLIST;

SELECT NAME, AMOUNT FROM ROWLIST;
SELECT NAME, AMOUNT FROM INVEN_RAMEN;
SELECT NAME, AMOUNT FROM INVEN_HAM;
SELECT NAME, AMOUNT FROM INVEN_DRINK;
