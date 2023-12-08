import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.text.StringBuilder

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
        day.mode = SolutionMode.OneStar
        val example = "467..114..\n" +
                "...*......\n" +
                "..35..633.\n" +
                "......#...\n" +
                "617*......\n" +
                ".....+.58.\n" +
                "..592.....\n" +
                "......755.\n" +
                "...\$.*....\n" +
                ".664.598.."

        day.solve(example)

        assertEquals(4361, day.solutionOneStar)
    }

    @Test
    fun testTwoStar(){
        val example = "467..114..\n" +
                "...*......\n" +
                "..35..633.\n" +
                "......#...\n" +
                "617*......\n" +
                ".....+.58.\n" +
                "..592.....\n" +
                "......755.\n" +
                "...\$.*....\n" +
                ".664.598..\n"

        day.mode = SolutionMode.TwoStar
        day.solve(example)

        assertEquals(467835, day.solutionTwoStar)
    }

    @Test
    fun testAllGearSides(){
        var startGrid = "...\n.*.\n...\n"
        day.mode = SolutionMode.TwoStar

        for(i in 0..11){
            for(k in 0..11){
                var example = StringBuilder(startGrid)
                val rowI = i / 4
                val colI = i - rowI * 4
                val rowK = k / 4
                val colK = k - rowK * 4
                if(example[i] == '.' && example[k] == '.' && (i!=k)
                    && !(rowI == rowK && abs(colI - colK) == 1)
                    && !(colI == colK && abs(rowI - rowK) == 1)
                ){
                    example.setCharAt(i, '5')
                    example.setCharAt(k, '5')
                    val input = example.toString()
                    day.solve(input)
                    assertEquals(25, day.solutionTwoStar, "All gear test failed at $i, $k")
                }
            }
        }
    }
}