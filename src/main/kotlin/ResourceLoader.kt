import kotlin.io.path.Path
import kotlin.io.path.exists

class ResourceLoader {
    fun readResource(day : Int) : String {
        val path = "Day"+day.toString()+"_Input.txt"
        if(Path(path).exists()){
            val input = this::class.java.getResourceAsStream(path)?.bufferedReader()?.readText()
            if(input != null)
                return input
        }
        return ""
    }

    fun hasResource(day : Int) : Boolean {
        val path = "Day"+day.toString()+"_Input.txt"
        return Path(path).exists()
    }
}