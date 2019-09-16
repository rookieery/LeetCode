package LeetCode;

public class Solution1045 {
    /**
     * 1045. 买下所有产品的客户
     * 写一条 SQL 查询语句，从 Customer 表中查询购买了 Product 表中所有产品的客户的 id。
     */
    //分组+去重
    /**
     * select
     * customer_id
     * from
     * Customer
     * group by
     * customer_id
     * having
     * count(distinct(product_key)) = (select count(*) from Product);
     */
}
