insert  into users (username, password, enabled) values (
                    'user',
                    'pass',
                    true
);

insert into users values (
                  'admin',
                  'admin',
                  true
);

insert into authorities (username, authority) values ('user','ROLE_USER');

insert into authorities values('admin', 'ROLE_ADMIN');