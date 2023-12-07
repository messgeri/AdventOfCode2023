class Day1 : IAdventOfCode {
    private var solution = 0
    override val day = 1
    override var mode = SolutionMode.Both

    override fun solve(input : String) {
        solution = parseText(input)
        print("The solution is: $solution")
    }

    fun parseLine(input : String) : Int{
        var first = 0
        var last = 0
        var foundFirst = false
        var number = 0
        val states = arrayListOf(0,0,0,0,0,0,0,0,0)

        input.forEach {
            for(i in 0..8){
                states[i] = getState(it, states[i], i)
            }

            if(states[0] == 3) number = 1
            if(states[1] == 3) number = 2
            if(states[2] == 5) number = 3
            if(states[3] == 4) number = 4
            if(states[4] == 4) number = 5
            if(states[5] == 3) number = 6
            if(states[6] == 5) number = 7
            if(states[7] == 5) number = 8
            if(states[8] == 4) number = 9
            if(it.isDigit() && it.digitToInt() > 0) number = it.digitToInt()


            //Save numbers
            if(number > 0){
                if(foundFirst){
                    last = number
                }else{
                    foundFirst = true
                    last = number
                    first = number
                }
            }
        }
        return first * 10 + last
    }

    fun parseText(input : String) : Int{
        var retVal = 0

        input.lines().forEach {
            val num = parseLine(it)
            retVal += num
            println("$it value: $num / $retVal")
        }
        return retVal
    }

    private fun getState(c : Char, v : Int, state : Int) : Int{
        when(state){
            0 -> return state1(c,v)
            1 -> return state2(c,v)
            2 -> return state3(c,v)
            3 -> return state4(c,v)
            4 -> return state5(c,v)
            5 -> return state6(c,v)
            6 -> return state7(c,v)
            7 -> return state8(c,v)
            8 -> return state9(c,v)
        }
        return 0
    }

    private fun state1(c : Char, v : Int) : Int{
        when(c){
            'o' -> return 1
            'n' -> if(v == 1) return 2
            'e' -> if(v == 2) return 3
        }
        return 0
    }

    private fun state2(c : Char, v : Int) : Int{
        when(c){
            't' -> return 1
            'w' -> if(v == 1) return 2
            'o' -> if(v == 2) return 3
        }
        return 0
    }

    private fun state3(c : Char, v : Int) : Int{
        when(c){
            't' -> return 1
            'h' -> if(v == 1) return 2
            'r' -> if(v == 2) return 3
            'e' -> if(v == 3) {
                return 4
            }else if(v == 4){
                return 5
            }
        }
        return 0
    }

    private fun state4(c : Char, v : Int) : Int{
        when(c){
            'f' -> return 1
            'o' -> if(v == 1) return 2
            'u' -> if(v == 2) return 3
            'r' -> if(v == 3) return 4
        }
        return 0
    }

    private fun state5(c : Char, v : Int) : Int{
        when(c){
            'f' -> return 1
            'i' -> if(v == 1) return 2
            'v' -> if(v == 2) return 3
            'e' -> if(v == 3) return 4
        }
        return 0
    }

    private fun state6(c : Char, v : Int) : Int{
        when(c){
            's' -> return 1
            'i' -> if(v == 1) return 2
            'x' -> if(v == 2) return 3
        }
        return 0
    }

    private fun state7(c : Char, v : Int) : Int{
        when(c){
            's' -> return 1
            'v' -> if(v == 2) return 3
            'n' -> if(v == 4) return 5
            'e' -> if(v == 1) {
                return 2
            }else if(v == 3){
                return 4
            }
        }
        return 0
    }

    private fun state8(c : Char, v : Int) : Int{
        when(c){
            'e' -> return 1
            'i' -> if(v == 1) return 2
            'g' -> if(v == 2) return 3
            'h' -> if(v == 3) return 4
            't' -> if(v == 4) return 5
        }
        return 0
    }

    private fun state9(c : Char, v : Int) : Int{
        when(c){
            'n' -> if(v == 2){
                return 3
            }else return 1
            'i' -> if(v == 1) return 2
            'e' -> if(v == 3) return 4
        }
        return 0
    }
}