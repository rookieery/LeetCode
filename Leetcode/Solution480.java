package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution480 {
    /**
     * 480. 滑动窗口中位数
     * 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位
     * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     */
    //二分查找加插入排序
    public double[] medianSlidingWindow1(int[] nums, int k) {
        double[] res = new double[nums.length + 1 - k];
        List<Integer> list = new ArrayList<>();
        int index, pos;

        // 对前k个数字使用插入排序，并使用二分查找找到最佳插入点
        for (int i = 0; i < k; i++) {
            pos = BinarySearch(list, nums[i]);
            list.add(pos, nums[i]);
        }
        res[0] = ((double) list.get((k - 1) / 2) + (double) list.get(k / 2)) / 2.0;

        for (int end = k; end < nums.length; end++) {
            // 使用二分查找找到需要删除数字的下标并删除
            index = BinarySearch(list, nums[end - k]);
            list.remove(index);//删除旧元素
            // 使用二分查找找到最佳插入点
            pos = BinarySearch(list, nums[end]);
            list.add(pos, nums[end]);
            res[end + 1 - k] = ((double) list.get((k - 1) / 2) + (double) list.get(k / 2)) / 2.0;//奇偶通用
        }

        return res;
    }

    // 使用二分查找寻找下标
    private int BinarySearch(List<Integer> data, int target) {
        int l = 0, r = data.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (data.get(m) > target)
                r = m - 1;
            else if (data.get(m) < target)
                l = m + 1;
            else
                return m;
        }
        return l;
    }
    //优先队列（堆）
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public double[] medianSlidingWindow(int[] nums, int k) {
        int m = nums.length;
        int n = m - k + 1;
        double[] res = new double[n];
        for(int i = 0; i < k; i++){
            add(nums[i]);
        }
        for(int i = 0; i < n; i++){
            res[i] = getMedium();
            if(i + k < m){
                remove(nums[i]);
                add(nums[i+k]);
            }
        }
        return res;
    }

    void add(int num){
        if(num < getMedium()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    void remove(int num){
        if(num < getMedium()){
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }
        if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    double getMedium(){
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            return 0;
        }
        if(maxHeap.size() == minHeap.size()){
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0;
        }else{
            return (double)minHeap.peek();
        }
    }
}
