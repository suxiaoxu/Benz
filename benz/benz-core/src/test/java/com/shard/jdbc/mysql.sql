create database shard1;
use shard1;
create table shard_table01(
user_id int,
user_name VARCHAR(100)
);
create table shard_table02(
user_id int,
user_name VARCHAR(100)
);

create database shard2;
use shard2;
create table shard_table03(
user_id int,
user_name VARCHAR(100)
);
create table shard_table04(
user_id int,
user_name VARCHAR(100)
);

select * from shard_table03;

create table user(
userId int,
userName VARCHAR(100)
)
insert into user values(1,"zhansan");