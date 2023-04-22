package senders


class USender : Sender {
    fun sendValues(key : String, value : String){
        print {
            "$key --- $value"
        }
    }
}