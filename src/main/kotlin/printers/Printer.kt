package printers

interface Printer {
    fun print(supplier: () -> String) {
        println(supplier())
    }
}