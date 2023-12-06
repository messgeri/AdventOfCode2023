class Day1 : IAdventOfCode {
    override fun Solve() {
        TODO("Not yet implemented")
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

}