
select * from board;

drop table reply;
-- reply_board_idx: 외래키 - 다른 테이블의 인덱스키를 가지고 있음

CREATE TABLE board
(
    board_idx         NUMBER(4)       PRIMARY KEY,
    board_name        VARCHAR2(20),
    board_title       VARCHAR2(100),
    board_content     VARCHAR2(300),
    board_date        date default SYSDATE,
    board_hit         NUMBER(4) DEFAULT 0

);

DROP sequence  reply_board_seq;
create sequence reply_board_seq;

insert into reply (reply_idx, reply_name, reply_content, reply_date, reply_board_idx)
values (reply_board_seq.nextval, '홍두깨', '댓글 제목1', sysdate, 1);
insert into reply (reply_idx, reply_name, reply_content, reply_date, reply_board_idx)
values (reply_board_seq.nextval, '심청', '댓글 제목2', sysdate, 2);
insert into reply (reply_idx, reply_name, reply_content, reply_date, reply_board_idx)
values (reply_board_seq.nextval, '심봉사', '댓글 제목3', sysdate, 3);



SELECT * FROM reply;

commit;

