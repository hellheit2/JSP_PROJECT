

use fk_test;

drop table if exists user;
-- 회원 테이블 생성
create table user(
    user_id varchar(15) not null primary key,
    pwd varchar(20) not null,
    name varchar(15) not null,
    email varchar(50),
    joinDate datetime default now()
);

-- api로 대체
drop table if exists contents;
-- 컨텐츠 테이블 생성
create table contents(
    content_id varchar(15) not null primary key,
    title varchar(15) not null unique,
    summary text,
    image_path varchar(50),
    view_count int,
    rate float
);

-- api로 대체
drop table if exists genre;
-- 장르 테이블 생성
create table genre(
    genre_name varchar(10),
    content_id varchar(15),
    constraint fk_genre_contents foreign key(content_id) references contents(content_id)
	on delete cascade
	on update cascade,
    primary key(content_id, genre_name)
);

-- api로 대체
drop table if exists platform;
-- 플랫폼 테이블 생성
create table platform(
    platform_name varchar(10),
    content_id varchar(15),
    constraint fk_platform_contents foreign key(content_id) references contents(content_id)
    on delete cascade
	on update cascade,
    primary key(content_id, platform_name)
);


drop table if exists wish;
-- 찜목록 테이블 생성
create table wish(
    user_id varchar(15),
	content_id varchar(15),
	constraint fk_wish_user foreign key(user_id) references user(user_id)
	on delete cascade
	on update cascade,
	-- api로 대체
	/*constraint fk_wish_contents foreign key(content_id) references contents(content_id)
	on delete cascade
	on update cascade,*/
    primary key(user_id,content_id)   
);


drop table if exists comment;
-- 댓글 테이블 생성
create table comment(
    comment_id int auto_increment not null primary key,
    user_id varchar(15),
    content_id varchar(15),
    parent_comment int default 0,
    comment_body text,
    write_date datetime default now(),
    update_date datetime default now(),
    comment_like int default 0,
    constraint fk_comment_user foreign key(user_id) references user(user_id)
    on delete cascade
	on update cascade
	-- api로 대체
	/*constraint fk_comment_contents foreign key(content_id) references contents(content_id)
	on delete cascade
	on update cascade*/
);

drop table if exists comment_like;
-- 댓글 좋아요 테이블 생성
create table comment_like(
    user_id varchar(155),
    comment_id int,
    constraint fk_comment_like_user foreign key(user_id) references user(user_id) 
    on delete cascade 
    on update cascade,
	constraint fk_comment_like_comment foreign key(comment_id) references comment(comment_id) 
	on delete cascade
	on update cascade,
	primary key(user_id,comment_id)   
);

-- 사용자 테스트 케이스
insert into user (user_id, pwd, name, email) 
values ('test','test','kim', 'kim@naver.com');
insert into user (user_id, pwd, name, email) 
values ('test2','test2','lee', 'lee@naver.com');
select * from user;

-- 영화 테스트 케이스
insert into contents (content_id, title, summary, image_path, view_count, rate) 
values ('000000','영화1','영화1 내용', '/images/movie1.png', 10, 5.0);
insert into contents (content_id, title, summary, image_path, view_count, rate) 
values ('000001','영화2','영화2 내용', '/images/movie2.png', 20, 7.0);
select * from contents;

-- 장르 테스트 케이스
insert into genre (genre_name, content_id) 
values ('액션','000000');
insert into genre (genre_name, content_id) 
values ('코미디','000000');
select * from genre where content_id = '000000';
-- delete from contents where content_id = '000000'; (on delete cascade)
-- update contents set content_id='000000' where content_id='000002'; (on update cascade)

-- 플랫폼 테스트 케이스
insert into platform (platform_name, content_id) 
values ('넷플릭스','000000');
insert into platform (platform_name, content_id) 
values ('왓챠','000001');
select * from platform;

-- 찜목록 테스트 케이스
insert into wish (user_id, content_id) 
values ('test','960704');
select * from wish;

-- 댓글 테스트 케이스
insert into comment (user_id, content_id, comment_body) 
values ('test','960704', '재밌어요!');
insert into comment (user_id, content_id, comment_body) 
values ('test','960704', '보다 잤어요');
insert into comment (user_id, content_id, comment_body) 
values ('test','960704', '잘 보고 왔습니다');
select * from comment;


-- 댓글 좋아요 테스트 케이스 (comment_like 추가, comment 1증가 병행)
insert into comment_like (user_id, comment_id) 
values ('test',1);
update comment set comment_like = (comment_like+1) where comment_id = 1;



/*
테스트 쿼리
select * from comment_like where user_id = 'test';
select * from comment;
update comment set comment_like=0 where comment_id='1';
update comment set comment_body = "내용 수정", update_date = now() where comment_id = 19;
select content_id from wish where user_id = "test" limit 1 , 4;
select * from wish;
select count(*) from wish where user_id="test";
*/
