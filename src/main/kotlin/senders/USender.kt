package senders

import java.net.SocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel


class USender : Sender {
    var manager : ChannelAndAddressManager? = null
    var channel : DatagramChannel? = null
    var addr : SocketAddress? = null
    override fun print(string: String) {
        channel = manager!!.getChannel()
        addr = manager!!.getAddress()
        channel!!.send(ByteBuffer.wrap(string.toByteArray()), addr)
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