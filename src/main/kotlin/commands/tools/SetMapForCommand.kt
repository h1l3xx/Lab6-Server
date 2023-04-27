package commands.tools

import commands.Command

class SetMapForCommand {
    fun setMapForCommand(min : Int , max : Int, inline : Boolean, command : Command) : HashMap<String, String>{
        val commandInfo = Validator()
        commandInfo.setCommandName(command.getName())
        commandInfo.setInline(inline)
        commandInfo.setMax(max)
        commandInfo.setMin(min)
        return commandInfo.createMap()
    }
}