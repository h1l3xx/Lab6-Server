
import java.io.IOException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

object ReceiverProgram {
    @Throws(IOException::class)
    fun startReceiver(): DatagramChannel {
        val receiver = DatagramChannel.open()
        val address = InetSocketAddress("172.28.29.31", 1050)//localnetwork ip
        receiver.bind(address)
        println("Receiver started at #$address")
        return receiver
    }

    @Throws(IOException::class)
    fun receiveMessage(receiver: DatagramChannel): String {
        val buffer = ByteBuffer.allocate(1024)
        val senderAddress = receiver.receive(buffer)
        val message = extractMessage(buffer)
        println("Received message from sender: $senderAddress")
        return message
    }

    private fun extractMessage(buffer: ByteBuffer): String {
        buffer.flip()
        val bytes = ByteArray(buffer.remaining())
        buffer[bytes]
        return String(bytes)
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val receiver = startReceiver()
        while (true) {
            val message = receiveMessage(receiver)
            println(" - Message: $message")
        }
        receiver.close()
        println("Receiver closed!")
    }
}