package LeetCode;

public class Solution183 {
    /**
     * 183. 从不订购的客户
     * 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
     */
    //子查询（多行单列）in
    /**
     * select
     * Name Customers
     * from
     * Customers
     * where
     * Id not in (
     * select CustomerId from Orders );
     */
}
