-- 번호, 이름, 국어, 영어, 수학, 총점, 평균, 등급
-- 번호는 시퀀스를 이용해서 +1씩 증가
DROP SEQUENCE SCORESQ;
DROP TABLE TB_SCORE;

CREATE SEQUENCE SCORESQ;

CREATE TABLE TB_SCORE(
	S_NO NUMBER PRIMARY KEY,
	S_NAME VARCHAR2(20) NOT NULL,
	S_KOR NUMBER NOT NULL,
	S_ENG NUMBER NOT NULL,
	S_MATH NUMBER NOT NULL,
	S_SUM NUMBER,
	S_AVG NUMBER,
	S_GRADE VARCHAR2(2) 
		CHECK(S_GRADE IN('A','B','C','D','F'))
);

SELECT * FROM TB_SCORE;

SELECT S_NAME, M_NAME FROM TB_SCORE JOIN TB_MBMBER ON S_NO = M_NO;
