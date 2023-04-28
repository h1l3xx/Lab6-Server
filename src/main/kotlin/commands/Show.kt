package commands

import collection
import commands.tools.ArgsInfo
import commands.tools.Result
import commands.tools.SetMapForCommand
import uSender


class Show : Command {
    private val argsInfo = ArgsInfo()
    private val setMapForCommand = SetMapForCommand()
    override fun comply(variables: HashMap<String, Any>): Result {

        val collection = collection.getCollection()
        if (collection.size > 0) {
            for (c in collection) {
                println(c.toString())
            }
        } else {
            uSender.print { "Коллекция пуста." }
        }

        return Result("Команда выполнена успешно.", false)
    }

    override fun getName(): String {
        return "show"
    }

    override fun getDescription(): String {
        return "Вывод элементов коллекции. Передаваемых аргументов НЕТ."
    }

    override fun setMapForClient(): HashMap<String, String> {
        return setMapForCommand.setMapForCommand(0,0,true, Show())
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        return HashMap()
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(0,0,1)
    }
}