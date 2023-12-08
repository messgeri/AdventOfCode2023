import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Day3 : IAdventOfCode {
    override val day = 3
    override var mode = SolutionMode.OneStar

    class Coordinate(var row : Int, var column : Int)

    private var numbers = HashMap<Int ,HashMap<Int, Int>>()
    private var symbols = ArrayList<Coordinate>()

    override fun solve(input: String) {
        TODO("Not yet implemented")
    }

    private fun fillParts(input : String){
        var r = 0
        var c = 0
        var columns = ArrayList<Int>()
        input.lines().forEach {
            it.forEach {
                var h = 1
                var num = 0;
                if(it.isDigit()){
                    num *= h + it.digitToInt()
                    columns.add(r)
                    h *= 10
                }else if(num != 0){
                   saveNumber(num, r, columns)
                   columns.clear()
                   h = 1
                }

                if(!it.isDigit() && it != '.'){
                    symbols.add(Coordinate(r, c))
                }

                c++
            }
            r++
        }
    }

    private fun saveNumber(number : Int, row : Int, columns : ArrayList<Int>){
        numbers[row] = HashMap<Int, Int>()
        columns.forEach{
            numbers[row]?.set(it, number)
        }
    }

    private fun sumUp(){
        symbols.forEach{

        }
    }
}