create table user(
	id int primary key auto_increment,
	username varchar(100),
	password varchar(100),
	created_at timestamp
) default charset=utf8;


create table category(
	id int primary key auto_increment,
	title varchar(100),
	created_at timestamp

create table post(
	id int primary key auto_increment,
	title varchar(1000),
	content varchar(1000),
	category_id int,
	view_count int,
	created_at timestamp
)default charset=utf8;

create table reply(
	id int primary key auto_increment,
	content varchar(1000),
	username varchar(1000),
	mobile varchar(100),
	created_at timestamp
)default charset=utf8;

insert into user(username, password) values("gx","134")