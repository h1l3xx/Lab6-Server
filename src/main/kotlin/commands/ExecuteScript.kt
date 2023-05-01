package commands


import commands.tools.ArgsInfo
import commands.tools.Result
import commands.tools.SetMapForCommand
import commands.tools.VarsShaper
import operator
import sc
import uSender
import java.util.*

var stack = false
class ExecuteScript: Command{

    private val setMapForCommand = SetMapForCommand()
    private val argsInfo = ArgsInfo()
    private val shaper = VarsShaper()
    override fun comply(variables: HashMap<String, Any>): Result {
        stack = true
        try {
            for (i in 0 until variables.size){
                if (variables[i.toString()].toString().contains("[")){
                    operator.runCommand(variables[i.toString()].toString().drop(1))
                }else if (variables[i.toString()].toString().contains("]")){
                    if (variables[i.toString()].toString()== "]"){
                        continue
                    }else{
                    operator.runCommand(variables[i.toString()].toString().dropLast(1))
                    }
                }else{
                    operator.runCommand(variables[i.toString()].toString())
                }
            }
        }catch (e : Exception){
            uSender.print("Ошибка. Проверьте корректность данных в скрипте.")
        }

        stack = false
        val message = "Команда выполнена."
        return Result(message, true)
    }

    override fun getName(): String {
        return "execute_script"
    }

    override fun getDescription(): String {
        return "Исполнение команд из указанного файла. Можно передать только ОДИН аргумент."
    }

    override fun argContract(arguments: List<String>): HashMap<String, Any> {
        val file : HashMap<String, Any> = HashMap()
        for (i in 0 until arguments.size){
            file[i.toString()] = arguments[i]
        }
        return file
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(100000, 1, 1)
    }

    override fun setMapForClient(): HashMap<String, String> {
        return setMapForCommand.setMapForCommand(1,1,true, ExecuteScript(), Var.wayToFile)
    }
    private fun addCommand(commands : List<String>, index : Int) : Int{
        val variables = HashMap<String, Any>()
        var detector = false
        var indexValue = index + 1
        if (shaper.checkName(commands[indexValue])) {
            variables[Var.name] = commands[indexValue]
            indexValue += 1
        }else {
            detector = true
        }
        if (shaper.checkCoordX(commands[indexValue]) && !detector){
            variables[Var.coordinateX] = commands[indexValue]
            indexValue += 1
        }else {
            detector = true
        }
        if (shaper.checkCoordY(commands[indexValue]) && !detector){
            variables[Var.coordinateY] = commands[indexValue]
            indexValue += 1
        }else {
            detector = true
        }
        if (shaper.checkAreaAndAge(commands[indexValue]) && !detector){
            variables[Var.area] = commands[indexValue]
            indexValue += 1
        }else{
            detector = true
        }
        if (shaper.checkPopulation(commands[indexValue]) && !detector){
            variables[Var.population] = commands[indexValue]
            indexValue += 1
        }else{
            detector = true
        }
        if (shaper.checkMeters(commands[indexValue]) && !detector){
            variables[Var.meters] = commands[indexValue]
            indexValue += 1
        }else{
            detector = true
        }
        if (shaper.checkAdl(commands[indexValue]) && !detector){
            variables[Var.agl] = commands[indexValue]
            indexValue += 1
        }else {
            detector = true
        }
        if (shaper.checkClimate(commands[indexValue]) && !detector) {
            variables[Var.climate] = commands[indexValue].uppercase(Locale.getDefault())
            indexValue += 1
        }else{
            detector = true
        }
        if (shaper.checkGovernment(commands[indexValue]) && !detector) {
            variables[Var.government] = commands[indexValue].uppercase(Locale.getDefault())
            indexValue += 1
        }else{
            detector = true
        }
        if (shaper.checkAreaAndAge(commands[indexValue]) && !detector){
            variables[Var.age] = commands[indexValue]
            indexValue += 1
        }else{
            detector = true
        }
        if (shaper.checkBirthday(commands[indexValue]) && !detector){
            variables[Var.birthday] = commands[indexValue]
            indexValue += 1
        }else {
            detector = true
        }
        if (!detector){
            Add().comply(variables)
        }else{
            uSender.print ("Найдена ошибка в обработке значений для команды 'add', проверьте порядок и правильность. " )
            operator.runCommand(sc.nextLine())
        }
        return indexValue
    }
}