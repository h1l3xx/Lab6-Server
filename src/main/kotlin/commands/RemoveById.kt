package commands

import city.arrayFreeId
import collection
import commands.tools.ArgsInfo
import commands.tools.MoreArgumentsInCommand
import commands.tools.Result

private var arrayOfId = emptyArray<Long>()
class RemoveById : Command {
    private val argsInfo = ArgsInfo()
    private val c = collection.getCollection()

    override fun comply(variables: HashMap<String, Any>): Result {
        val numbersOfId = variables[Var.numbersOfId].toString().toInt()

        var message = "Города удалены."
        if (c.size == 0){
            message = "Коллекция пуста. Нечего изменять."
        }else{
            for (id in 1..numbersOfId){
                addIdInArray(variables[id.toString()].toString().toLong())
            }
            removeAllCity(arrayOfId)
        }
        return Result(message, true)
    }

    override fun getName(): String {
        return "remove_by_id"
    }

    override fun getDescription(): String {
        return "Удаляет элемент коллекции по его id. Количество аргументов не должно превышать количества элементов в коллекции."
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(c.size,1,1)
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        val more = MoreArgumentsInCommand()
        return more.moreArguments(arguments, Var.numbersOfId)
    }
    private fun addIdInArray(id : Long){
        arrayOfId = if (arrayOfId.isNotEmpty()){
            arrayOfId.clone() + id
        } else{
            arrayOf(id)
        }
    }
    private fun removeAllCity(array : Array<Long>){
        val iterator = collection.getCollection().iterator()
        while (iterator.hasNext()) {
            val iterCity = iterator.next()
            for (id in array){
                if (iterCity.getId() == id) {
                    arrayFreeId = if (arrayFreeId.isNotEmpty()){
                        arrayFreeId.clone() + iterCity.getId()!!
                    } else{
                        arrayOf(iterCity.getId()!!)
                    }
                    iterator.remove()
                }
            }
        }
    }
}