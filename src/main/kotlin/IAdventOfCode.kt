interface IAdventOfCode {
    val day : Int
    var mode : SolutionMode
    fun solve(input : String)
}