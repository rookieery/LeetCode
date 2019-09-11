package LeetCode;

public class Solution176 {
    /**
     * 176. 第二高的薪水
     * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
     */
    //使用 LIMIT 子句获得第二高的薪资
    //使用 “IFNULL” 函数解决 “NULL” 问题
    /**
     * select
     * ifnull(
     * (select distinct
     * Salary
     * from
     * Employee
     * order by Salary desc
     * limit 1,1),
     * null)
     * as
     * SecondHighestSalary;
     */
}

