package commands

import commands.tools.ArgsInfo
import commands.tools.Result
import printers.UPrinter
import kotlin.system.exitProcess

object Message {
    const val MESSAGE = "Приложение завершает свою работу..."
}

class Exit : Command {
    private val printer = UPrinter()
    private val argsInfo = ArgsInfo()
    override fun comply(variables: HashMap<String, Any>): Result {
        printer.print { Message.MESSAGE }
        exitProcess(0)
    }

    override fun getName(): String {
        return "exit"
    }
    override fun getDescription(): String {
        return "Выход из приложения. Коллекция автоматически не сохраняется. Передаваемых аргументов НЕТ."
    }

    override fun argContract(arguments : List<String>): HashMap<String, Any> {
        return HashMap()
    }
    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(0,0,1)
    }
}