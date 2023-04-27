package commands.tools


import collection
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File
import java.nio.charset.Charset


class ParseToSave {
    fun save(){
        val mapper = ObjectMapper()
            .registerModule(KotlinModule())
            .registerModule(JavaTimeModule())
        val serializebled = mapper.writeValueAsString(collection.getCollection())
        val wayToFile = "C:\\Users\\Sasha\\IdeaProjects\\Lab6-Server\\save.json"
        writeFile(serializebled, wayToFile)
    }
    private fun writeFile(text: String, destFile: String) {
        val f = File(destFile)
        if (!f.exists()) {
            f.createNewFile()
        }
        f.writeText(text, Charset.defaultCharset())
    }
}