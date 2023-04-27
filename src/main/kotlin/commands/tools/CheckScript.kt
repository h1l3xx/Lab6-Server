package commands.tools

import buffer
import commands.Clear
import operator
import uSender

class CheckScript {
    private val scriptArray = arrayOf("")
    fun check(line : String){
        for (script in scriptArray){
            if (line == script){
                uSender.print { "Ошибка. Обнаружена рекурсия. Все изменения, которые успели выполниться - отменены." }

                Clear().comply(HashMap())
                Parser().parse("C:\\Users\\Sasha\\IdeaProjects\\Lab6-Server\\save.json")

                operator.runCommand( buffer.getMessage(false))
            }else{
                scriptArray[scriptArray.size-1] = line
            }
        }
    }
}