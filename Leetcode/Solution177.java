package LeetCode;

public class Solution177 {
    /**
     * 177. 第N高的薪水
     * 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
     */
    //仿176
    /**
     * set n=n-1;
     *
     * select
     *       ifnull(
     *           (select distinct Salary from Employee order by Salary desc limit n,1),null)
     *   );
     */
}
