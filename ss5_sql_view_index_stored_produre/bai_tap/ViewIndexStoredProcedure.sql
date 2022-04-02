drop database if exists bai_tap_ss5;
create database bai_tap_ss5;
use bai_tap_ss5;
create table products (
    id int auto_increment primary key,
    product_code varchar(45),
    product_name varchar(45),
    product_price double,
    product_amount int,
    product_description varchar(45),
    product_status varchar(45)
);
insert into products values (1,"1123","bike",5000,1,"mountainbike","brandnew");
select * from products;
explain select * from products;

create unique index unique_index
on products(product_code); 
explain select * from products;


CREATE INDEX composite_index
ON products(product_name,product_price);
explain select * from products;

CREATE VIEW products_view AS
SELECT product_Code, product_Name, product_Price, product_Status
FROM products;

drop view products_view;

Delimiter //
Create Procedure allrecords()
    BEGIN
    Select * from products;
    END//
DELIMITER ;
CALL allrecords ();

---
delimiter //
create procedure add_new_product(
in product_name varchar(45),
in product_price double,
in product_amount int,
in product_description varchar(45),
product_status bit(1)
)
begin
insert into products (product_name,product_price,product_amount,product_description,product_status)
values
(product_name,product_price,product_amount,product_description,product_status);
end //
delimiter ;

call add_new_product("iphone",5000,1,"text",1);

call allrecords();

delimiter //
create procedure edit_product(
in product_id int,
in product_nameproduct_ varchar(45),
in product_price double,
in product_amount int,
in product_description varchar(45),
product_status bit(1)
)
begin
update products
set products.product_name = product_name,
products.product_price = product_price,
products.product_amount = product_amount,
products.product_description = product_description,
products.product_status = product_status
where products.id = id;
end //
delimiter ;
set sql_safe_updates = 0;
call edit_product(3,"laptop",1000,10,"daikin",1);
set sql_safe_updates = 1;
call allrecords;

delimiter //
create procedure delete_product(in id int)
begin
delete from products
where products.id = id;
end //
delimiter ;

call allrecords;

call delete_product(4);

call allrecords;



