package LeetCode;

public class Solution197 {
    /**
     * 197. 上升的温度
     * 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
     */
    //隐式内连接
    /**
     * select
     * a.Id
     * from
     * Weather a,
     * Weather b
     * where
     * a.Temperature > b.Temperature
     * and
     * dateDiff(a.RecordDate,b.RecordDate) = 1;
     */
    //显示内连接
    /**
     * select
     * a.Id
     * from
     * Weather a
     * join
     * Weather b
     * on
     * a.Temperature > b.Temperature
     * and
     * dateDiff(a.RecordDate,b.RecordDate) = 1;
     */
}
