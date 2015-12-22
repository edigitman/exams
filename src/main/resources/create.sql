CREATE TABLE user (
  id       INTEGER AUTO_INCREMENT NOT NULL,
  name     VARCHAR(20)            NOT NULL,
  lastname VARCHAR(20)            NOT NULL,
  email    VARCHAR(20)            NOT NULL,
  token    VARCHAR(20),
  password VARCHAR(20),
  role     VARCHAR(20)            NOT NULL
);

INSERT INTO user (name, lastname, email, token, password, role)
VALUES ('admin', 'root', 'admin@mail.com', '123', '123', 'ROLE_ADMIN');