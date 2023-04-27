
import commands.tools.Validator
import commands.tools.parse
import serversTools.Buffer
import java.io.IOException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

val validator = Validator()
val buffer = Buffer()
class ReceiverProgram {
    private val users = Users()
    private var checker = true

    @Throws(IOException::class)
    fun startReceiver(): DatagramChannel {
        val receiver = DatagramChannel.open()
        val address = InetSocketAddress("192.168.31.83", 3000)//local network ip
        receiver.bind(address)
        println("Receiver started at #$address")
        return receiver
    }

    @Throws(IOException::class)
    fun receiveMessage(receiver: DatagramChannel): String {
        val buffer = ByteBuffer.allocate(1024)
        val senderAddress = receiver.receive(buffer)
        val senderAddressForArray = senderAddress.toString().split(":")
        if (users.checkUser(senderAddressForArray[0])){
            uSender.print { parse() }
        }
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
    fun main(receiver : DatagramChannel) {
        while (true) {
            val message = receiveMessage(receiver)
            println(message)

            buffer.setMessage(message)
            if (checker){
            checker = operator.process()
            }else
                operator.runCommand(buffer.getMessage(true))
        }
    }
}