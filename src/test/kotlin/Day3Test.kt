import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.StringBuilder

internal class Day3Test{
    val day = Day3()

    @Test
    fun testAllSides(){
        var example = ".....\n.123.\n.....\n"

        for(i in 0..2){
            for(k in 0..5){
                if(!example[i*6+k].isDigit() && example[i*6+k] != '\n'){
                    var input = StringBuilder(example)
                    input.setCharAt(i*6+k, '-')
                    val test = input.toString()
                    day.solve(test)
                    assertEquals(123, day.solutionOneStar, "Test failed at $i row and $k line")
                }
            }
        }
    }

    @Test
    fun testExample(){
        val excample = "467..114..\n" +
                "...*......\n" +
                "..35..633.\n" +
                "......#...\n" +
                "617*......\n" +
                ".....+.58.\n" +
                "..592.....\n" +
                "......755.\n" +
                "...\$.*....\n" +
                ".664.598.."

        day.solve(excample)

        assertEquals(4361, day.solutionOneStar)
    }
}