package LeetCode;

public class Solution1082 {
    /**
     * 1082. 销售分析 I
     * 编写一个 SQL 查询，查询总销售额最高的销售者，如果有并列的，就都展示出来。
     */
    //分组+子查询
    //group by seller_id 问什么一定要有？？？
    /**
     * select
     * seller_id
     * from
     * Sales
     * group by
     * seller_id
     * having
     * sum(price) >= all(select sum(price) from Sales group by seller_id);
     */
}
