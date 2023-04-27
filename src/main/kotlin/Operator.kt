import serversTools.Buffer
import java.util.*

object Strings {
    const val START_STRING = "Введите абсолютный путь до файла:"
    const val NO_COMMAND = "Такой команды не существует. Узнать о поддерживаемых командах можно через команду help."
}

var sc = Scanner(System.`in`)
class Operator {

    fun process() : Boolean{
        val buffer = Buffer()

        uSender.print { Strings.START_STRING }

        val wayToFile  = buffer.getMessage(true)

        val firstCommand = "load $wayToFile"

        runCommand(firstCommand)

        return false
    }

    fun runCommand(command: String){
        val commandAndArguments = command.split(" ")
        val name = commandAndArguments[0]
        val arguments = commandAndArguments.drop(1)


        if (commandManager.checkCommand(name)){
            if (arguments.isNotEmpty() && arguments.last() == ""){
                val argumentsWithoutLast = arguments.dropLast(1)
                commandManager.manage(name, argumentsWithoutLast)
            }else{
                commandManager.manage(name, arguments)}
        }else{
            uSender.print { Strings.NO_COMMAND }
        }
    }
}