

use test;

if exists drop table user;
-- 회원 테이블 생성
create table user(
    uno int auto_increment not null primary key,
    id varchar(15),
    pwd varchar(20),
    name varchar(15),
    email varchar(50),
    joinDate date default now()
);

insert into user (id, pwd, name, email) 
values ('test','test','kim', 'test@naver.com');


if exists drop table contents;
-- 회원 테이블 생성
create table contents(
    cno int auto_increment not null primary key,
    title varchar(15),
    summary text,
    image_path varchar(15),
    view_count int,
    rate float
);

if exists drop table genre;
-- 회원 테이블 생성
create table genre(
    gname varchar(10),
    cno int,
    foreign key (cno) references contents(cno),
    primary key(cno, gname)
);

if exists drop table platform;
-- 회원 테이블 생성
create table platform(
    pname varchar(10),
    cno int,
    foreign key (cno) references contents(cno),
    primary key(cno, pname)
);


if exists drop table favorite;
-- 회원 테이블 생성
create table favorite(
    uno int,
	cno int,
    foreign key (uno) references user(uno),
    foreign key (cno) references contents(cno),
    primary key(cno)   
);


if exists drop table comment;
-- 회원 테이블 생성
create table comment(
    comment_id int auto_increment not null primary key,
    uno int,
    cno int,
    parent_comment int default 0,
    comment_body text,
    rate float,
    write_date date default now(),
    foreign key (uno) references user(uno),
    foreign key (cno) references contents(cno)
);

