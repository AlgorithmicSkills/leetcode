package com.antonromanov.algorithms.hashtable.grouppedanagrams;

import java.util.*;

public class GroupedAnagrams {

    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
           String tempString = strs[i];
           String sortedKey = sortKey(tempString);

            if (map.containsKey(sortedKey)) {
                List<String> ig = map.get(sortKey(strs[i]));
                ig.add(tempString);
            } else {
                List<String> l = new ArrayList<>();
                Collections.addAll(l, tempString);
                map.put((sortKey(strs[i])), l);
            }
        }

        result = new ArrayList<>(map.values());
        return result;
    }

    private static String sortKey(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.copyValueOf(charArray);
    }
}
