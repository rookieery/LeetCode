package LeetCode;

public class Solution184 {
    /**
     * 184. 部门工资最高的员工
     * 编写一个 SQL 查询，找出每个部门工资最高的员工。
     * 例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
     */
    //使用子查询+显示内连接
    /**
     * SELECT
     *     Department.name AS 'Department',
     *     Employee.name AS 'Employee',
     *     Salary
     * FROM
     *     Employee
     *         JOIN
     *     Department ON Employee.DepartmentId = Department.Id
     * WHERE
     *     (Employee.DepartmentId , Salary) IN
     *     (   SELECT
     *             DepartmentId, MAX(Salary)
     *         FROM
     *             Employee
     *         GROUP BY DepartmentId
     * 	)
     */
}
