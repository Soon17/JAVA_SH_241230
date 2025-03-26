USE COMMUNITY;

SELECT *
FROM COMMUNITY.MEMBER;

insert into member(me_id, me_pw, me_email) values("asd", "asd", "");
insert into member(me_id, me_pw, me_email, me_authority) values("admin", "admin", "", "ADMIN");