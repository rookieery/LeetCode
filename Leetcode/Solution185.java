package LeetCode;

public class Solution185 {
    /**
     * 185. 部门工资前三高的所有员工
     * 编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。
     */
    //外连接+子查询
    /**
     * SELECT
     *     d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
     * FROM
     *     Employee e1
     *         JOIN
     *     Department d ON e1.DepartmentId = d.Id
     * WHERE
     *     3 > (SELECT
     *             COUNT(DISTINCT e2.Salary)
     *         FROM
     *             Employee e2
     *         WHERE
     *             e2.Salary > e1.Salary
     *                 AND e1.DepartmentId = e2.DepartmentId
     *         )
     * ;
     */
    //语法不对
    /**
     * select
     * Department.Name Department,Employee.Name Employee,Employee.Salary Salary
     * from
     * Employee
     * left join
     * Department
     * on
     * Department.Id = Employee.DepartmentId
     * where
     * order by (
     *     select distinct
     * Salary
     * from
     * Employee e1,Employee e2
     * where
     * e1.DepartmentId = e2.DepartmentId) desc
     * limit 1,3;
     */
}
