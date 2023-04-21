package commands
import commands.tools.Result

interface Command {
    fun comply(variables: HashMap<String, Any>): Result
    fun getDescription(): String
    fun getName(): String
    fun argContract(arguments : List<String>): HashMap<String, Any>
    fun argsInfo(): HashMap<String, Int>
}