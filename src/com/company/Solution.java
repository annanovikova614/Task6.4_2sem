package com.company;

import java.util.*;

public class Solution {
    public static List<String> solve(String text, int N) {
        Map<String, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (map.get(word) == null)
                map.put(word, 1);
            else
                map.put(word, map.get(word) + 1);
        }
        List<String> result = new LinkedList<>();
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static List<String> mySolve(String text, int N) {
        MyTreeMap<String, Integer> map = new MyTreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()){
            String word = scanner.next();
            if (map.get(word) == null)
                map.put(word, 1);
            else
                map.put(word, map.get(word) + 1);
        }
        List<String> result = new LinkedList<>();
        for (Pair<String,Integer> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}