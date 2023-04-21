package city

class Coordinates(private var x: Long, private var y: Float) {

    fun getX(): Long = x

    fun setX(x:Long){
        this.x = x
    }

    fun getY(): Float = y

    fun setY(y: Float){
        this.y = y
    }

    override fun toString(): String = "($x;$y)"
}