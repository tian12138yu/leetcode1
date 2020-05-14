package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/14 12:53
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。

 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 */
public class code901 {

    class gupiao{
        int price;
        int count;

        public gupiao(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    List<gupiao> al;
    public code901() {
         al = new ArrayList<>();
    }

    public int next(int price) {
        int count = 1;
        for (int i = al.size()-1; i >= 0; i--) {
            if (price < al.get(i).price)break;
            count += al.get(i).count;
            i -= al.get(i).count-1;

        }
        al.add(new gupiao(price,count));
        return count;
    }
    //["StockSpanner","next","next","next","next","next","next","next"]
    //[[],[100],[80],[60],[70],[60],[75],[85]]
    public static void main(String[] args) {
        code901 a = new code901();
        System.out.println(a.next(100));
        System.out.println(a.next(80));
        System.out.println(a.next(60));
        System.out.println(a.next(70));
        System.out.println(a.next(60));
        System.out.println(a.next(75));
        System.out.println(a.next(85));


    }
}
