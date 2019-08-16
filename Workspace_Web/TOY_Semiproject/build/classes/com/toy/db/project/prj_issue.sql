DROP
	TABLE
		PRJ_ISSUE;

DROP
	SEQUENCE ISSUESEQ;

CREATE
	SEQUENCE ISSUESEQ;

CREATE
	TABLE
		PRJ_ISSUE(ISSUE_NUM NUMBER PRIMARY KEY,
		PRJ_NUM NUMBER REFERENCES PRJ_INFO(PRJ_NUM) ON DELETE CASCADE,
		BOARD_NUM NUMBER REFERENCES PRJ_BOARD(BOARD_NUM) ON DELETE CASCADE,
		ISSUE_TITLE VARCHAR2(500) NOT NULL,
		ISSUE_CONTENT VARCHAR2(4000),
		ISSUE_CHARGE VARCHAR2(100),
		ISSUE_PRIORITY VARCHAR2(50) NOT NULL,
		ISSUE_DEADLINE DATE,
		ISSUE_PARENT NUMBER,
		ISSUE_DATE_CREATE DATE NOT NULL,
		ISSUE_DATE_UPDATE DATE,
		ISSUE_DEL VARCHAR2(2) NOT NULL,
		CONSTRAINT DEL_CHK CHECK (ISSUE_DEL IN('Y',
		'N')),
		CONSTRAINT PRIORITY CHECK (ISSUE_PRIORITY IN('VERYHIGH',
		'HIGH',
		'MEDIUM',
		'LOW',
		'VERYLOW')) );

SELECT * FROM PRJ_ISSUE;
UPDATE PRJ_ISSUE SET ISSUE_DATE_UPDATE = TO_DATE('2019-06-13 17:10:32', 'yyyy-mm-dd hh24:mi:ss') WHERE ISSUE_NUM = 3;
SELECT * FROM PRJ_ISSUE WHERE PRJ_NUM = 1 AND
	TO_CHAR(ISSUE_DATE_UPDATE,'yyyyMM') = '201906';

SELECT BOARD_TITLE FROM PRJ_BOARD WHERE PRJ_NUM = 1; 

DELETE FROM PRJ_ISSUE;