package com.platzi.javatests.roman;

public class RomanNumerals {
    public static String arabicToRoman(int n) {
        if (n == 1) {
            return "I";
        }
        if (n > 1 && n < 4) {
            return "I" + arabicToRoman(n - 1);
        }
        if (n == 4) {
            return "IV";
        }
        if (n == 5) {
            return "V";
        }
        if (n > 5 && n < 9) {
            return "V" + arabicToRoman(n - 5);
        }
        if (n == 9) {
            return "IX";
        }
        if (n == 10) {
            return "X";
        }
        if (n > 10 && n < 40) {
            return "X" + arabicToRoman(n - 10);
        }
        if (n == 40) {
            return "XL";
        }
        if (n > 40 && n < 50) {
            return "XL" + arabicToRoman(n - 40);
        }
        if (n == 50) {
            return "L";
        }
        if (n > 50 && n < 90) {
            return "L" + arabicToRoman(n - 50);
        }
        if (n == 90) {
            return "XC";
        }
        if (n > 90 && n < 100) {
            return "XC" + arabicToRoman(n - 90);
        }
        if (n == 100) {
            return "C";
        }
        if (n > 100 && n < 400) {
            return "C" + arabicToRoman(n - 100);
        }
        if (n == 400) {
            return "CD";
        }
        if (n > 400 && n < 500) {
            return "CD" + arabicToRoman(n - 400);
        }
        if (n == 500) {
            return "D";
        }
        if (n > 500 && n < 900) {
            return "D" + arabicToRoman(n - 500);
        }
        if (n == 900) {
            return "CM";
        }
        if (n > 900 && n < 1000) {
            return "CM" + arabicToRoman(n - 900);
        }
        if (n == 1000) {
            return "M";
        }
        if (n > 1000) {
            return "M" + arabicToRoman(n - 1000);
        }
        return null;
    }
}
