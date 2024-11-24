package org.strategy_pattent;

public class Palindrome {

    public static boolean isPalindrome(String original) {
        // do not forger about corner cases todo
        String cleaned = prepareString(original); // just remove not legitimate characters like 0-1, ;.!
        StringBuilder reversed = new StringBuilder(cleaned).reverse();

        return reversed.toString().equals(cleaned);
    }

    public static String prepareString(String original) {
        return original
            .toLowerCase()
            .replaceAll("[^a-z]", "");
    }

    public static boolean testSum(int in) {
        int res = 0;
        while (in > 0) {
            res += in % 10;
            in = in / 10;
        }
        return res < 10;
    }

}
