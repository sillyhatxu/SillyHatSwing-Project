CREATE TABLE IF NOT EXISTS [T_USER_LEARNING_PLAN] (
[ID] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
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
)