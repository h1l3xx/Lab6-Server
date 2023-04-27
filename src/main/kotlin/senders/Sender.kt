package senders

import java.io.IOException
import java.net.InetSocketAddress
import java.net.SocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

interface Sender {

    @Throws(IOException::class)
    fun startSender(): DatagramChannel {
        val sender = DatagramChannel.open()
        val address: SocketAddress? = null
        sender.bind(address)
        sender.configureBlocking(false)
        return sender
    }

    @Throws(IOException::class)
    fun sendMessage(
        sender: DatagramChannel, msg: String,
        receiverAddress: SocketAddress?
    ) {
        val buffer = ByteBuffer.wrap(msg.toByteArray())
        sender.send(buffer, receiverAddress)
    }

    fun print(supplier: () -> String) {
        val sender = startSender()
        val receiverAddress = InetSocketAddress("192.168.31.83", 1050)
        sendMessage(sender, supplier(), receiverAddress)
    }
}

