package LeetCode;

public class Solution512 {
    /**
     * 512. 游戏玩法分析 II
     * 请编写一个 SQL 查询，描述每一个玩家首次登陆的设备名称
     */
    //where+in子查询
    /**
     * select
     * player_id,device_id
     * from
     * Activity
     * where
     * (player_id,event_date)
     * in
     * (select player_id,min(event_date) from activity group by player_id);
     */
}
