package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/19 20:49
 */

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 */
public class code606 {

    public void tree2strChild(TreeNode t,StringBuffer sb) {
        if(t == null) return;
        sb.append(t.val);

        if( t.left == null ) {

            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else {
            //( -> 递归 -> )
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }

    }

    /**
     *无法提前知道左右是否同时为空。错误解答。
     * @param t
     * @param sb
     * @return
     */
    public TreeNode tree2strChild1(TreeNode t,StringBuffer sb) {
        if (t == null)return null;
        sb.append("(");
        sb.append(t.val);
        TreeNode left = tree2strChild1(t.left, sb);
        if (left != null)
            sb.append(")");
        TreeNode right = tree2strChild1(t.right, sb);
        if (right != null)
            sb.append(")");
        if (left == null && right != null){
            sb.append("()");
            sb.append(")");
        }
        return t;
    }

    public String tree2str(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        if (t != null)sb.append(t.val);
        TreeNode left = tree2strChild1(t.left, sb);
        if (left != null)sb.append(")");
        TreeNode right = tree2strChild1(t.right, sb);
        if (right != null)sb.append(")");
        return sb.toString();
    }
}
