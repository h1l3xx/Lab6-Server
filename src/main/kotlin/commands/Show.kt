package commands

import collection
import commands.tools.ArgsInfo
import commands.tools.Result
import uPrinter
import java.util.*


class Show : Command {
    private val argsInfo = ArgsInfo()
    override fun comply(variables: HashMap<String, Any>): Result {

        val collection = collection.getCollection()
        if (collection.size > 0) {
            for (c in collection) {
                uPrinter.print { c.toString() }
            }
        } else {
            uPrinter.print { "Коллекция пуста." }
        }

        return Result("Команда выполнена успешно.", false)
    }

    override fun getName(): String {
        return "show"
    }

    override fun getDescription(): String {
        return "Вывод элементов коллекции. Передаваемых аргументов НЕТ."
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        return HashMap()
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(0,0,1)
    }
}