package com.xzy.leetcode_hot;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class xzy_11_239 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow2(arr, k)));
    }

    //暴力
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        //剪枝
        if (k < 2) {
            return nums;
        }
        //剪枝
        if (nums.length <= k) {
            Arrays.sort(nums);
            int[] ans = new int[1];
            ans[0] = nums[nums.length - 1];
            return ans;
        }

        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int index = 0;

        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < k + i; j++) {
                //遍历小区间的最大值
                while (j < k + i && j < nums.length) {
                    if (nums[j] > max) {
                        max = nums[j];
                    } else {
                        j++;
                    }
                }
                res[index] = max;
                max = Integer.MIN_VALUE;
                index++;
                if (index == nums.length - k + 1) {
                    return res;
                }
            }
        }

        return res;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;

        //自定义队列
        MyQueue myQueue = new MyQueue();

        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }

        res[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }

    //解法一
    //自定义双端队列（单调递减）
    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }
}
