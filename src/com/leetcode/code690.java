package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/12 14:53
 */

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 示例 1:
 *
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 */
public class code690 {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id,e);
        }
        int count = 0;
        Queue<Integer> list = new LinkedList<>();
        list.add(id);
        while ( !list.isEmpty() ){
            int id1 = list.poll();
            Employee e = map.get(id1);
            count += e.importance;
            if (e.subordinates.isEmpty())continue;
            for (int x : e.subordinates) {
                list.add(x);
            }
        }

        return count;
    }
    //[[1,5,[2,3]],[2,3,[]],[3,3,[]]]
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(3);
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        employees.add(new Employee(1,5,al));
        employees.add(new Employee(2,3,al1));
        employees.add(new Employee(3,3,al2));

        System.out.println(getImportance(employees, 1));
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
