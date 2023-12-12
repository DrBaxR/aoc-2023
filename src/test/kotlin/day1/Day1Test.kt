package day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import processText

class Day1Test {

    @Test
    fun test1() {
        assertEquals(12, processText("1abc2"))
    }

    @Test
    fun test2() {
        assertEquals(38, processText("pqr3stu8vwx"))
    }

    @Test
    fun test3() {
        assertEquals(15, processText("a1b2c3d4e5f"))
    }

    @Test
    fun test4() {
        assertEquals(77, processText("treb7uchet"))
    }

    @Test
    fun test5() {
        assertEquals(29, processText("two1nine"))
    }

    @Test
    fun test6() {
        assertEquals(83, processText("eightwothree"))
    }

    @Test
    fun test7() {
        assertEquals(13, processText("abcone2threexyz"))
    }

    @Test
    fun test8() {
        assertEquals(24, processText("xtwone3four"))
    }

    @Test
    fun test9() {
        assertEquals(42, processText("4nineeightseven2"))
    }

    @Test
    fun test10() {
        assertEquals(14, processText("zoneight234"))
    }

    @Test
    fun test11() {
        assertEquals(76, processText("7pqrstsixteen"))
    }
}