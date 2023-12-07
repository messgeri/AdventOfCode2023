import java.lang.NumberFormatException

class AdventFactory {
    private var solvedChallenges = HashMap<Int, IAdventOfCode>()

    init {
        val day1 = Day1()

        solvedChallenges[day1.Day()] = day1
    }

    fun SolveDay(day : String){
        var date = 1
        try {
            var date = day.toInt()
        }catch (nfe : NumberFormatException){
            println("Write the date dummy...")
            return
        }

        if(solvedChallenges.containsKey(date)){
            solvedChallenges[date]?.Solve()
        }else{
            println("Solve that day you lazy schmuck!")
        }
    }
}