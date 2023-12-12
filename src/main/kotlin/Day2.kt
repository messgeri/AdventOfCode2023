class Day2 : DayBase() {
    override val day = 2
    override var mode = SolutionMode.Both

    //Limits: RED, GREEN, BLUE
    private val limits = arrayOf(12,13,14)

    override fun solve(input: String) {
        when(mode){
            SolutionMode.OneStar -> solveOneStar(input)
            SolutionMode.TwoStar -> solveTwoStar(input)
            SolutionMode.Both -> {
                solveOneStar(input)
                solveTwoStar(input)
            }
        }
    }

    private fun solveOneStar(input : String){
        var id = 1
        solutionOneStar = 0
        input.lines().forEach {
            if(isValid(parseRound(it))) solutionOneStar += id

            id++
        }
        println("The solution for 1 star is: $solutionOneStar")
    }

    private fun solveTwoStar(input : String){
        solutionTwoStar = 0
        input.lines().forEach {
            solutionTwoStar += findPower(parseRound(it))
        }
        println("The solution for 2 star is: $solutionTwoStar\n")
    }

    fun parseRound(round : String) : ArrayList<ArrayList<Int>>{
        var retVal = arrayListOf(ArrayList<Int>(),ArrayList<Int>(),ArrayList<Int>())
        var r = round.split(':')
        if(r.size > 1){
            r[1].split(';').forEach{
                it.split(',').forEach{
                    var ball = it.split(' ')

                    if(ball.size == 3){
                        when(ball[2]){
                            "red" -> retVal[0].add(ball[1].toInt())
                            "green" -> retVal[1].add(ball[1].toInt())
                            "blue" -> retVal[2].add(ball[1].toInt())
                        }
                    }
                }
            }
        }
        return retVal
    }

    private fun isValid(round : ArrayList<ArrayList<Int>>) : Boolean{
        for(i in 0..2){
            round[i].forEach{
                if(it > limits[i]){
                    return false
                }
            }
        }
        return true
    }

    private fun findPower(round : ArrayList<ArrayList<Int>>) : Long{
        var power = 1L
        round.forEach{
            power *= it.maxOrNull()?:1
        }
        return power
    }
}