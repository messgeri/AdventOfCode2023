import java.lang.NumberFormatException

class AdventFactory {
    private var solvedChallenges = HashMap<Int, IAdventOfCode>()

    init {
        val day1 = Day1()
        val day2 = Day2()
        val day3 = Day3()
        val day4 = Day4()
        val day5 = Day5()

        solvedChallenges[day1.day] = day1
        solvedChallenges[day2.day] = day2
        solvedChallenges[day3.day] = day3
        solvedChallenges[day4.day] = day4
        solvedChallenges[day5.day] = day5
    }

    fun getDay(date : Int) : IAdventOfCode? {
        return solvedChallenges[date]
    }
}