package org.graph;

import java.util.*;

// Time complexity - O(N*26*word size)
// Space Complexity - O(N)
public class WordLadderBFS {
    public static void main(String[] s) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };
        int ans = wordLadderLength(startWord, targetWord, wordList);
        System.out.print(ans);
        System.out.println();
    }


    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>();
        // add to wordSet
        Collections.addAll(wordSet, wordList);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));
        wordSet.remove(startWord);
        System.out.println(startWord + ":::" + targetWord);
        // check the queue
        while (!queue.isEmpty()) {
            String curWord = queue.peek().word;
            int curSteps = queue.peek().steps;
            System.out.println(curWord + ":" + curSteps);
            queue.poll();
            // if the word popped from queue is target word, we reached target. So return shortest path
            if (curWord.equals(targetWord)) {
                return curSteps;
            }
            // modify each character in the word to one of a-z to see if its in wordsList for the length of word
            for (int i = 0; i < curWord.length(); i++) {
                char[] words = curWord.toCharArray();
                for (char ch = 'a'; ch < 'z'; ch++) {
                    words[i] = ch;
                    String newWord = new String(words);
                    // if there is a word in wordsList, remove it from Set and add it to queue,
                    // this is to avoid going back to same word
                    if (wordSet.contains(newWord)) {
                        System.out.println("newWord:::" + newWord);
                        wordSet.remove(newWord);
                        queue.add(new Pair(newWord, curSteps + 1));
                    }
                }
            }
        }
        return 0;
    }

    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}
