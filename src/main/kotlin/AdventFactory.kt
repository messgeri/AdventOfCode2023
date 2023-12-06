import java.lang.NumberFormatException

class AdventFactory {
    init {

    }
    private val solvedChallenges = HashMap<Int, IAdventOfCode>()

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