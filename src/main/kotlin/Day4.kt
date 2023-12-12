import kotlin.math.log2

class Day4 : DayBase() {
    override val day = 4
    override var mode = SolutionMode.OneStar
    private var cards = ArrayList<Int>()

    override fun solve(input: String) {
        clear()
        for(j in input.lines().indices) cards.add(1)
        var i = 0
        input.lines().forEach{
            val copies = getWinning(it)
            var prize = 0
            for(n in 1..copies){
                if(n == 1)
                    prize += 1
                else
                    prize *= 2
            }

            solutionOneStar += prize
            solutionTwoStar += cards[i]
            i++
            for(j in 0 until copies){
                if(j + i > cards.size) break
                cards[j + i] += cards[i-1]
            }
        }
        println("The solution for 1 star is: $solutionTwoStar")
    }

    private fun getWinning(card : String) : Int {
        var prize = 0
        var c = card.split(':')
        c = c[1].split('|')
        val w = c[0].split(' ')
        val n = c[1].split(' ')

        val winners = ArrayList<Int>()
        val numbers = ArrayList<Int>()

        w.forEach{
            it.toIntOrNull()?.let { it1 -> winners.add(it1) }
        }
        n.forEach {
            it.toIntOrNull()?.let { it1 -> numbers.add(it1) }
        }

        winners.sort()
        numbers.sort()
        var i = 0
        winners.forEach{
            while(numbers.isNotEmpty() && i < numbers.size && numbers[i] <= it){
                if(numbers[i] == it){
                    prize += 1
                }
                i++
            }
        }
        return prize
    }

    private fun clear(){
        solutionOneStar = 0L
        solutionTwoStar = 0L
    }
}