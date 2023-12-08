import kotlin.io.path.Path
import kotlin.io.path.exists

class ResourceLoader {
    fun readResource(day : String) : String {
        val path = "Day"+day+"_Input.txt"
        val input = this::class.java.getResourceAsStream(path)?.bufferedReader()?.readText()
        return input?:""
    }

    fun hasResource(day : String) : Boolean {
        val path = "Day"+day+"_Input.txt"
        return this::class.java.getResourceAsStream(path) != null
    }
}