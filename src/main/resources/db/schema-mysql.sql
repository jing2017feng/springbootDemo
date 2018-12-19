drop table if exists user;
CREATE TABLE user (
  id int(11) NOT NULL,
  name varchar(45) DEFAULT NULL,
  age int(3) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
