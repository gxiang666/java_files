create table test_user(
	id int(4) primary key auto_increment,
	name varchar(255) not null,
	age int(4) not null
) default charset = utf8;

insert into test_user(name, age) values("gx", 22);

select * from test_user;

update test_user set name ="xgx" where id =1;

delete from test_user where id = 1;