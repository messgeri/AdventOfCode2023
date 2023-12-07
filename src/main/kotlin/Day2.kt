class Day2 : IAdventOfCode {
    override val day = 2
    //Limits: RED, GREEN, BLUE
    private val limits = arrayOf(12,13,14)
    private var s = 0
    var solution : Int
        get() {return s}
        private set(value : Int){s = value}


    override fun solve(input: String) {
        var id = 1
        solution = 0
        input.lines().forEach {
            if(isValid(parseRound(it))) solution += id

            id++
        }
        print("The solution is: $solution")
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

    fun isValid(round : ArrayList<ArrayList<Int>>) : Boolean{
        for(i in 0..2){
            round[i].forEach{
                if(it > limits[i]){
                    return false
                }
            }
        }
        return true
    }
}