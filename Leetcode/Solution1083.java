package LeetCode;

public class Solution1083 {
    /**
     * 1083. 销售分析 II
     * 编写一个 SQL 查询，查询购买了 S8 手机却没有购买 iPhone 的买家。
     * 注意这里 S8 和 iPhone 是 Product 表中的产品。
     */
    // where+in子查询
    /**
     * select distinct(s.buyer_id)
     * from
     * product p,sales s
     * where
     * s.product_id=p.product_id
     * and
     * p.product_name='S8'
     * and s.buyer_id not in(
     * select s.buyer_id
     * from
     * product p,sales s
     * where
     * s.product_id=p.product_id
     * and
     * p.product_name='iPhone');
     */
}

