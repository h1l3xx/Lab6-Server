package serversTools

import sc

class Buffer {
    private lateinit var message : String
    fun getMessage(bool : Boolean) : String{
        if (!bool){
            println("Введи значение сам, пж, пока не реализовано.")
            setMessage(sc.nextLine())
        }
        return this.message
    }
    fun setMessage(mes : String){
        this.message = mes
    }
}