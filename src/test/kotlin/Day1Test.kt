import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day1Test{
    private val day = Day1()

    @Test
    fun testParseLine(){
        val examples = arrayOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")
        var results = ArrayList<Int>(4 )

        examples.forEach {
            results.add(day.parseLine(it))
        }

        assertEquals(results[0], 12)
        assertEquals(results[1], 38)
        assertEquals(results[2], 15)
        assertEquals(results[3], 77)
    }

    @Test
    fun testParseText(){
        val example = "1abc2\n" +
                "pqr3stu8vwx\n" +
                "a1b2c3d4e5f\n" +
                "treb7uchet"

        val result = day.parseText(example)

        assertEquals(result, 142)
    }

    @Test
    fun testParseWrittenNumbers(){
        val examples = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var results = ArrayList<Int>(9)

        examples.forEach {
            results.add(day.parseLine(it))
        }

        for (i in 0..8){
            assertEquals((i + 1)*10 + i+1, results[i])
        }
    }

    @Test
    fun testParseTextWithWrittenNumbers(){
        val example = "two1nine\n" +
                "eightwothree\n" +
                "abcone2threexyz\n" +
                "xtwone3four\n" +
                "4nineeightseven2\n" +
                "zoneight234\n" +
                "7pqrstsixteen"

        val result = day.parseText(example)

        assertEquals(result, 281)
    }

    @Test
    fun testStartWithEndCases(){
        val examples = arrayOf("nineight", "threeight", "fiveight", "oneight", "twone", "eighthree", "eightwo", "sevenine", "threight")
        var results = arrayListOf<Int>()

        examples.forEach {
            results.add(day.parseLine(it))
        }

        assertEquals(98, results[0])
        assertEquals(38, results[1])
        assertEquals(58, results[2])
        assertEquals(18, results[3])
        assertEquals(21, results[4])
        assertEquals(83, results[5])
        assertEquals(82, results[6])
        assertEquals(79, results[7])
        assertEquals(88, results[8])
    }
}