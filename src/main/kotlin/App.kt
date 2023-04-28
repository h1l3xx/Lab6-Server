
import city.CityCollection
import commands.*
import serversTools.Serialization
import commands.tools.Validator
import senders.USender
import server.UpdServer
import java.nio.channels.DatagramChannel

val collection = CityCollection()
val operator = Operator()
val commandManager = CommandManager()
val uSender = USender()
val validator = Validator()
val channel = DatagramChannel.open()

fun main(){
    commandManager.register(Add(), Clear(), ExecuteScript(), Exit(), FilterContainsName(), Help(), Info(),
    PrintAscending(), RemoveAllByMetersAboveSeaLevel(), RemoveAt(), RemoveById(), RemoveLower(), Save(), Show(), Sort(), UpdateById())
    println(Serialization().serialize(validator.takeAllInfoFromCommand()))
    UpdServer().run(channel)

    //while (true){
    //    server.main(receiver)
    //}
}