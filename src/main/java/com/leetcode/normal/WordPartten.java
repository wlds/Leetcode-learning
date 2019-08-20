package com.leetcode.normal;

import java.util.HashMap;

/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * <p>
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 */

public class WordPartten {
    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) { //不包含
                // 判断值
                if (map.containsValue(strs[i])){
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            } else {
                if (!strs[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }

}
