package LeetCode;

public class Solution196 {
    /**
     * 196. 删除重复的电子邮箱
     * 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
     */
    //自连接
    /**
     * delete
     * p1
     * from
     * Person p1,Person p2
     * where
     * p1.Email=p2.Email
     * and
     * p1.Id>p2.Id;
     */
    //子查询
    /**
     * DELETE FROM Person
     * WHERE Id NOT IN (   -- 删除不在查询结果中的值
     *     SELECT id FROM
     *    (
     *        SELECT MIN(Id) AS Id -- 排除Email相同时中Id较大的行
     *        FROM Person
     *        GROUP BY Email
     *    ) AS temp    -- 此处需使用临时表，否则会发生报错
     * );
     */
}
