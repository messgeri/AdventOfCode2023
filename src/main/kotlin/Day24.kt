import kotlin.math.sqrt

class Day24 : DayBase() {
    override val day: Int
        get() = 24

    override var mode = SolutionMode.OneStar
    private var vectors = ArrayList<Array<Double>>()
    var testArea = Pair(200000000000000.0, 400000000000000.0)

    override fun solve(input: String) {
        when(mode)
        {
            SolutionMode.OneStar -> solveOneStar(input)
            SolutionMode.TwoStar -> solveTwoStar(input)
            SolutionMode.Both -> {
                solveOneStar(input)
                solveTwoStar(input)
            }
        }
    }

    private fun solveOneStar(input : String){
        vectors = ArrayList<Array<Double>>()

        input.lines().forEach{
            vectors.add(createEquation2D(it))
        }

        for(i in vectors.indices){
            for(k in i until vectors.size){
                if(intersects2D(vectors[i], vectors[k])) solutionOneStar++
            }
        }

        println("The solution for 1 star is: $solutionOneStar")
    }

    private fun solveTwoStar(input: String){
        // TODO
    }

    private fun createEquation2D(line : String) : Array<Double>{
        val vectors = line.split('@')
        val position = vectors[0].split(',')
        val direction = vectors[1].split(',')

        val x = position[0].toDouble()
        val y = position[1].toDouble()
        val dx = direction[0].toDouble()
        val dy = direction[1].toDouble()
        val c = dx*(dy+y)-dy*(dx+x)

        return arrayOf(x,y,-1.0*dx,dy,c)
    }

    /*
    line : a1 * x + b1 * y + c1

    x = (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1)
    y = (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1)
     */
    private fun intersects2D(l1: Array<Double>, l2: Array<Double>) : Boolean{
        val d = l1[2]*l2[3] - l2[2]*l1[3]
        val numx = l2[2]*l1[4] - l1[2]*l2[4]
        val numy = l1[3]*l2[4] - l2[3]*l1[4]

        if(d == 0.0) return false

        val x = numx / d
        val y = numy / d

        if(x > testArea.second || x < testArea.first ||
            y > testArea.second || y < testArea.first)
            return false

        //Check for future collisions (not in time)
        if(
            (l1[2] > 0 && x > l1[0]) || (l1[2] < 0 && x < l1[0]) ||
            (l2[2] > 0 && x > l2[0]) || (l2[2] < 0 && x < l2[0]) ||
            (l1[3] > 0 && y < l1[1]) || (l1[3] < 0 && y > l1[1]) ||
            (l2[3] > 0 && y < l2[1]) || (l2[3] < 0 && y > l2[1])
        ) return false

        return true
    }
}