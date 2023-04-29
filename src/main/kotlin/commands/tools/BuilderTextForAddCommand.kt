package commands.tools

import commands.Var

class BuilderTextForAddCommand {

    fun build(list : List<String>) : String{
        val sB = StringBuilder()
        sB.append(Var.allFields + "; ")
        for (i in list.indices){
            sB.append(list[i])
            sB.append("; ")
        }
        return sB.toString()
    }
}