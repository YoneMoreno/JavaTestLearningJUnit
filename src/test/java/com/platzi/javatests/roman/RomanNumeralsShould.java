package com.platzi.javatests.roman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsShould {

    @Test
    public void returnIWhen1IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
    }

    @Test
    public void returnIIWhen2IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
    }

    @Test
    public void returnIIIWhen3IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void returnVWhen5IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
    }

    @Test
    public void returnVIWhen6IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
    }

    @Test
    public void returnVIIWhen7IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
    }

    @Test
    public void returnXWhen10IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }

    @Test
    public void returnXIWhen11IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
    }

    @Test
    public void returnXVWhen15IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
    }

    @Test
    public void returnXVIWhen16IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
    }

    @Test
    public void returnLWhen50IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }

    @Test
    public void returnLIWhen51IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
    }

    @Test
    public void returnLVWhen55IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(55), is("LV"));
    }

    @Test
    public void returnLVIWhen56IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
    }

    @Test
    public void returnLXWhen60IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
    }

    @Test
    public void returnLXXWhen70IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
    }

    @Test
    public void returnLXXXWhen80IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
    }

    @Test
    public void returnLXXXVIWhen86IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
    }

    @Test
    public void returnCXXVIWhen126IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void returnDVWhen505IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(505), is("DV"));
    }

    @Test
    public void returnMMDVIIWhen2507IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void returnMMDLVIWhen2556IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(2556), is("MMDLVI"));
    }

    @Test
    public void returnIVWhen4IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(4), is("IV"));
    }

    @Test
    public void returnIXWhen9IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(9), is("IX"));
    }

    @Test
    public void returnXIVWhen14IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(14), is("XIV"));
    }

    @Test
    public void returnXIXWhen19IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(19), is("XIX"));
    }

    @Test
    public void returnXXIVXWhen24IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(24), is("XXIV"));
    }

    @Test
    public void returnXLWhen40IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(40), is("XL"));
    }

    @Test
    public void returnXLIIWhen42IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(42), is("XLII"));
    }

    @Test
    public void returnXLIXWhen49IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(49), is("XLIX"));
    }

    @Test
    public void returnXCWhen90IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(90), is("XC"));
    }

    @Test
    public void returnXCIXWhen99IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(99), is("XCIX"));
    }

    @Test
    public void returnCDWhen400IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(400), is("CD"));
    }

    @Test
    public void returnCDLVIIWhen457IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(457), is("CDLVII"));
    }

    @Test
    public void returnCMWhen900IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(900), is("CM"));
    }

    @Test
    public void returnCMLIXWhen959IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(959), is("CMLIX"));
    }

    @Test
    public void returnMMMMCMXCIXWhen4999IsGiven() {
        assertThat(RomanNumerals.arabicToRoman(4999), is("MMMMCMXCIX"));
    }

}