create table users (
  user_id int auto_increment,
  login_id varchar(256),
  password varchar(256),
  display_name varchar(255),
  enabled boolean,
  primary key(user_id)
);

create table authorities (
  user_id int,
  authority varchar(256),
  primary key(user_id, authority),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

