package LeetCode;

public class Solution178 {
    /**
     * 178. 分数排名
     *编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。
     * 请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔
     */
    //自连接
    /**
     * select
     * Score,
     * (select count(distinct score)
     * from
     * Scores
     * where
     * score >= s.score)
     * As
     * Rank
     * from
     * Scores s
     * order by
     * Score
     * desc;
     */
}
