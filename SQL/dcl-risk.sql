/* Create database and user */
CREATE USER proj3risk
IDENTIFIED BY pass
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to proj3risk;
GRANT resource to proj3risk;
GRANT create session to proj3risk;
GRANT create table to proj3risk;
GRANT create view to proj3risk;
