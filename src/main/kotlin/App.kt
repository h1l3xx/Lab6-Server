
import city.CityCollection
import commands.*
import commands.tools.Validator
import senders.USender
import server.UpdServer
import serversTools.Serialization

val collection = CityCollection()
val operator = Operator()
val commandManager = CommandManager()
val uSender = USender()
val validator = Validator()


fun main(){
    commandManager.register(Add(), Clear(), ExecuteScript(), Exit(), FilterContainsName(), Help(), Info(),
    PrintAscending(), RemoveAllByMetersAboveSeaLevel(), RemoveAt(), RemoveById(), RemoveLower(), Show(), Sort(), UpdateById())
    println(Serialization().serialize(validator.takeAllInfoFromCommand()))

    UpdServer().run()

}