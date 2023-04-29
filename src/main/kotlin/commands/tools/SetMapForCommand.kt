package commands.tools

import commands.Add
import commands.Command

class SetMapForCommand {
    fun setMapForCommand(min : Int , max : Int, inline : Boolean, command : Command, description: String) : HashMap<String, String>{
        val commandInfo = Validator()
        commandInfo.setCommandName(command.getName())
        commandInfo.setInline(inline)
        commandInfo.setMax(max)
        commandInfo.setMin(min)
        if (command.getName() == Add().getName()){
            commandInfo.setText(BuilderTextForAddCommand().build(VarsShaper().listForAddCommand))
        }else{
            commandInfo.setText(description)
        }
        return commandInfo.createMap()
    }
}