import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var factory = AdventFactory()
    var input = String()
    var adventSolver : IAdventOfCode? = null
    var date = 0
    var resource = ResourceLoader()

    if(args.size > 0 && args[0].toInt() > 0 && args[0].toInt() < 26){
        date = args[0].toInt()
        if(factory.getDay(date) == null){
            print("Day has not been solves yet.")
            exitProcess(-1)
        }else{
            adventSolver = factory.getDay(date)
        }
    }

    if(args.size == 3 && (args [1] == "--file" || args[1] == "-f")){
        if(Path(args[2]).exists()){
            input = File(args[2]).bufferedReader().use { it.readText() }
        }
    }else if(args.size == 3 && (args [1] == "--input" || args[1] == "-i")){
        input = args[2]
    } else if(resource.hasResource(date)){
        input = resource.readResource(date)
    }else{
        println("No input added was added.")
    }

    adventSolver?.solve(input)
    exitProcess(0)
}