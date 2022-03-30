use ss2_design_and_create_database_bai_tap_2;
select order_id,order_date,order_total_price from `order`;

select customer.customer_name, product.product_name from customer 
join `order` on  customer.customer_id = `order`.customer_id 
join order_detail on `order`.`order_id` =  order_detail.order_id 
join product on order_detail.product_id = product.product_id
order by customer.customer_name desc;

select customer.customer_name from customer
left join `order` on customer.customer_id = `order`.customer_id
where `order`.order_id is null
order by customer.customer_name desc;

select `order`.order_id, `order`.order_date, sum(order_detail.order_quantity*product.product_price) from `order` 
join order_detail on `order`.order_id = order_detail.order_id 
join product on order_detail.product_id = product.product_id
group by `order`.order_id;