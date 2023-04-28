package serversTools

class Parse {
    fun parseToServer(map : HashMap<String, String>) : String {
        var returnString = ""
        returnString += map.values
        return returnString
    }
}