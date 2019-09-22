package LeetCode;

public class Solution180 {
    /**
     * 180. 连续出现的数字
     * 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
     */
    //注意使用distinct
    /**
     * select distinct
     * l1.Num ConsecutiveNums
     * from
     * Logs l1,
     * Logs l2,
     * Logs l3
     * where
     * l1.Id=l2.Id-1
     * and
     * l2.Id=l3.Id-1
     * and
     * l1.Num=l2.Num
     * and
     * l2.Num=l3.Num;
     */
}
