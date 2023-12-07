import java.io.File

class Day1 : IAdventOfCode {
    var solution = 0L

    override fun Solve() {
        val text = this::class.java.getResourceAsStream("Day1_Input.txt")?.bufferedReader()?.readText()

        if(text != null){
            solution = ParseText(text)
            print("The solution is: " + solution)
        }
    }

    override fun Day(): Int {
        return 1
    }

    fun ParseLine(input : String) : Long{
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

    fun ParseText(input : String) : Long{
        var retVal = 0L

        input.lines().forEach {
            retVal += ParseLine(it)
        }
        return retVal
    }
}