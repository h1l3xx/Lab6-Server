package commands.tools


import commandList
import commands.Var


class Validator {
    private var list = mutableListOf<HashMap<String,String>>()
    private var max : Int? = null
    private var min : Int? = null
    private var inline : Boolean? = null
    private var commandName : String? = null

    fun setCommandName(name : String){
        this.commandName = name
    }
    fun setMax(value : Int){
        this.max = value
    }
    fun setMin(value : Int){
        this.min = value
    }
    fun setInline(value: Boolean){
        this.inline = value
    }
    fun createMap() : HashMap<String, String>{
        val returnMap : HashMap<String, String> = HashMap()
        returnMap[Var.name] = commandName.toString()
        returnMap[Values.max] = max.toString()
        returnMap[Values.min] = min.toString()
        returnMap[Values.between] = inline.toString()

        return returnMap
    }


    fun takeAllInfoFromCommand() : List<HashMap<String,String>>{
        for (command in commandList){
            list.add(command.value.setMapForClient())
        }
        val argumentsSetting = ArgumentsSetting()
        list.add(SetMapForArguments().set() as HashMap<String, String>)
        return list
    }
}


