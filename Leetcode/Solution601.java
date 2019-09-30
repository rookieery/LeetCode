package LeetCode;

public class Solution601 {
    /**
     * 601. 体育馆的人流量
     * 请编写一个查询语句，找出人流量的高峰期。高峰期时，至少连续三行记录中的人流量不少于100。
     */
    //多条件，自连接
    /**
     * select
     * distinct s1.*
     * from
     * stadium s1,stadium s2,stadium s3
     * where
     * s1.people>=100 and s2.people>=100 and s3.people>=100
     * and(
     *     (s1.id = s2.id-1 and s2.id = s3.id -1) or
     *     (s1.id = s2.id-1 and s1.id = s3.id +1) or
     *     (s1.id = s2.id+1 and s2.id = s3.id +1)
     * )
     * order by
     * s1.id;
     */
}
