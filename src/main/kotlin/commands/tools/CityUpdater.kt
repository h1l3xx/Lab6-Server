package commands.tools


import buffer
import city.City
import city.Climate
import city.Government
import city.arrayFreeId
import collection
import commands.Add
import commands.Var
import operator
import uSender
import java.time.ZonedDateTime

object Numbers {
    const val one = "1"
    const val two = "2"
    const val three = "3"
    const val four = "4"
    const val five = "5"
    const val six = "6"
    const val seven = "7"
    const val eight = "8"
    const val nine ="9"
    const val ten = "10"
    const val eleven = "11"
    const val twelve = "12"
}

class CityUpdater {

    private var varsShaper = VarsShaper()

    fun updateCity(city : City, arguments : HashMap<String, Any>) =
        if (arguments[Var.allFields] == "True" || arguments[Var.numberOfFields] == Numbers.eleven){
            fullUpdate(city)
        }else{
            for (i in 1..arguments[Var.numberOfFields].toString().toInt()){
                when (i.toString()){
                    Numbers.one -> update(city, arguments[Numbers.one].toString())
                    Numbers.two -> update(city, arguments[Numbers.two].toString())
                    Numbers.three -> update(city, arguments[Numbers.three].toString())
                    Numbers.four -> update(city, arguments[Numbers.four].toString())
                    Numbers.five -> update(city, arguments[Numbers.five].toString())
                    Numbers.six -> update(city, arguments[Numbers.six].toString())
                    Numbers.seven -> update(city, arguments[Numbers.seven].toString())
                    Numbers.eight -> update(city, arguments[Numbers.eight].toString())
                    Numbers.nine -> update(city, arguments[Numbers.nine].toString())
                    Numbers.ten -> update(city, arguments[Numbers.ten].toString())
                    else -> {
                        uSender.print{ "Ошибка при извлечении поле. Попробуйте ещё раз." }
                        operator.runCommand(buffer.getMessage(false))
                    }
                }
            }
        }
    private fun fullUpdate(city : City){
        val cl = collection.getCollection()
        if (arrayFreeId.isNotEmpty()){
            arrayFreeId[arrayFreeId.lastIndex+1] = cl[0].getId()!!}
        else{
            arrayFreeId =  arrayOf(cl[0].getId()!!)
        }
        cl.remove(city)
        operator.runCommand(Add().getName())
    }
    private fun update(city : City, field : String){
        when (field) {
            Var.name -> city.setName(varsShaper.setName())
            Var.meters -> city.setMetersAboveSeaLevel(varsShaper.setMeters())
            Var.birthday -> city.setGovernorAge(ZonedDateTime.parse(varsShaper.setBirthday()))
            Var.coordinateX -> city.setCoordinatesX(varsShaper.setCoordX())
            Var.coordinateY -> city.setCoordinatesY(varsShaper.setCoordY())
            Var.climate -> city.setClimate(Climate.valueOf(varsShaper.setClimate()))
            Var.population -> city.setPopulation(varsShaper.setPopulation())
            Var.government -> city.setGovernment(Government.valueOf(varsShaper.setGovernment()))
            Var.agl -> city.setAgglomeration(varsShaper.setAgl())
            Var.age -> city.setArea(varsShaper.setAreaAndAge(Var.age))
            Var.area -> city.setArea(varsShaper.setAreaAndAge(Var.area))
            else -> {
                uSender.print{" Ошибка. Указано несуществующее поле, проверьте указанные значения."}
                operator.runCommand(buffer.getMessage(false))
            }
        }
    }
}