package commands.tools

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import validator

@Serializable
data class Wrapper(val map : List<HashMap<String, String>>) {}
fun parse() : String{
    return Json.encodeToString(Wrapper(validator.takeAllInfoFromCommand()))
}