class ResourceLoader {
    private var files = HashMap<Int, String>()

    init {
        files[1] = "Day1_Input.txt"
    }

    fun readResource(day : Int) : String {
        if(files[1] != null){
            val input = this::class.java.getResourceAsStream("Day1_Input.txt")?.bufferedReader()?.readText()
            if(input != null)
                return input
        }
        return ""
    }

    fun hasResource(day : Int) : Boolean {
        return files.containsKey(day)
    }
}