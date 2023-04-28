package commands.tools





import city.Climate
import city.Government
import commands.Var
import sc
import uSender
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


object Messages{
    const val setName = "Укажите название города:"
    const val errorName = "Название города не может быть пустой строкой или null."

    const val setCoordX = "Введите координату X (Long):"
    const val setCoordY = "Введите координату Y (Float):"
    const val errorCoords = "Указано некорректное значение координаты."

    const val setArea = "Введите значение поля Area (Int, не отрицательная):"
    const val errorValue = "Указано некорректное значение переменной."
    const val setPopulation = "Введите количество жителей (Long, не отрицательное):"
    const val setMeters = "Введите высоту над уровнем моря (Long):"
    const val setAgl = "Введите значение поля Agglomeration (Double)"
    const val setClimate = "Укажите климат из перечисленных значений: \n\t HUMIDCONTINENTAL, \n\t MEDITERRANIAN, \n\t STEPPE."
    const val setGovernment = "Укажите тип правительства из перечисленных: \n\t OLIGARCHY, \n\t JUNTA, \n\t ETHNOCRACY."
    const val setAge = "Укажите возраст губернатора (Int):"
    const val setBirthday = "Укажите день рождения губернатора в формате DD/MM/YYYY:"

}
class VarsShaper {

    fun shape():HashMap<String, Any>{
        val variables = HashMap<String, Any>()
        variables[Var.name] = setName()
        variables[Var.coordinateX] = setCoordX()
        variables[Var.coordinateY] = setCoordY()
        variables[Var.area] = setAreaAndAge(Var.area)
        variables[Var.population] = setPopulation()
        variables[Var.meters] = setMeters()
        variables[Var.agl] = setAgl()
        variables[Var.climate] = setClimate()
        variables[Var.government] = setGovernment()
        variables[Var.age] = setAreaAndAge(Var.age)
        variables[Var.birthday] = setBirthday()


        return variables
    }
    fun setName():String{
        println( Messages.setName )
        val name = sc.nextLine()
        return if (checkName(name)) {
            return name
        } else {
            this.setName()
        }
    }

    fun checkName(name : String) : Boolean{
        return if (name == "" || name.equals(null) || name == "null") {
            uSender.print { Messages.errorName }
            this.setName()
            false
        } else {
            true
        }
    }

    fun setCoordY(): Float {
        uSender.print { Messages.setCoordY }
        val y = sc.nextLine()
        return if (checkCoordY(y)) {
            return y.toFloat()
        } else {
            this.setCoordY()
        }
    }

    fun checkCoordY(y : String) : Boolean{
        return try {
            y.toFloat()
            true
        } catch (e: Exception){
            uSender.print { Messages.errorCoords }
            false
        }
    }

    fun setCoordX():Long {
        uSender.print { Messages.setCoordX }
        val x = sc.nextLine()
        return if (checkCoordX(x)) {
            x.toLong()
        } else {
            this.setCoordX()
        }
    }

    fun checkCoordX(x : String): Boolean{
        return try {
            x.toLong()
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorCoords }
            false
        }
    }
    fun setAreaAndAge(filed : String): Int{
        if (filed == Var.area){
            uSender.print { Messages.setArea }
        } else{
            uSender.print { Messages.setAge }
        }
        val area = sc.nextLine()
        return if (checkAreaAndAge(area)) {
            area.toInt()
        } else {
            this.setAreaAndAge(filed)
        }
    }
    fun checkAreaAndAge(area : String): Boolean{
        return try {
            area.toInt()
            if (area.toInt() < 0){
                uSender.print { Messages.errorValue }
                false}
            else{
                true}
        }catch (e : Exception){
            uSender.print { Messages.errorValue }
            false
        }
    }

    fun setPopulation():Long{
        uSender.print { Messages.setPopulation }
        val population = sc.nextLine()
        return if (checkPopulation(population)) {
            return population.toLong()
        } else {
            this.setPopulation()
        }
    }

    fun checkPopulation(population : String) : Boolean{
        return try {
            population.toLong()
            if (population.toLong() < 0) {
                uSender.print { Messages.errorValue }
                this.setPopulation()
            }
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorValue }
            false
        }
    }

    fun setMeters() : Long{
        uSender.print { Messages.setMeters }
        val meters = sc.nextLine()
        return if (checkMeters(meters)) {
            return meters.toLong()
        } else {
            this.setMeters()
        }

    }

    fun checkMeters(meters: String) : Boolean{
        return try {
            meters.toLong()
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorValue }
            false
        }
    }
    fun setAgl() : Double{
        uSender.print { Messages.setAgl }
        val agl = sc.nextLine()
        return if (checkAdl(agl)) {
            return agl.toDouble()
        } else {
            this.setAgl()
        }
    }

    fun checkAdl(agl : String) : Boolean{
        return try {
            agl.toDouble()
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorValue }
            false
        }
    }
    fun setClimate(): String{
        uSender.print { Messages.setClimate }
        val climate  = sc.nextLine()
        return if (checkClimate(climate)) {
            return climate.uppercase()
        } else {
            this.setClimate()
        }
    }

    fun checkClimate(climate : String) : Boolean{
        return try {
            Climate.valueOf(climate.uppercase())
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorValue }
            false
        }
    }
    fun setGovernment(): String{
        uSender.print { Messages.setGovernment }
        val government = sc.nextLine()
        return if (checkGovernment(government)) {
            return government.uppercase()
        } else {
            setGovernment()
        }
    }

    fun checkGovernment(government : String) : Boolean{
        return try {
            Government.valueOf(government.uppercase())
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorValue }
            false
        }
    }
    fun setBirthday(): String{
        uSender.print { Messages.setBirthday }
        val birthday = sc.nextLine()
        return if (checkBirthday(birthday)) {
            return birthday
        } else {
            this.setBirthday()
        }
    }
    fun checkBirthday(birthday : String) : Boolean{
        return try {
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            val date: LocalDate = LocalDate.parse(birthday, formatter)
            val result: ZonedDateTime = date.atStartOfDay(ZoneId.systemDefault())
            true
        } catch (e: Exception) {
            uSender.print { Messages.errorValue }
            false
        }
    }
}


