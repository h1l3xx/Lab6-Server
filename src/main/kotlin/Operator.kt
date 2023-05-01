import commands.ExecuteScript
import java.util.*

object Strings {
    const val START_STRING = "Введите абсолютный путь до файла:"
    const val NO_COMMAND = "Такой команды не существует. Узнать о поддерживаемых командах можно через команду help."
}

var sc = Scanner(System.`in`)
class Operator {

    fun process(wayToFile : String) : Boolean{

        uSender.print ( Strings.START_STRING )

        val wayToFile  = wayToFile

        val firstCommand = "load $wayToFile"

        runCommand(firstCommand)

        return false
    }

    fun runCommand(command: String){
        if (command.contains(ExecuteScript().getName())){
            val exAndCom = command.split(", ")
            val com = exAndCom.drop(1)
            commandManager.manage(exAndCom[0], com)
        }
        val commandAndArguments = command.split(" ")
        val name = commandAndArguments[0]
        val arguments = commandAndArguments.drop(1)
        if (!name.contains(ExecuteScript().getName())) {


            if (commandManager.checkCommand(name)) {
                if (arguments.isNotEmpty() && arguments.last() == "") {
                    var argumentsWithoutLast = arguments.dropLast(1)
                    if (arguments.size == 12) {
                        val addArg = ArrayList<String>()
                        for (i in 0..10) {
                            addArg.add(arguments[i])
                        }
                        argumentsWithoutLast = addArg
                    }
                    commandManager.manage(name, argumentsWithoutLast)
                } else {
                    commandManager.manage(name, arguments)
                }
            } else {
                uSender.print(Messages.MESSAGE)
            }
        }
    }
}