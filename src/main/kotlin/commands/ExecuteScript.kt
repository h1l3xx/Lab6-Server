package commands


import commands.tools.*
import operator
import sc
import uPrinter
import java.io.BufferedReader
import java.io.FileReader
import java.util.*
import kotlin.collections.HashMap

class ExecuteScript: Command{

    private val argsInfo = ArgsInfo()
    private var lines : Int = 0
    private val checker = CheckScript()
    private val shaper = VarsShaper()
    override fun comply(variables: HashMap<String, Any>): Result {
        var message = "Команда выполнена"
        var file = """"""

        try{
            val bufferReader = BufferedReader(FileReader(variables[Var.wayToFile].toString()))
            while (bufferReader.readLine() != null){
                lines += 1
            }
            val buf = BufferedReader(FileReader(variables[Var.wayToFile].toString()))
            while (lines > 0){
                file += buf.readLine() + "\n"
                lines -= 1
            }
            val commands = file.lines()
            checker.check(ExecuteScript().getName() + " " + variables[Var.wayToFile].toString())
            val numbersOfCommands = commands.size
            var counter = 0
            while (counter != numbersOfCommands){
                if (commands[counter].contains(ExecuteScript().getName())){
                    checker.check(commands[counter])
                }else if (commands[counter].contains(Add().getName())){
                    counter = addCommand(commands, commands.indexOf(commands[counter]))
                }
                operator.runCommand(commands[counter])
                counter += 1
            }
        }catch (e : Exception){
            message = "Error. Команда не выполнена."
            println(e.printStackTrace())
        }


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
        file[Var.wayToFile] = arguments[0]
        return file
    }

    override fun argsInfo(): HashMap<String, Int> {
        return argsInfo.setLimits(1, 1, 1)
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
            uPrinter.print { "Найдена ошибка в обработке значений для команды 'add', проверьте порядок и правильность. " }
            operator.runCommand(sc.nextLine())
        }
        return indexValue
    }
}