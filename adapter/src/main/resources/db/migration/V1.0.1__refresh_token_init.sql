CREATE SEQUENCE refresh_tokens_seq;
create table refresh_tokens
(
    id          int8 default nextval('refresh_tokens_seq') PRIMARY KEY,
    user_id     uuid         not null,
    token       varchar(512) not null,
    expiry_date timestamp,
    foreign key (user_id) references users (id)
);

