package com.platzi.javatests.util;

import com.platzi.javatests.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void testRepeatStringOne(){
        assertEquals("hola", StringUtil.repeat("hola",1));
    }
    @Test
    public void testRepeatStringMultipleTimes(){
        assertEquals("holaholahola",StringUtil.repeat("hola",3));
    }
    @Test
    public void testRepeatStringZeroTimes(){
        assertEquals("",StringUtil.repeat("hola",0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRepeatStringNegativeTimes(){
        StringUtil.repeat("hola",-1);
    }

    @Test
    public void testStringIsNotEmpty(){
        assertFalse(StringUtil.isEmpty("hello"));
    }
    @Test
    public void testVoidStringIsEmpty(){
        assertTrue(StringUtil.isEmpty(""));
    }
    @Test
    public void testNullIsEmpty(){
        assertTrue(StringUtil.isEmpty(null));
    }
    @Test
    public void testStringWithOnlySpacesIsEmpty(){
        assertTrue(StringUtil.isEmpty("    "));
    }
}