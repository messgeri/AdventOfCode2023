class ResourceLoader {
    private var files = HashMap<Int, String>()

    init {
        files[1] = "Day1_Input.txt"
        files[2] = "Day2_Input.txt"
    }

    fun readResource(day : Int) : String {
        if(files[day] != null){
            val input = this::class.java.getResourceAsStream(files[day])?.bufferedReader()?.readText()
            if(input != null)
                return input
        }
        return ""
    }

    fun hasResource(day : Int) : Boolean {
        return files.containsKey(day)
    }
}