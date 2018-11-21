/* Create database and user */
CREATE USER frozenAccounts
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to frozenAccounts;
GRANT resource to frozenAccounts;
GRANT create session to frozenAccounts;
GRANT create table to frozenAccounts;
GRANT create view to frozenAccounts;
