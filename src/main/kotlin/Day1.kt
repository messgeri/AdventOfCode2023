class Day1 : IAdventOfCode {
    private var solution = 0L
    override val day = 1

    override fun solve(input : String) {
        solution = parseText(input)
        print("The solution is: $solution")
    }

    fun parseLine(input : String) : Long{
        var first = 0L
        var last = 0L
        var foundFirst = false

        input.forEach {
            if(it.isDigit()){
                if(foundFirst){
                    last = it.digitToInt().toLong()
                }else{
                    foundFirst = true
                    first = it.digitToInt().toLong()
                    last = it.digitToInt().toLong()
                }
            }
        }
        return first * 10 + last
    }

    fun parseText(input : String) : Long{
        var retVal = 0L

        input.lines().forEach {
            retVal += parseLine(it)
        }
        return retVal
    }
}