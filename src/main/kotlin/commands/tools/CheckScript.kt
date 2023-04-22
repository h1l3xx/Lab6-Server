package commands.tools

import operator
import sc
import uSender

class CheckScript {
    private val scriptArray = arrayOf("")
    fun check(line : String){
        for (script in scriptArray){
            if (line == script){
                uSender.print { "Ошибка. Обнаружена рекурсия." }
                operator.runCommand(sc.nextLine())
            }else{
                scriptArray[scriptArray.size-1] = line
            }
        }
    }
}