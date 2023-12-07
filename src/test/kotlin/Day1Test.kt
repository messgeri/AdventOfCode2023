import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day1Test{
    private val day = Day1()

    @Test
    fun TestParseLine(){
        val examples = arrayOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")
        var results = ArrayList<Long>(4 )

        examples.forEach {
            results.add(day.ParseLine(it))
        }

        assertEquals(results[0], 12)
        assertEquals(results[1], 38)
        assertEquals(results[2], 15)
        assertEquals(results[3], 77)
    }

    @Test
    fun TestParseText(){
        val example = "1abc2\n" +
                "pqr3stu8vwx\n" +
                "a1b2c3d4e5f\n" +
                "treb7uchet"

        val result = day.ParseText(example)

        assertEquals(result, 142)
    }
}