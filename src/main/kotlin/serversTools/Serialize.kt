package serversTools

import com.fasterxml.jackson.databind.ObjectMapper


class Serialization {
    fun serialize(data : List<HashMap<String, String>>): String? {
        val mapper = ObjectMapper()
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data)
    }
    fun serializeAnswer(data : String) : String {
        val mapper = ObjectMapper()
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data)
    }
}