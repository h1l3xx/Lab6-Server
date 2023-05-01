package senders

import commands.stack
import serversTools.Serialization
import java.net.SocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel


class USender : Sender {
    var manager : ChannelAndAddressManager? = null
    var channel : DatagramChannel? = null
    var addr : SocketAddress? = null
    var sendStack = ""
    override fun print(string: String) {
        if (!stack){
            if (sendStack == ""){
                val answerServer = Serialization().serializeAnswer(string)
                channel = manager!!.getChannel()
                addr = manager!!.getAddress()
                channel!!.send(ByteBuffer.wrap(answerServer.toByteArray()), addr)
            }else{
                val answerServer = Serialization().serializeAnswer(sendStack)
                channel = manager!!.getChannel()
                addr = manager!!.getAddress()
                channel!!.send(ByteBuffer.wrap(answerServer.toByteArray()), addr)
                sendStack = ""
            }
        }else{
            sendStack += string +"\n"
        }
    }
    fun sendValues(key : String, value : String){
        print {
            "$key --- $value"
        }
    }
    fun newManager(manager: ChannelAndAddressManager){
        this.manager = manager
    }
}