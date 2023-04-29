package commands


import commandManager
import commands.tools.ArgsInfo
import commands.tools.Result
import commands.tools.SetMapForCommand
import uSender


class Help : Command{
    private val argsInfo = ArgsInfo()
    private val printer = uSender
    private val setMapForCommand = SetMapForCommand()

    override fun comply(variables: HashMap<String, Any>): Result {
        val commandDescriptionList: HashMap<String, String> = commandManager.getCommandDescriptionList()
        for (command in commandDescriptionList) {
            printer.sendValues(command.key, command.value)
        }
        return Result("Команда успешно выполнена", false)
    }

    override fun getDescription(): String {
        return "Справка по командам. Передаваемых аргументов НЕТ."
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(0,0,1)
    }

    override fun getName(): String {
        return "help"
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        return HashMap()
    }

    override fun setMapForClient(): HashMap<String, String> {
        return setMapForCommand.setMapForCommand(0,0,true,Help(), "")
    }
}