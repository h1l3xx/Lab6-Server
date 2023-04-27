package commands.tools

import city.City
import collection
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import java.io.FileReader


class Parser {
    fun parse(path:String){
        val objectMapper = ObjectMapper().registerModule(JavaTimeModule())
        var file = FileReader(path).readText()
        println(file)
        file = file.drop(1)
        file = file.dropLast(1)
        val citiesInJson = file.split("}},").toMutableList()
        for (i in citiesInJson.indices){
            citiesInJson[i] = citiesInJson[i] + "}}"
        }
        for (i in 0 until citiesInJson.size){
            println(citiesInJson[i])
            val col: City = objectMapper.readValue(citiesInJson[i], City::class.java)
            collection.add(col)
        }
    }
}
