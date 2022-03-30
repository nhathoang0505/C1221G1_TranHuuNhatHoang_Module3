drop database if exists ss2_design_and_create_database_bai_tap_2;
create database ss2_design_and_create_database_bai_tap_2;
use ss2_design_and_create_database_bai_tap_2;
CREATE TABLE customer (
    customer_id int auto_increment,
    customer_name varchar(50),
    customer_age int,
    primary key (customer_id)
);

create table `order` (
order_id int auto_increment,
customer_id int,
foreign key (customer_id) references customer(customer_id),
order_date date,
order_total_price double,
primary key (order_id)
);

create table product (
product_id int auto_increment,
product_name varchar(50),
product_price double,
primary key (product_id)
);

create table order_detail (
order_id int,
product_id int,
foreign key (order_id) references `order`(order_id),
foreign key (product_id) references product(product_id),
order_quantity int
);