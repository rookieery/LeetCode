package LeetCode;

public class Solution596 {
    /**
     * 596. 超过5名学生的课
     * 有一个courses 表 ，有: student (学生) 和 class (课程)。
     * 请列出所有超过或等于5名学生的课。
     */
    //错误
    /**
     * select
     * class
     * from
     * courses
     * having
     * count(class)>=5;
     */
    //正解
    /**
     * select
     * class
     * from
     * courses
     * group by
     * class
     * having
     * count(distinct student)>=5;
     */
}
