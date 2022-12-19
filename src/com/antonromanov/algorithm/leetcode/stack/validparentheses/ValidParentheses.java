package com.antonromanov.algorithms.stack.validparentheses;

import java.util.*;

public class ValidParentheses {


    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                char top = stack.peek();
                if (isMatch(top, ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') ||
                (ch1 == '{' && ch2 == '}');

    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        boolean res = false;
        int i = 0;
        while (i < charArray.length) {
            int chr = charArray[i];
            Pthss sP = Pthss.searchByOpen(chr); // ищем открывающую скобку и вообще ищем группы скобок
            if (sP != Pthss.NONE) {
                if (i == charArray.length - 1) return false;
                for (int j = i + 1; j < charArray.length; j++) { // теперь ищем закрывающую
                    int chrOpn = charArray[j];
                    if (sP == Pthss.searchByClose(chrOpn)) {
                        res = searchInGroup(charArray, i, j);
                        i = j;
                        break;
                    }
                }
                if (!res) return false;
            } else {
                return false;
            }
            i++;
        }
        return res;
    }


    public static boolean searchInGroup(char[] charArray, int start, int end) {
        int x = start;
        int y = end;
        if ((1+(start+end))%2!=0) return false;
        while (x < y) {
            int chrS = charArray[x];
            int chrE = charArray[y];
            if (Pthss.searchByOpen(chrS) == Pthss.NONE) {
                return false;
            } else {
                if (Pthss.searchByOpen(chrS) == Pthss.searchByClose(chrE)) {
                    x = x + 1;
                    y = y - 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public enum Pthss {
        FORTY(40, 41), NINGHTY(91, 93), HUNDRID(123, 125), NONE(0, 0);

        Pthss(Integer open, Integer close) {
            this.close = close;
            this.open = open;
        }

        final Integer open;
        final Integer close;

        public static Pthss searchByOpen(Integer val) {
            return Arrays.stream(Pthss.values())
                    .filter(e -> Objects.equals(e.open, val))
                    .findFirst()
                    .orElse(NONE);
        }

        public static Pthss searchByClose(Integer val) {
            return Arrays.stream(Pthss.values())
                    .filter(e -> Objects.equals(e.close, val))
                    .findFirst()
                    .orElse(NONE);
        }
    }
}


