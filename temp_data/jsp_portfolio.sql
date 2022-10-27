

use test;

drop table if exists user;
-- 회원 테이블 생성
create table user(
    user_id varchar(15) not null primary key,
    pwd varchar(20) not null,
    name varchar(15) not null,
    email varchar(50),
    joinDate date default now()
);

insert into user (user_id, pwd, name, email) 
values ('test','test','kim', 'test@naver.com');


drop table if exists contents;
-- 회원 테이블 생성
create table contents(
    content_id varchar(15) not null primary key,
    title varchar(15) not null,
    summary text,
    image_path varchar(15),
    view_count int,
    rate float
);

drop table if exists genre;
-- 회원 테이블 생성
create table genre(
    genre_name varchar(10),
    content_id varchar(15),
    primary key(content_id, genre_name)
);

drop table if exists platform;
-- 회원 테이블 생성
create table platform(
    platform_name varchar(10),
    content_id varchar(15),
    primary key(content_id, platform_name)
);


drop table if exists wish;
-- 회원 테이블 생성
create table wish(
    user_id varchar(15),
	content_id varchar(15),
    primary key(content_id)   
);


drop table if exists comment;
-- 회원 테이블 생성
create table comment(
    comment_id int auto_increment not null primary key,
    user_id varchar(15),
    content_id varchar(15),
    parent_comment int default 0,
    comment_body text,
    rate float,
    write_date date default now(),
    update_date date default now(),
    comment_like int,
    comment_dislike int
);


select * from user;


insert into wish (user_id, content_id) 
values ('test','960704');

select content_id from wish where user_id = 'test'

select * from wish;

insert into comment (user_id, content_id, comment_body) 
values ('test','960704', '재밌어요!');
insert into comment (user_id, content_id, comment_body) 
values ('test','960704', '보다 잤어요');
insert into comment (user_id, content_id, comment_body) 
values ('test','960704', '잘 보고 왔습니다');