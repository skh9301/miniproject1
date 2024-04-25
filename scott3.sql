

drop table member;
select * from member;
create Sequence bookG_seq;
ALTER TABLE book
ADD bname VARCHAR2(50 CHAR) NOT NULL;

create table member(
    userID varchar2(50 char) primary key,
    pass varchar2(50 char) not null,
    nickName varchar2(50 char) not null,
    mPhone varchar2(50 char) ,
    eMail varchar2(150 char)
);

create table content(
    content_no number primary key,
    userID varchar2(50 char) not null,
    con_title varchar(500) not null,
    con_re_date timestamp default sysdate,
    con_text varchar2(2000 char),
    con_file varchar2(50 char),
    con_count number default 0,
    con_good number default 0,
    con_share char(1) default '0',
    foreign key (userID) references member(userID)
);
alter table content add con_bad number defaule 0;
create table comment1 (
    com_no number primary key,
    content_no number not null,
    com_text varchar2(2000 char) not null,
    com_good number default 0,
    com_bad number default 0,
    com_date timestamp default sysdate,
    foreign key (content_no) references content(content_no)
);
commit;
create Sequence com_seq;
create Sequence content_seq;
drop table content;
select * from content;

select * from jspbbs order by no desc;
delete content where content_no=1;

select * from (select rownum num,no,title,writer,content,reg_date,read_count,pass,file1 from (select * from jspbbs order by no desc)) where num >= 10 and num <= 20;

insert into member(userID, pass, nickName, mPhone, eMail)
values ('user1', 'password1', 'User One', '123-456-7890', 'user1@example.com');

insert into member(userID, pass, nickName, mPhone, eMail)
values ('user2', 'password2', 'User Two', '987-654-3210', 'user2@example.com');

-- content 테이블에 레코드 삽입
insert into content(content_no, userID,con_title, con_text, con_file)
values (content_seq.nextval, 'user1','아무거나완료', 'Content One by User One', 'file1.txt');

insert into content(content_no, userID, con_text, con_file)
values (content_seq.nextval, 'user2', 'Content Two by User Two', 'file2.txt');

-- comment1 테이블에 레코드 삽입
insert into comment1(com_no, content_no, com_text)
values (com_seq.nextval, content_seq.nextval, 'Comment One for Content One');

insert into comment1(com_no, content_no, com_text)
values (com_seq.nextval, content_seq.nextval, 'Comment Two for Content Two');

-- content 테이블에 레코드 삽입
insert into content(content_no, userID, con_text, con_file)
values (content_seq.nextval, 'user1', 'Content One by User One', 'file1.txt');

-- comment1 테이블에 레코드 삽입
insert into comment1(com_no, content_no, com_text)
values (com_seq.nextval, content_seq.currval, 'Comment One for Content One');