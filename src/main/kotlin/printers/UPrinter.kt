package printers

class UPrinter : Printer{
    fun printValues(key: String, value : String) {
        kotlin.io.print {
            "$key --- $value"
        }
    }
}