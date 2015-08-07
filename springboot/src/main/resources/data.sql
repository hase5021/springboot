insert into users (user_id, login_id, password, display_name, enabled)
  values (1, 'admin', 'admin', '管理者', true);
insert into users (user_id, login_id, password, display_name, enabled)
  values (2, 'staff', 'staff', 'スタッフ', true);
insert into users (user_id, login_id, password, display_name, enabled)
  values (3, 'guest', 'guest', 'ゲスト', true);

insert into authorities (user_id, authority) values (1, 'ROLE_ADMIN');
insert into authorities (user_id, authority) values (1, 'ROLE_STAFF');
insert into authorities (user_id, authority) values (2, 'ROLE_STAFF');
