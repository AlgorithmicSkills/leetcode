package com.antonromanov.algorithms.some.easy.justoneoperationstringswap;

import java.util.*;

public class JustOneOperationStringSwap {



    public static String toLowerCase(String s) {
        char[] ch = s.toCharArray();
        int l = s.length();

        for (int i=0; i<l; i++){
            if (ch[i]>= 'A' && ch[i]<='Z' ){
                int v = ch[i];
                v = v+32;
                ch[i] =  (char) v;
            }
        }

        return String.valueOf(ch);
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        char[] arr = s1.toCharArray();
        char[] arr1 = s2.toCharArray();

      /*  Arrays.sort(arr);
        Arrays.sort(arr1);*/

        HashSet<String> posDict = new HashSet<>();

        Integer pos1 = 0;
        Integer pos2 = 0;

        if (s1.equals(s2)) {
            return true;
        }

        for (int i=0; i<arr.length;i++){
            if(arr[i] != arr1[i]){
                pos1 = i;
                break;
            }
        }

        for (int i=arr.length-1; i>=0;i--){
            if(arr[i] != arr1[i]){
                pos2 = i;
                break;
            }
        }

        s2 = swap(s2, pos1, pos2);
        return s1.equals(s2);


        /*while ((pos1 != null) || (pos2 != null)) {

            System.out.println("Swap " + pos1 + " and " + pos2);
            char[] arrCopy = arr.clone();
            char swappedChar = arrCopy[pos1];
            arrCopy[pos1] = arrCopy[pos2];
            arrCopy[pos2] = swappedChar;

            if (s1.equals(String.valueOf(arrCopy))) {
                return true;
            }

            Map<Integer, Integer> map = getCoord2(posDict, arr, s1);

            if (map == null) {
                pos1 = null;
                pos2 = null;
            } else {
                pos1 = (new ArrayList<>(map.entrySet())).get(0).getKey();
                pos2 = (new ArrayList<>(map.entrySet())).get(0).getValue();
            }
        }*/

     //   return false;
    }

    public static String swap(String s1, Integer pos1, Integer pos2) {
        System.out.println("Swap " + pos1 + " and " + pos2);
        char[] arrLoc = s1.toCharArray();
        char[] arrCopy = arrLoc.clone();
        char swappedChar = arrCopy[pos1];
        arrCopy[pos1] = arrCopy[pos2];
        arrCopy[pos2] = swappedChar;
        return String.valueOf(arrCopy);
    }

    public static Map<Integer, Integer> getCoord2(HashSet<String> posTable, char[] arr, String s1) {

        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (s1.indexOf(arr[j]) < 0) {
                    return null;
                }

                String habrahabr = new StringBuilder().append(i).append(j).toString();

                if (!posTable.contains(habrahabr)) {
                    posTable.add(habrahabr);
                    res.put(i, j);
                    return res;
                }
            }
        }
        return null;
    }
}
