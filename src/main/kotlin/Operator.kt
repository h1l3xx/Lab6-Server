import java.util.*

object Strings {
    const val START_STRING = "Введите абсолютный путь до файла:"
    const val NO_COMMAND = "Такой команды не существует. Узнать о поддерживаемых командах можно через команду help."
}

var sc = Scanner(System.`in`)
class Operator {



    fun process(){

        uPrinter.print { Strings.START_STRING }

        val wayToFile  = sc.nextLine()

        val firstCommand = "load $wayToFile"

        runCommand(firstCommand)
        //Написать код для загрузки данных из файла в коллекцию

        while (true){
            val command = sc.nextLine()
            runCommand(command)
        }
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
            uPrinter.print { Strings.NO_COMMAND }
        }
    }


}