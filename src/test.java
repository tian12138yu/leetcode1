import com.leetcode.*;
import com.offer.PathOfTree;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/4/8 20:54
 */

public class test {

    public static void main1(String[] args) {
//        int a=Integer.MAX_VALUE+1;
////        byte b=20;
////        byte c=10;
//////        byte d=b+c;小于四个字节的进行运算时，会先提升到INT进行运算。
//////        System.out.println(b+c);
//        int[] a={1,5,2,5,3};
//        String s = myToString(a);
//        System.out.println(s);
        //10,5,12,4,7
//        TreeNode root = new TreeNode(10);
//        TreeNode root1 = new TreeNode(5);
//        TreeNode root2 = new TreeNode(12);
//        TreeNode root3 = new TreeNode(4);
//        TreeNode root4 = new TreeNode(7);
//        root.left = root1;
//        root.right = root2;
//        root1.left = root3;
//        root1.right = root4;
//
//
//        ArrayList<ArrayList<Integer>> arrayLists = new PathOfTree().FindPath(root, 22);
//        System.out.println(arrayLists);
//        char c = ' ';
//        char a = 'a';
//        int a1 = c ^ a;
//        char c1 = ('A' + 32);
//        System.out.println(c1);
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(-11.5));
//        System.out.println(new code3().lengthOfLongestSubstring("cdd"));
//        String[] a = {};
//        System.out.println(new code819().mostCommonWord("Bob", a));
        int[] a = {1,2,3,4};
        System.out.println(new code949().largestTimeFromDigits(a));

    }

    public static void main2(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        List<List<Integer>> als = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);

        }
        for (int i = 9; i >= 0; i--) {
            integers1.add(i);
        }
        als.add(integers);
        Collections.sort(integers1);

        System.out.println(als.contains(integers1));
    }

    static void preOrderTraversal(TreeNode root){
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static String myToString(int[] arr){
        String s="";
        for(int i=0;i < arr.length; i++){
            if (i == 0)s=s+"["+String.valueOf(arr[0]);
            if (i == arr.length-1)s=s+String.valueOf(arr[arr.length-1])+"]";
            else{
                s+=String.valueOf(arr[i])+",";
            }

        }
        return s;
    }

    public static int Fibonacci(int n) {
        if(n==1||n==2)return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static int[] arrayCopy(int[] array){
        int[] copy=new int[array.length];
        for (int x=0;x < array.length; x++){
            copy[x]=array[x];
        }
        return copy;
    }

    public static int findMax(int[] array){
        int max=0;
        for (int x =0;x <array.length; x++){
            max=Math.max(max,array[x]);
        }
        return max;

    }

    public static void main(String[] args) {
        boolean a = false;
        String s = "";
        try {
            s = "+";
            System.out.println(Integer.parseInt(s));
        }catch (NumberFormatException e ){
            a = true;
        }finally {
            if (a){
                if (s.charAt(0) == '-'){
                    System.out.println(Integer.MIN_VALUE);
                }else {
                    System.out.println(Integer.MAX_VALUE);
                }
            }
        }
//        System.out.println(Integer.parseInt(s));
    }
}
