package com.goodcompany.parser;

import com.goodcompany.domain.Palindrome;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PalindromeParserTest {

    private static PalindromeParser parser;

    @BeforeClass
    public static void setup() {
        parser = new PalindromeParser();
    }

    @Test
    public void getAllPalindromesOfNullTest() {
        assertThat(parser.getAllPalindromesOf(null), hasSize(0));
    }

    @Test
    public void getAllPalindromesOfEmptyTest() {
        assertThat(parser.getAllPalindromesOf(EMPTY), hasSize(0));
    }

    @Test
    public void getAllPalindromesOfNoPalindromesStringTest() {
        assertThat(parser.getAllPalindromesOf("ab"), hasSize(0));
    }

    @Test
    public void getAllPalindromesOfOnePalindromeStringTest() {

        String testString = "aa";
        Palindrome testPalindrome = new Palindrome("aa", 0, 2);
        assertThat(parser.getAllPalindromesOf(testString), contains(testPalindrome));
    }

    @Test
    public void getAllPalindromesOfTwoPalindromeStringSameSizeTest() {

        String testString = "aabb";
        Palindrome testPalindrome1 = new Palindrome("aa", 0, 2);
        Palindrome testPalindrome2 = new Palindrome("bb", 2, 2);
        assertThat(parser.getAllPalindromesOf(testString), hasItems(testPalindrome1, testPalindrome2));
    }

    @Test
    public void getAllPalindromesOfTwoPalindromeStringDifferentSizeTest() {

        String testString = "aabbbb";
        Palindrome testPalindrome1 = new Palindrome("aa", 0, 2);
        Palindrome testPalindrome2 = new Palindrome("bbbb", 2, 4);
        assertThat(parser.getAllPalindromesOf(testString), hasItems(testPalindrome1, testPalindrome2));
    }

    @Test
    public void getAllPalindromesOfTwoPalindromeStringOnThreeCharsTest() {

        String testString = "aaa";
        Palindrome testPalindrome1 = new Palindrome("aa", 0, 2);
        Palindrome testPalindrome2 = new Palindrome("aa", 1, 2);
        assertThat(parser.getAllPalindromesOf(testString), hasItems(testPalindrome1, testPalindrome2));
    }
}
