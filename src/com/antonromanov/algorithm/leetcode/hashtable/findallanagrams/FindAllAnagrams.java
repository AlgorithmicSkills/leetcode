package com.antonromanov.algorithms.hashtable.findallanagrams;

import java.util.*;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        for (int i = 0; i < s.length()-p.length()+1; i++) {
            if (checkArray2(s.substring(i, i + p.length()), p)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void recalculateArray(int[] chars, char leftChar, char rightChar) {
        int lc = leftChar - 'a';
        int rc = rightChar - 'a';
        chars[lc]--;
        chars[rc]++;
    }

    public static int[] startSum(String s, int start, int end) {
        int[] chars = new int[26];

        String ss = s.substring(start, end);
        for (char current : ss.toCharArray()) {
            int z = current - 'a';
            chars[z]++;
        }
        return chars;
    }

    public static boolean checkArray(int[] chars, String t) {
        int[] localArr = chars.clone();
        for (char current : t.toCharArray()) {
            localArr[current - 'a']--;
        }

        for (int current : chars) {
            if (current != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkArray2(String s, String t) {
        int[] chars = new int[26];

        //String ss = s.substring(start, end);
        for (char current : s.toCharArray()) {
            int z = current - 'a';
            chars[z]++;
        }

        for (char current : t.toCharArray()) {
            chars[current - 'a']--;
        }

        for (int current : chars) {
            if (current != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        char[] charArray = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        if (charArray.length != charArray2.length) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.containsKey(String.valueOf(c))) {
                map.put(String.valueOf(c), map.get(String.valueOf(c)) + 1);
            } else {
                map.put(String.valueOf(c), 1);
            }
        }
        Boolean res = null;
        for (char c : charArray2) {
            if (map.containsKey(String.valueOf(c))) {
                Integer count = map.get(String.valueOf(c));
                if (count > 1) {
                    map.put(String.valueOf(c), map.get(String.valueOf(c)) - 1);
                } else {
                    map.remove(String.valueOf(c));
                }
                res = true;
            } else {
                return false;
            }
        }

        return res;
    }
}
