import java.lang.NumberFormatException

class AdventFactory {
    private var solvedChallenges = HashMap<Int, IAdventOfCode>()

    init {
        val day1 = Day1()
        val day2 = Day2()

        solvedChallenges[day1.day] = day1
        solvedChallenges[day2.day] = day2
    }

    fun getDay(date : Int) : IAdventOfCode? {
        return solvedChallenges[date]
    }
}