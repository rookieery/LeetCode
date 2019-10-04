package LeetCode;

public class Solution1084 {
    /**
     * 1084. 销售分析III
     * 编写一个SQL查询，报告2019年春季才售出的产品。即在2019-01-01至2019-03-31（含）之间。
     */
    //错误 where不支持聚合函数
    /**
     * select
     * p.product_id,p.product_name
     * from
     * Product p,Sales s
     * where
     * p.product_id = s.product_id
     * and
     * min(s.sale_date) >= '2019-01-01'
     * and
     * max(s.sale_date) <= '2019-03-31';
     */
    //使用显式内连接+group by+having
    /**
     * select
     * p.product_id,p.product_name
     * from
     * Product p
     * join
     * Sales s
     * on
     * p.product_id = s.product_id
     * group by
     * p.product_id
     * having
     * min(s.sale_date) >= '2019-01-01'
     * and
     * max(s.sale_date) <= '2019-03-31';
     */
}
