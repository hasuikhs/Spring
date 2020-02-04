# mysql

1. create database test;

2. use test;

3. 테이블 생성

   ```mysql
   create table tbl_board (
   	bno int auto_increment,
       title varchar(200) not null,
       content varchar(200) not null,
       writer varchar(5) not null,
       regdate timestamp default now(),
       updatedate timestamp default now(),
       primary key(bno)
   );
   ```

4. alter 문으로 기본키 설정

   ```mysql
   alter table tbl_board add constraint pk_board primary key(bno);
   ```

   ```mysql
   alter table 테이블명 add [constraint 제약조건이름] primary key(필드명);
   ```

5. 테이블 확인

   ```mysql
   desc tbl_board;
   ```

   ```mysql
   desc 테이블명;
   ```

6. 컬럼 데이터 타입 변경하기

   ```mysql
   alter table 테이블명 modify 컬럼명 데이터타입;
   ```

   

```mysql
use study_db;

drop table tbl_board;
commit;
create table tbl_board (
	bno int auto_increment primary key,
    title varchar(200) not null,
    content varchar(2000) not null,
    writer varchar(50) not null,
    regdate TIMESTAMP DEFAULT NOW(),
    updatedate TIMESTAMP DEFAULT NOW()
);
insert into tbl_board (title, content, writer) values('텍스트 제목','테스트 내용', 'user00');
select *from tbl_board;
delete from tbl_board where bno > 5;
SELECT LAST_INSERT_ID();
commit;
select bno from dual;
select * from tbl_board where bno > 0;
commit;

select bno, title, content, writer, regdate, updatedate from tbl_board limit 0, 10;
select (select *from tbl_board);
select count(bno) as count from tbl_board;

SELECT * FROM (SELECT * FROM tbl_board LIMIT 0,10) AS temp_tbl where title like '%새로%' or content like '%새로%';
alter table tbl_board add (replycnt int default 0);
update tbl_board set replycnt = (select * from(select count(rno) from tbl_reply where tbl_reply.bno = tbl_board.bno)as a) where bno > 0;








create table tbl_reply(
	rno int auto_increment primary key,
    bno integer not null,
    reply varchar(1000) not null,
    replyer varchar(50) not null,
    replyDate TIMESTAMP default now(),
    updateDate timestamp default now(),
    FOREIGN KEY (bno) REFERENCES tbl_board (bno)
);

drop table tbl_reply;
select *from tbl_reply order by rno asc;
select rno, bno, reply, replyer, replyDate, updatedate from tbl_reply where bno = 1 order by rno asc;

select *from tbl_board limit 0, 10;

create index idx_reply on tbl_reply (bno desc, rno asc);

select * from (select * from tbl_reply where bno = 1 and rno > 0 limit 10, 20);
SELECT * FROM (SELECT * FROM tbl_reply LIMIT 10,20) AS temp_tbl where bno = 1 and rno > 0;

select count(rno) from tbl_reply where bno = 1;

commit;






create table tbl_sample1( col1 varchar(500));
drop table tbl_sample1;
select *from tbl_sample1;tbl_reply
create table tbl_sample2( col2 varchar(50));
select *from tbl_sample2;

use spring_1002;
create table tbl_board (
	bno int auto_increment primary key,
    title varchar(200) not null,
    content varchar(2000) not null,
    writer varchar(50) not null,
    regdate TIMESTAMP DEFAULT NOW(),
    updatedate TIMESTAMP DEFAULT NOW()
tbl_replytbl_boardbno);
alter table tbl_board add (replycnt int default 0);
insert into tbl_board (title, content, writer) values('텍스트 제목','테스트 내용', 'user00');
select *from tbl_board;

create table tbl_reply(
	rno int auto_increment primary key,
    bno integer not null,
    reply varchar(1000) not null,
    replyer varchar(50) not null,
    replyDate TIMESTAMP default now(),
    updateDate timestamp default now(),
    FOREIGN KEY (bno) REFERENCES tbl_board (bno)
);

select *from myclass_tb;

use trip_sample;

select *from menu;

USE MYSQL;
select * from user;
create user 'pyj'@'%' identified by 'dbswo1900'; -- %는 외부접근 허용, localhost는 내부접근
FLUSH PRIVILEGES; -- 사용자를 추가, 삭제, 권한 변경 등을 수행했을 때 변경 사항을 반영하기 위해서 사용
drop user 'bizspring'; -- 삭제
show grants; -- 사용자 권한 확인
show grants for 'pyj'@'%'; -- 부여된 권한 확인
grant all privileges on *.* to 'pyj'@'%'; -- 사용자에게 모든 DB 모든 테이블에 모든 권한 부여
grant all privileges on DBname.* to 'pyj'@'%'; -- 사용자에게 특정 DB에 대한 모든 권한 부여.
grant select, insert, update on DBname.* to 'pyj'@'%'; -- 사용자에게 특정 DB에 대한 select, insert, update 권한 부여

create database test01;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'dbswo@1900';
FLUSH PRIVILEGES;
commit;
use test01;
create table users
(
	IDX INT AUTO_INCREMENT PRIMARY KEY ,
	user_id VARCHAR(100) NOT NULL ,
    user_pwd VARCHAR(100) NOT NULL ,
    user_name VARCHAR(100) NOT NULL ,
    del_yn VARCHAR(50) NOT NULL ,
    hit_cnt INT DEFAULT 0
);
commit;
show tables;
select * from users;

use study_db;

create table student
(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    studentNum VARCHAR(50) NOT NULL
);

select * from student;
insert into student(name, studentNum) values("박윤재","H반");
insert into student(name, studentNum) values("김민수","H반");
insert into student(name, studentNum) values("김시현","H반");
insert into student(name, studentNum) values("손흥민","B반");
insert into student(name, studentNum) values("김연아","B반");
commit;
```

