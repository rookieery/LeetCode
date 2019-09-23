package LeetCode;

public class Solution1050 {
    /**
     * 1050. 合作过至少三次的演员和导演
     * 写一条SQL查询语句获取合作过至少三次的演员和导演的 id 对 (actor_id, director_id)
     */
    //group by+多字段
    /**
     * select
     * ACTOR_ID,DIRECTOR_ID
     * from
     * ActorDirector
     * group by
     * actor_id,director_id
     * having
     * count(timestamp)>=3;
     */
}
