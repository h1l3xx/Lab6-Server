
import city.CityCollection
import commands.*
import senders.USender

val collection = CityCollection()
val operator = Operator()
val commandManager = CommandManager()
val uSender = USender()
val server = ReceiverProgram()

fun main(){
    commandManager.register(Add(), Clear(), ExecuteScript(), Exit(), FilterContainsName(), Help(), Info(),
    PrintAscending(), RemoveAllByMetersAboveSeaLevel(), RemoveAt(), RemoveById(), RemoveLower(), Save(), Show(), Sort(), UpdateById())
    val receiver = server.startReceiver()
    while (true){
        server.main(receiver)
    }
}