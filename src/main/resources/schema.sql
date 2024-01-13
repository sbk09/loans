CREATE TABLE IF NOT EXISTS loans(
    loan_id int not null AUTO_INCREMENT,
    mobile_number varchar(50) NOT NULL,
    loan_number varchar(100) NOT NULL,
    loan_type varchar(100) NOT NULL,
    total_loan int not null,
    amount_paid int NOT NULL,
    outstanding_amount int NOT NULL,
    created_by varchar(50) NOT NULL,
    created_date DATE NOT NULL,
    updated_by varchar(50) DEFAULT NULL,
    updated_date DATE DEFAULT NULL,
    PRIMARY KEY (loan_id)
);

CREATE SEQUENCE "MY_OWN_LOAN_SEQ"
MAXVALUE 999999999
INCREMENT BY 50
START WITH 202700
NOCACHE
NOCYCLE;