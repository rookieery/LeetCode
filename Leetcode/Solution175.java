package LeetCode;

public class Solution175 {
    /**
     * 175. 组合两个表
     * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
     */
    //为了能够实现题目的要求条件，只能使用外连接，不能使用内连接
    /**
     * select
     * Person.FirstName,
     * Person.LastName,
     * Address.City,
     * Address.State
     * from
     * Person left join Address
     * on
     * Person.PersonId=Address.PersonId;
     */
}
