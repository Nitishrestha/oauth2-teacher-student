create table if not exists oauth_access_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(255)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);

create table if not exists roles(
  id INT,
  name VARCHAR(255)
);

insert into roles VALUES
(1, 'ROLE_STUDENT'),
(2,'ROLE_TEACHER'),
(3,'ROLE_PRINCIPAL'),
(4,'ROLE_ADMIN');