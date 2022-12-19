package com.antonromanov.algorithms.hashtable.validanagramNOTSOLVED;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        char[] charArray = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        if (charArray.length!=charArray2.length){
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.containsKey(String.valueOf(c))) {
            map.put(String.valueOf(c), map.get(String.valueOf(c))+1);
            } else {
                map.put(String.valueOf(c), 1);
            }
        }
        Boolean res = null;
        for (char c : charArray2) {
            if (map.containsKey(String.valueOf(c))) {
                Integer count = map.get(String.valueOf(c));
                if (count>1) {
                    map.put(String.valueOf(c), map.get(String.valueOf(c))-1);
                } else{
                    map.remove(String.valueOf(c));
                }
                res = true;
            } else {
                return false;
            }
        }

        return res;
    }

    public static boolean isAnagram2(String s, String t) {

        int[] chars = new int[26];

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
}
