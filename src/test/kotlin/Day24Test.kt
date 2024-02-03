import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day24Test{
    val day = Day24()

    @Test
    fun testSimpleExamples(){
        val examples =
            "19, 13, 30 @ -2,  1, -2\n"+
            "18, 19, 22 @ -1, -1, -2\n"+
            "20, 25, 34 @ -2, -2, -4\n"+
            "12, 31, 28 @ -1, -2, -1\n"+
            "20, 19, 15 @  1, -5, -3"

        day.mode = SolutionMode.OneStar
        day.testArea = Pair(7.0, 27.0)
        day.solve(examples)

        assertEquals(2, day.solutionOneStar)
    }
}