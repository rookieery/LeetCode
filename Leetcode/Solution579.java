package LeetCode;

public class Solution579 {
    /**
     * 579. 查询员工的累计薪水
     * 请你编写 SQL 语句，来查询一个员工三个月内的累计薪水，但是不包括最近一个月的薪水。
     * 结果请按 'Id' 升序，然后按 'Month' 降序显示。
     */
    //第一步是求得一个员工最近 3 个月的累积薪资，然后把最近一个月薪资从包含它的数据中去除。
    //第二步按要求去除最近一个月薪资的影响。
    /**
     * select
     * E1.id,E1.month,
     * (ifnull(E1.salary, 0) + IFNULL(E2.salary, 0) + IFNULL(E3.salary, 0)) as Salary
     * from
     *     (select
     *         id, max(month) as month
     *     from
     *         Employee
     *     group by id
     *     having count(*) > 1) as maxmonth
     *         left join
     *     Employee E1 on (maxmonth.id = E1.id
     *         and maxmonth.month > E1.month)
     *         left join
     *     Employee E2 on (E2.id = E1.id
     *         and E2.month = E1.month - 1)
     *         left join
     *     Employee E3 on (E3.id = E1.id
     *         and E3.month = E1.month - 2)
     * order by id, month desc;
     */
}
