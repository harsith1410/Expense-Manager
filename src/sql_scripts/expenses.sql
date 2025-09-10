CREATE SCHEMA expense_directory;
Use expense_directory;

CREATE TABLE expenses (
	
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    expense_user VARCHAR(40) NOT NULL,
    expense_date VARCHAR(10) NOT NULL,
    expense_category VARCHAR(20) NOT NULL,
    expense_details VARCHAR(50) NOT NULL,
    expense_type VARCHAR(10) NOT NULL,
    expense_price INT NOT NULL
);

INSERT INTO expenses VALUE(1,"ADMIN","2020-05-05","FOOD","COFFEE","EXPENSE",150);
select * from expenses;