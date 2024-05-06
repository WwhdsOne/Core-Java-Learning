package Test;/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start

import com.sun.jdi.IntegerValue;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][]nums = {{1,3},{2,6},{8,10},{15,18}};
        String path = "/a/./b/../../c/";
        //String path = "/home/";
        //String path = "/home//foo/";
        String s = solution.simplifyPath(path);
        System.out.println(s);

    }

    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        for ( String s : path.split("/") ) {
            if(s.equals("..")){
                if(!stk.isEmpty()){
                    stk.pop();
                }
            } else if ( !s.isEmpty() && !s.equals(".") ) {
                stk.push(s);
            }
        }
        String reduce = stk.stream().reduce("", (a, b) -> a + "/" + b);
        return reduce.isEmpty() ? "/" : reduce;
    }
}
// @lc code=end

