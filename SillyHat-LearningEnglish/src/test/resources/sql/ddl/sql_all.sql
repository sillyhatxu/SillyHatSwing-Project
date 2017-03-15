CREATE TABLE IF NOT EXISTS [T_TODAY_PLAN_DETAIL] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[TODAY_PLAN_ID] VARCHAR(32)  NULL,
[WORD_ID] VARCHAR(32)  NULL,
[IS_ERROR] INTEGER NOT NULL DEFAULT 0,
[OCCURRENCE_NUM] INTEGER NOT NULL DEFAULT 0,
[SORT_NUM] INTEGER NOT NULL DEFAULT 0
);
CREATE TABLE IF NOT EXISTS [T_USER] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[LOGIN] VARCHAR(50)  NULL,
[PASSWORD] VARCHAR(32)  NULL,
[USER_NAME] VARCHAR(10)  NULL,
[IS_DELETE] INTEGER NOT NULL DEFAULT 0,
[IS_ADMINISTRATORS] INTEGER NOT NULL DEFAULT 0,
[CREATED_USER] VARCHAR(32)  NULL,
[CREATED_DATE] DATE  NULL,
[UPDATED_USER] VARCHAR(32)  NULL,
[UPDATED_DATE] DATE  NULL
);
CREATE TABLE IF NOT EXISTS [T_USER_LEARNING_PARAMS] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[USER_ID] VARCHAR(32)  NULL,
[LEARNING_NUM] INTEGER NOT NULL DEFAULT 15,
[REVIEW_NUM] INTEGER NOT NULL DEFAULT 35,
[CREATED_USER] VARCHAR(32)  NULL,
[CREATED_DATE] DATE  NULL,
[UPDATED_USER] VARCHAR(32)  NULL,
[UPDATED_DATE] DATE  NULL
);
CREATE TABLE IF NOT EXISTS [T_USER_LEARNING_PLAN] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[USER_ID] VARCHAR(32)  NULL,
[WORD_ID] VARCHAR(32)  NULL,
[IS_LEARNING] INTEGER NOT NULL DEFAULT 0,
[REVIEW_FREQUENCY] INTEGER NOT NULL DEFAULT 0,
[ERROR_FREQUENCY] INTEGER NOT NULL DEFAULT 0,
[SUCCESS_FREQUENCY] INTEGER NOT NULL DEFAULT 0,
[CREATED_USER] VARCHAR(32)  NULL,
[CREATED_DATE] DATE  NULL,
[UPDATED_USER] VARCHAR(32)  NULL,
[UPDATED_DATE] DATE  NULL
);
CREATE TABLE IF NOT EXISTS [T_USER_TODAY_PLAN] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[USER_ID] VARCHAR(32)  NULL,
[LEARNING_NUM] INTEGER NOT NULL DEFAULT 0,
[IS_FINISH] INTEGER NOT NULL DEFAULT 0,
[CREATED_USER] VARCHAR(32)  NULL,
[CREATED_DATE] DATE  NULL,
[UPDATED_USER] VARCHAR(32)  NULL,
[UPDATED_DATE] DATE  NULL
);
CREATE TABLE IF NOT EXISTS [T_WORD_REPOSITORY] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[WORD] VARCHAR(2000)  NULL,
[PHONETIC] VARCHAR(2000)  NULL,
[REMINDER] VARCHAR(2000)  NULL,
[WORD_TRANSLATE] VARCHAR(2000)  NULL,
[CREATED_USER] VARCHAR(32)  NULL,
[CREATED_DATE] DATE  NULL,
[UPDATED_USER] VARCHAR(32)  NULL,
[UPDATED_DATE] DATE  NULL
);
CREATE INDEX IDX_TPD_TODAY_PLAN_ID ON T_TODAY_PLAN_DETAIL ("TODAY_PLAN_ID" ASC);
CREATE INDEX IDX_TPD_WORD_ID ON T_TODAY_PLAN_DETAIL ("WORD_ID" ASC);

CREATE INDEX IDX_USER_LOGIN ON T_USER ("LOGIN" ASC);
CREATE INDEX IDX_USER_IS_DELETE ON T_USER ("IS_DELETE" ASC);
CREATE INDEX IDX_USER_IS_ADMINISTRATORS ON T_USER ("IS_ADMINISTRATORS" ASC);

CREATE INDEX IDX_ULPARAMS_USER_ID ON T_USER_LEARNING_PARAMS ("USER_ID" ASC);

CREATE INDEX IDX_ULP_USER_ID ON T_USER_LEARNING_PLAN ("USER_ID" ASC);
CREATE INDEX IDX_ULP_WORD_ID ON T_USER_LEARNING_PLAN ("WORD_ID" ASC);

CREATE INDEX IDX_UTP_USER_ID ON T_USER_TODAY_PLAN ("USER_ID" ASC);


INSERT INTO T_USER (ID,LOGIN,PASSWORD,USER_NAME,IS_DELETE,IS_ADMINISTRATORS,CREATED_USER,CREATED_DATE,UPDATED_USER,UPDATED_DATE) VALUES ('402899815ACB535B015ACB535BC9010C', 'administrator', '7F342790BEF47182193EFFA9BCAE7A98', '超级管理员', 0, 1, '402899815ACB535B015ACB535BC9010C', datetime('now'), '402899815ACB535B015ACB535BC9010C', datetime('now'));


INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4D0000','private','1','1','1','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4D0001','privacy','2','2','2','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4D0002','modify','3','3','3','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4D0003','model','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4D0004','mode','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4E0005','modern','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4E0006','moderate','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4E0007','modest','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4E0008','alert','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));
INSERT INTO T_WORD_REPOSITORY VALUES ('402899815ACC658C015ACC658C4E0009','alternative','4','4','4','402899815ACB535B015ACB535BC9010C',datetime('now'),'402899815ACB535B015ACB535BC9010C',datetime('now'));