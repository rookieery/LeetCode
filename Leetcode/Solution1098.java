package LeetCode;

public class Solution1098 {
    /**
     * 1098. 小众书籍
     * 你需要写一段 SQL 命令，筛选出去年一年订单总量少于10本的书籍 。
     *
     * 注意：不考虑 上架（available from）距今 不满一个月 的书籍。并且 假设今天是 2019-06-23 。
     */
    //错误 and where ????
    /**
     * select
     * b.book_id,b.name
     * from
     * Books b left join Orders o
     * on
     * b.book_id = o.book_id
     * and
     * b.available_from<'2019-05-23'
     * group by
     * b.book_id
     * having
     * ifnull(sum(if(o.dispatch_date<'2018-06-23',0,quantity)),0)<10;
     */
    //内连接+外连接
    /**
     * select
     * b.book_id,b.name
     * from
     * Books b left join Orders o
     * on
     * b.book_id = o.book_id
     * where
     * b.available_from<'2019-05-23'
     * group by
     * b.book_id
     * having
     * ifnull(sum(if(o.dispatch_date<'2018-06-23',0,quantity)),0)<10;
     */
}
