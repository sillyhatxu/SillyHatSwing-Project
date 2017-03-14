CREATE TABLE IF NOT EXISTS [T_USER_LEARNING_PARAMS] (
[ID] VARCHAR(32)  NULL PRIMARY KEY,
[USER_ID] VARCHAR(32)  NULL,
[LEARNING_NUM] INTEGER NOT NULL DEFAULT 15,
[REVIEW_NUM] INTEGER NOT NULL DEFAULT 35,
[CREATED_USER] VARCHAR(32)  NULL,
[CREATED_DATE] DATE  NULL,
[UPDATED_USER] VARCHAR(32)  NULL,
[UPDATED_DATE] DATE  NULL
)