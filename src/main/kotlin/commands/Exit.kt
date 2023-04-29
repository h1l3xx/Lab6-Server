package commands

import commands.tools.ArgsInfo
import commands.tools.Result
import commands.tools.SetMapForCommand
import uSender
import kotlin.system.exitProcess

object Message {
    const val MESSAGE = "Приложение завершает свою работу..."
}

class Exit : Command {
    private val setMapForCommand = SetMapForCommand()
    private val printer = uSender
    private val argsInfo = ArgsInfo()
    override fun comply(variables: HashMap<String, Any>): Result {
        printer.print ( Message.MESSAGE )
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

    override fun setMapForClient(): HashMap<String, String> {
        return setMapForCommand.setMapForCommand(0,0,false, Exit(), "")
    }
}