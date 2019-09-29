package LeetCode;

public class Solution626 {
    /**
     * 626. 换座位
     * 小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。
     * 其中纵列的 id 是连续递增的
     * 小美想改变相邻俩学生的座位。
     * 你能不能帮她写一个 SQL query 来输出小美想要的结果呢？
     */
    //奇数行关联下一个偶数行。偶数行关联上一个奇数行。(左自连接）
    //将右边列的student值替换左边列的student即可。
    /**
     * select
     * s1.id,
     * ifnull(s2.student, s1.student) AS student
     * from
     * seat s1
     * left join seat s2
     * on (s1.id % 2 = 1 AND s1.id+1 = s2.id OR s1.id % 2 = 0 AND s1.id-1 = s2.id)
     * order by s1.id;
     */
}
