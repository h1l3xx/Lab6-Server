import java.io.IOException
import java.net.DatagramSocket
import java.net.DatagramPacket

class Server {
    fun main(){
        try {
            val byteArray : ByteArray = ByteArray(5)
            val ds = DatagramSocket(1050)

            while (true){
                val pack = DatagramPacket(byteArray, 5)
                ds.receive(pack)
                println(pack.data.toString())
            }
        }catch (e : IOException){
            e.printStackTrace()
        }
    }
}