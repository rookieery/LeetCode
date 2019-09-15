package LeetCode;

public class Solution181 {
    /**
     * 181. 超过经理收入的员工
     * Employee 表包含所有员工，他们的经理也属于员工。
     * 每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
     */
    //子查询（单行单列）> >= < <= =
    /**
     * select
     * e1.Name Employee
     * from
     * Employee e1
     * where
     * e1.ManagerId is not null and e1.Salary >
     * (select e2.Salary from Employee e2 where e2.Id = e1.ManagerId);
     */
}
