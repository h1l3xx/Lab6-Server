package serversTools

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class Deserialization {
    fun deserialize(data: String): HashMap<String, String> {
        val objectMapper = ObjectMapper()
        return objectMapper.readValue<HashMap<String,String>>(data)
    }
}