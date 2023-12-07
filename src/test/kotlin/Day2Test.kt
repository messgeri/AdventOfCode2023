import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test{
    private val day = Day2()

    @Test
    fun testParseRound(){
        val example = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

        val result = day.parseRound(example)

        assertEquals(3, result.size)
        //Red
        assertEquals(2, result[0].size)
        //Green
        assertEquals(2, result[0].size)
        //Blue
        assertEquals(2, result[0].size)
    }

    fun testExample1Star(){
        val example = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"

        day.mode = SolutionMode.OneStar
        day.solve(example)

        assertEquals(8L, day.solutionOneStar)
    }

    @Test
    fun testExample2Star(){
        val example = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"

        day.mode = SolutionMode.TwoStar
        day.solve(example)

        assertEquals(2286L, day.solutionTwoStar)
    }
}