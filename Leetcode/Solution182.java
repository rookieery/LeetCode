package LeetCode;

public class Solution182 {
    /**
     * 182. 查找重复的电子邮箱
     * 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
     */
    //自连接
    /**
     * select
     * distinct p1.Email
     * from
     * Person p1,Person p2
     * where
     * p1.Email=p2.Email and p1.Id!=p2.Id;
     */
    //having+group by分组查询
    /**
     * select
     * Email
     * from
     * Person
     * group by
     * Email
     * having
     * count(*)>1;
     */
}
