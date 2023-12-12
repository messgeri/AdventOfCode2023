abstract class DayBase : IAdventOfCode {
    private var s1 = 0L
    var solutionOneStar : Long
        get() = s1
        protected  set(value) { s1 = value }

    private var s2 = 0L
    var solutionTwoStar : Long
        get() = s1
        protected  set(value) { s1 = value }

}