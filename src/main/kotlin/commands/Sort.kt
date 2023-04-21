package commands


import city.CityComparator
import collection
import commands.tools.ArgsInfo
import commands.tools.Result


class Sort : Command {
    private val argsInfo = ArgsInfo()
    override fun comply(variables: HashMap<String, Any>): Result {

        val c = CityComparator()
        val cl = collection.getCollection()

        cl.sortWith(c)

        return Result("Коллекция отсортирована", true)
    }

    override fun getName(): String {
        return "sort"
    }

    override fun getDescription(): String {
        return "Сортировка элементов в естественном порядке. Передаваемых аргументов НЕТ."
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(0,0,1)
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        return HashMap()
    }
}