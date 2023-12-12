import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.log10

class Day3 : DayBase() {
    override val day = 3
    override var mode = SolutionMode.Both

    class Coordinate(var row : Int, var column : Int){
        fun hashCoordinate() : Long{
            val r = row.toLong()
            val c = column.toLong()
            return ((r + c) * (r + c + 1) / 2 + r)
        }
    }

    private var numbers = ArrayList<Pair<Int, Coordinate>>()
    private var symbols = HashMap<Long, Char>()
    private var gears = HashMap<Long, Pair<Int, Int>>()

    override fun solve(input: String) {
        cleanUp()
        fillParts(input)
        when(mode){
            SolutionMode.OneStar -> sumUpParts()
            SolutionMode.TwoStar -> sumUpGearRatios()
            SolutionMode.Both -> {
                sumUpParts()
                sumUpGearRatios()
            }
        }
    }

    private fun fillParts(input : String){
        var number = 0
        var lines = input.lines()
        for(i in lines.indices){
            for(k in lines[i].indices){
                if(lines[i][k].isDigit()){
                    number *= 10
                    number += lines[i][k].digitToInt()
                    if(k == lines[i].length - 1 || !lines[i][k + 1].isDigit()){
                        numbers.add(Pair(number, Coordinate(i,k)))
                        number = 0
                    }
                }else if(lines[i][k] != '.' && lines[i][k] != '\n'){
                    symbols[Coordinate(i,k).hashCoordinate()] = lines[i][k]
                }
            }
        }
    }

    private fun sumUpParts(){
        numbers.forEach{
            if(hasSurroundingSymbol(it)) {
                solutionOneStar += it.first
            }
        }
        println("The solution for 1 star is: $solutionOneStar")
    }

    private fun sumUpGearRatios(){
        numbers.forEach{
            saveIfSurroundedGear(it)
        }
        gears.toList().forEach{
            if(it.second.first == 2){
                solutionTwoStar += it.second.second
            }
        }
        println("The solution for 2 star is: $solutionTwoStar")
    }

    private fun getSurrounding(p : Pair<Int, Coordinate>) : ArrayList<Coordinate>{
        var retVal = ArrayList<Coordinate>()
        val n = p.first
        val row = p.second.row
        val col = p.second.column
        for(i in -1..1){
            for(k in -1..(log10(n.toDouble())+1).toInt()){
                if(row + i >= 0 && col - k >= 0){
                    retVal.add(Coordinate(row+i, col-k))
                }
            }
        }

        return retVal
    }

    private fun hasSurroundingSymbol(p : Pair<Int, Coordinate>) : Boolean{
        val s = getSurrounding(p)

        s.forEach{
            if(symbols.containsKey(it.hashCoordinate())){
                return true
            }
        }
        return false
    }

    private fun saveIfSurroundedGear(p : Pair<Int, Coordinate>){
        val s = getSurrounding(p)

        s.forEach{
            if (symbols[it.hashCoordinate()] == '*') {
                if(gears.containsKey(it.hashCoordinate())){
                    val current = gears[it.hashCoordinate()]
                    if (current != null) {
                        gears[it.hashCoordinate()] = Pair(current.first+1, current.second * p.first)
                    }
                }else {
                    gears[it.hashCoordinate()] = Pair(1, p.first)
                }
            }
        }
    }

    private fun cleanUp(){
        symbols.clear()
        numbers.clear()
        gears.clear()
        solutionOneStar = 0L
        solutionTwoStar = 0L
    }
}