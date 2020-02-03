create sequence card_id_seq;

create table cards(

    id bigint primary key,
    name varchar(128) not null

);