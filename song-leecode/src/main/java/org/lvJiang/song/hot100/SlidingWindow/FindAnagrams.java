package org.lvJiang.song.hot100.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAnagrams {

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] scount = new int[26];
        int[] pcount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++pcount[p.charAt(i) - 'a'];
            ++scount[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(scount,pcount)) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            --scount[s.charAt(i) - 'a'];
            ++scount[s.charAt(i+p.length()) - 'a'];

            if (Arrays.equals(scount, pcount)) {
                res.add(i+1);
            }

        }
        return res;
    }
}
