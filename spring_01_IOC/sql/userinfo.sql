
drop table userinfo;
create table userinfo (
	userid    varchar2(15) primary key,
	username   varchar2(20),
	userpwd    varchar2(10),
	email      varchar2(50),
	phone      varchar2(15),
	address    varchar2(100)
);


insert into userinfo (userid, username, userpwd, email, phone, address)
values ('admin', '관리자', 'a1234', 'admin@multicampus.co.kr', '02-1234', '서울 역삼');

insert into userinfo (userid, username, userpwd) values ('user01', '길동이', '1234');
commit;



add = "insert into userinfo (userid, username, userpwd, email, 
                                 phone,address) values (?, ?, ?, ?, ?, ?)";

login = "select * from userinfo where userid=? and userpwd = ?";

user1 = "select * from userinfo where userid = ?";

list = "select * from userinfo ";

update ="update userinfo set email=?,phone=?,address=? where userid =?";

delete = "delete from userinfo where  userid  = ? ";

sql1 = "select * from userinfo where "+condition +" like '%'||?||'%'";


