create table RATE_HISTORY
(
    ID        BIGINT auto_increment,
    YEAR      VARCHAR(250) not null,
    MONTH     VARCHAR(250) not null,
    DAY       VARCHAR(250) not null,
    BASE_CODE VARCHAR(250) not null,
    RATES     CLOB         not null,
    constraint RATE_HISTORY_PK
        primary key (ID)
);

create unique index RATE_HISTORY_ID_UINDEX
    on RATE_HISTORY (ID);