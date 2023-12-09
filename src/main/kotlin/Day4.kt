class Day4 : IAdventOfCode {
    override val day = 4
    override var mode = SolutionMode.OneStar

    private var s1 = 0L
    var solutionOneStar : Long
        get() = s1
        private set(value) { s1 = value }

    override fun solve(input: String) {
        input.lines().forEach{
            solutionOneStar += getWinning(it)
        }
        println("The solution for 1 star is: $solutionOneStar")
    }

    private fun getWinning(card : String) : Int {
        var prize = 0
        var c = card.split(':')
        c = c[1].split('|')
        var w = c[0].split(' ')
        var n = c[1].split(' ')

        var winners = ArrayList<Int>()
        var numbers = ArrayList<Int>()

        w.forEach{
            it.toIntOrNull()?.let { it -> winners.add(it) }
        }
        n.forEach {
            it.toIntOrNull()?.let { it -> numbers.add(it) }
        }

        winners.sort()
        numbers.sort()
        var i = 0
        winners.forEach{
            while(numbers.isNotEmpty() && i < numbers.size && numbers[i] <= it){
                if(numbers[i] == it){
                    if(prize == 0){
                        prize = 1
                    }else{
                        prize *= 2
                    }
                }
                i++
            }
        }
        return prize
    }
}