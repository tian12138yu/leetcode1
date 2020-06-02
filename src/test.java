import com.leetcode.TreeNode;
import com.leetcode.code105;
import com.leetcode.code114;
import com.leetcode.code3;
import com.offer.PathOfTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author tjy
 * @Date 2020/4/8 20:54
 */

public class test {

    public static void main(String[] args) {
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
        System.out.println(new code3().lengthOfLongestSubstring("cdd"));


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
}
