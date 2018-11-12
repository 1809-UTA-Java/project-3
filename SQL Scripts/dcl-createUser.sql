/* Create database and user */
CREATE USER ndadmin
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

/* Grant permissions to user */
GRANT connect to ndadmin;
GRANT resource to ndadmin;
GRANT create session to ndadmin;
GRANT create table to ndadmin;
GRANT create view to ndadmin;