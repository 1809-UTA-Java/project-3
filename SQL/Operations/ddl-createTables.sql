/* Create Table for Credit Cards */
CREATE TABLE CREDIT_CARDS (
    card_number varchar2(40) primary key,
    balance number(7,2),
    status varchar2(20),
    credit_line number(7),
    expiration date,
    user_Id varchar2(40),
    rewards number(7,2),
    cvv number(4),
    interest_rate number
);


/* Create Table for Loans */
CREATE TABLE LOANS (
    loan_Id number primary key,
    loan_type varchar2(40),
    balance number(*,2),
    user_Id varchar2(40),
    interest_rate number,
    grace_period date,
    principal number(*,2)
);

/* Create Sequence for Loans */
create sequence loan_sequence 
minvalue 1
start with 1
increment by 1
nocache
nocycle;

/* Create Table for Transactions */
CREATE TABLE TRANSACTIONS (
    transaction_Id varchar2(40) primary key,
    transaction_date date,
    amount number(*,2),
    card_number varchar2(40),
    trans_source varchar2(30),
    trans_description varchar2(40),
    status varchar2(30),
    trans_type varchar2(20)
);

/* Create Sequence for Transactions*/
create sequence transaction_sequence 
minvalue 1000000
start with 1000000
increment by 1
nocache
nocycle; 

/* Add Foreign Key contraint to card_number in Transactions */
ALTER TABLE TRANSACTIONS
ADD FOREIGN KEY (card_number) REFERENCES credit_cards(card_number);

