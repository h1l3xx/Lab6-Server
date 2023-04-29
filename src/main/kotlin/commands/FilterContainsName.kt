package commands

import city.City

import collection
import commands.tools.ArgsInfo
import commands.tools.Result
import commands.tools.SetMapForCommand
import uSender


class FilterContainsName : Command {
    private val argsInfo = ArgsInfo()
    private val setMapForCommand = SetMapForCommand()
    override fun comply(variables: HashMap<String, Any>): Result {

        val collectionInfo = collection.getCollection()

        if (collectionInfo.isNotEmpty()) {
            val it: Iterator<City> = collection.getCollection().iterator()
            while (it.hasNext()) {
                val city: City = it.next()
                if (city.getName()!!.contains(variables["Substring"].toString())) {
                    uSender.print ( city.getName()!! )
                }
            }
        } else {
            uSender.print ( "Коллекция пуста." )
        }

        return Result("Выведены все города с указанной подстрокой в названии.", true)
    }

    override fun getName(): String {
        return "filter_contains_name"
    }

    override fun getDescription(): String {
        return "Вывод элементов коллекции, поле name которых содержит заданную подстроку. Диапазон аргументов: от 1 до 100."
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(1,1,1)
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        val name : HashMap<String, Any> = HashMap()
        name["Substring"] = arguments[0]
        return name
    }

    override fun setMapForClient(): HashMap<String, String> {
        return setMapForCommand.setMapForCommand(1, 1, true, FilterContainsName(), Var.str)
    }
}