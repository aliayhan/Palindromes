package com.goodcompany.parser;

import com.goodcompany.domain.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromeParser {

    public List<Palindrome> getAllPalindromesOf(String text) {

        boolean isTextIsEmpty = text == null || text.isEmpty();
        if (isTextIsEmpty) {
            return new ArrayList<>();
        }

        boolean isTextShorterLengthTwo = text.length() < 2;
        if (isTextShorterLengthTwo) {
            return new ArrayList<>();
        }

        List<Palindrome> palindromes = new ArrayList<>();
        for (int i = 0; i < text.length() - 1; i++) {

            boolean isIndexAndFollowingCharSame = text.charAt(i) == text.charAt(i + 1);
            if (isIndexAndFollowingCharSame) {
                palindromes.add(parseFullPalindromeAtFrom(i, text));
            }
        }

        return palindromes;
    }

    private Palindrome parseFullPalindromeAtFrom(int index, String text) {

        int palindromeIndex = index;
        int palindromeLength = 2;

        for (int i = index - 1, j = index + 2; i >= 0 && j < text.length(); i--, j++) {

            boolean isIndexIAndIndexJCharSame = text.charAt(i) == text.charAt(j);
            if (isIndexIAndIndexJCharSame) {
                palindromeIndex = i;
                palindromeLength += 2;
            } else {
                break;
            }
        }

        String palindrome = text.substring(palindromeIndex, palindromeIndex + palindromeLength);
        return new Palindrome(palindrome, palindromeIndex, palindromeLength);
    }
}
