USE expense_directory;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
);

INSERT INTO `users` VALUE ('Harsith','{noop}test123',1);
INSERT INTO `users` VALUE ('Admin','{noop}Admin',1);

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);

INSERT INTO `authorities` 
VALUES 
('Harsith','ROLE_USER'),
('Admin','ROLE_USER')
;
select * from authorities

