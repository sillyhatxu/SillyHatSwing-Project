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
)