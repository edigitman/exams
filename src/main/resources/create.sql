CREATE TABLE user (
  id       INTEGER AUTO_INCREMENT NOT NULL,
  name     VARCHAR(20)            NOT NULL,
  lastname VARCHAR(20)            NOT NULL,
  email    VARCHAR(20)            NOT NULL,
  password VARCHAR(20),
  role     VARCHAR(20)            NOT NULL,
  enabled  boolean 				  NOT NULL
);
