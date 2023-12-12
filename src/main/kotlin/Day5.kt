import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Day5 : DayBase() {
    override val day = 5
    override var mode = SolutionMode.OneStar
    private var maps = ArrayList<HashMap<Long, Long>>()
    private var seeds = ArrayList<Long>()

    private fun clear(){
        for(i in 0 until 7) maps.add(HashMap())

        seeds = ArrayList()
        solutionOneStar = 0L
        solutionTwoStar = 0L
    }

    override fun solve(input: String) {
        clear()
        parseInput(input)
        when(mode){
            SolutionMode.OneStar -> solveOneStar()
        }
    }

    private fun solveOneStar(){
        var sortedKeys = ArrayList<List<Long>>()
        solutionOneStar = Long.MAX_VALUE

        for(map in maps){
            sortedKeys.add(map.keys.sorted())
        }

        for(seed in seeds){
            var location = seed
            for(i in sortedKeys.indices){
                location = calcValue(maps[i], sortedKeys[i], location)
            }

            if(location < solutionOneStar) solutionOneStar = location.toLong()
        }
        println("The solution for 1 star is: $solutionOneStar")
    }

    private fun getKeyAndOffset(map : List<Long>, key : Long) : Pair<Long, Long>?{
        for(i in map.indices){
            if(map[i] > key) return null
            if(map[i] == key) return Pair(key, 0L)
            if(i < map.size - 1 && map[i] < key && map[i+1] > key) return Pair(map[i], key - map[i])
        }
        return null
    }

    private fun calcValue(map : HashMap<Long, Long>, sortedKeys : List<Long>, key : Long) : Long{
        val keyAndOffset = getKeyAndOffset(sortedKeys,key)
        return if(keyAndOffset != null){
            map.getOrDefault(keyAndOffset.first, 0) + keyAndOffset.second
        }else{
            key
        }
    }

    private fun parseInput(input : String){
        val lines = input.lines()
        fillSeeds(lines[0])
        var state = -1

        for(i in 1 until lines.size){
            if(state >= 0) fillMap(lines[i],state)

            if(state < states.size - 1 && lines[i].contains(states[state + 1])) state++
        }
    }

    private fun fillSeeds(line : String){
        var s = line.split(' ').toMutableList()
        s.removeAt(0)

        s.forEach{
            seeds.add(it.toLong())
        }
        seeds.sort()
    }

    private fun fillMap(line : String, idx : Int){
        if(line.isEmpty() || line.contains(':')) return
        val numbers = line.split(' ')
        val first = numbers[0].toLong()
        val key = numbers[1].toLong()
        val offset = numbers[2].toLong() - 1

        maps[idx][key] = first
        maps[idx][key + offset] = first + offset
    }

    private val states = arrayOf(
        "seed-to-soil",
        "soil-to-fertilizer",
        "fertilizer-to-water",
        "water-to-light",
        "light-to-temperature",
        "temperature-to-humidity",
        "humidity-to-location"
    )
}