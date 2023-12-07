import java.lang.NumberFormatException

class AdventFactory {
    private var solvedChallenges = HashMap<Int, IAdventOfCode>()

    init {
        val day1 = Day1()

        solvedChallenges[day1.day] = day1
    }

    fun getDay(date : Int) : IAdventOfCode? {
        return solvedChallenges[date]
    }
}