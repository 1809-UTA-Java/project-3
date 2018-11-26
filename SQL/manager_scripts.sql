CREATE TABLE managers (
    ID varchar(255),
    LastName varchar(255),
    FirstName varchar(255),
    Username varchar(255),
    Password varchar(255) 
);

INSERT INTO managers (
    id,
    lastname,
    firstname,
    username,
    password
) VALUES (
    '0',
    'Bunyon',
    'Paul',
    'mule',
    'doubt'
);

INSERT INTO managers (
    id,
    lastname,
    firstname,
    username,
    password
) VALUES (
    '1',
    'Marab',
    'Master',
    'cant',
    'lose'
);

commit;