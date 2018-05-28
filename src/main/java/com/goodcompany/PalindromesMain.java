package com.goodcompany;

import com.goodcompany.domain.Palindrome;
import com.goodcompany.parser.PalindromeParser;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;
import static org.apache.commons.lang3.StringUtils.join;

public class PalindromesMain {

    public static void main(String[] args) {

        System.out.println("\nPalindrome Scanner");
        System.out.println("==================");

        boolean isArgsEmpty = args.length == 0;
        if (isArgsEmpty) {
            System.out.println("Please provide a text as the application's first parameter to scan for palindromes\n");
            return;
        }

        String text = args[0];
        List<Palindrome> palindromes = new PalindromeParser().getAllPalindromesOf(text);

        printOutBiggestThreeOf(palindromes);
    }

    private static void printOutBiggestThreeOf(List<Palindrome> palindromes) {

        boolean noPalindromesFound = palindromes.size() == 0;
        if (noPalindromesFound) {
            System.out.println("No palindromes found");
            return;
        }

        sort(palindromes, PalindromeLengthComparatorDesc);

        for (int i = 0; i < palindromes.size() && i < 3; i++) {
            Palindrome palindrome = palindromes.get(i);
            System.out.println(join("Text: ", palindrome.getText(),", Index: ",palindrome.getIndex(),", Length: ", palindrome.getLength()));
        }
    }

    private static Comparator<Palindrome> PalindromeLengthComparatorDesc = (o1, o2) -> {

        boolean isO1GivenAndO2Empty = o1 != null && o2 == null;
        if (isO1GivenAndO2Empty) {
            return 1;
        }

        boolean isO1EmptyAndO2Given = o1 == null && o2 != null;
        if (isO1EmptyAndO2Given) {
            return -1;
        }

        boolean isO1EmptyAndO2Emptry = o1 == null && o2 == null;
        if (isO1EmptyAndO2Emptry) {
            return 0;
        }

        if (o1.getLength() < o2.getLength()) {
            return 1;
        } else if (o1.getLength() == o2.getLength()) {
            return 0;
        } else {
            return -1;
        }
    };
}
