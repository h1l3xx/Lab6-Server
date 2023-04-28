package server

import serversTools.Serialization
import commands.tools.Validator
import operator
import serversTools.Deserialization
import serversTools.Parse
import java.net.InetSocketAddress
import java.net.SocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

class UpdServer {

    private var running = true
    var clientsAddress = mutableListOf<SocketAddress>()

    fun run(channel : DatagramChannel){

        val address = InetSocketAddress("172.28.20.255", 3000)
        channel.bind(address)
        println("Server is running.")

        while (this.running){
            val buffer = ByteBuffer.allocate(65535)
            val socketAddress: SocketAddress = channel.receive(buffer)
            buffer.flip()
            val bytes = ByteArray(buffer.remaining())
            buffer.get(bytes)
            val data = String(bytes)
            if (!this.clientsAddress.contains(socketAddress)) {
                this.clientsAddress.add(socketAddress)
                firstConnection(channel, socketAddress)
            } else {
                this.receive(channel, socketAddress, data)
            }
        }
    }

    private fun receive(channel: DatagramChannel, socketAddress: SocketAddress, data : String){

        val deserializationSegment = Deserialization().deserialize(data)
        val commandAndArguments = Parse().parseToServer(deserializationSegment)
        println(commandAndArguments.drop(1).dropLast(1))
        operator.runCommand(commandAndArguments.drop(1).dropLast(1))

        channel.send(ByteBuffer.wrap(Serialization().serializeAnswer("Ответ").toByteArray()), socketAddress)
    }

    private fun firstConnection(channel: DatagramChannel, socketAddress: SocketAddress){
        val printAddress = socketAddress.toString().split(":")[0].drop(1)
        println("New client : $printAddress")

        channel.send(ByteBuffer.wrap(Serialization().serialize(Validator().takeAllInfoFromCommand())!!.toByteArray()), socketAddress)
    }

    fun stop(){
        this.running = false
    }
}