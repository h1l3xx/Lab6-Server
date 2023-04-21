package city


import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class City {
    private var id: Long? =null
    private var name: String? =null
    private var coordinates: Coordinates? = Coordinates(0,0F)
    private var creationDate: LocalDateTime? = LocalDateTime.now()
    private var area: Int? =null
    private var population: Long? =null
    private var metersAboveSeaLevel: Long? =null
    private var agglomeration: Double? =null
    private var climate: Climate? =null
    private var government: Government? =null
    private var governor: Human? = Human()


    override fun toString(): String {
        val formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val str = StringBuilder()
        str.append("id города: ").append(id)
        str.append("; Название города: ").append(name)
        str.append("; Координаты города: ").append(coordinates.toString())
        str.append("; Дата создания: ").append(creationDate!!.format(formatted))
        str.append("; Территория: ").append(area)
        str.append("; Население: ").append(population)
        str.append("; Высота над уровнем моря: ").append(metersAboveSeaLevel)
        str.append("; Агломерация: ").append(agglomeration)
        str.append("; Климат: ").append(climate)
        str.append("; Правительство: ").append(government)
        str.append("; Губернатор: ").append(governor.toString()).append("\n")
        return str.toString()
    }

    fun getCoordinates(): Coordinates? = coordinates
    fun setCoordinates(coordinates: Coordinates) {
        this.coordinates = coordinates
    }

    fun getCoordinatesX(): Long{
        return coordinates!!.getX()
    }
    fun setCoordinatesX(x: Long) {
        coordinates!!.setX(x)
    }

    fun getCoordinatesY(): Float {
        return coordinates!!.getY()
    }
    fun setCoordinatesY(y: Float) {
        coordinates!!.setY(y)
    }

    fun getMetersAboveSeaLevel(): Long? = metersAboveSeaLevel
    fun setMetersAboveSeaLevel(metersAboveSeaLevel: Long){
        this.metersAboveSeaLevel = metersAboveSeaLevel
    }

    fun getGovernor(): Human? = governor
    fun setGovernor(governor: Human?){
        this.governor = governor
    }

    fun getGovernorAge(): Int? = governor!!.getAge()
    fun setGovernorAge(age: Int){
        governor!!.setAge(age)
    }

    fun getGovernorBirthday(): ZonedDateTime? = governor!!.getBirthday()
    fun setGovernorAge(birthday: ZonedDateTime){
        governor!!.setBirthday(birthday)
    }

    fun getName(): String? = name
    fun setName(name: String) {
        this.name = name
    }

    fun getId(): Long? = id
    fun setId(id: Long?) {
        this.id = id
    }

    fun getCreationDate(): LocalDateTime? = creationDate
    fun setCreationDate(creationDate: LocalDateTime?) {
        this.creationDate = creationDate
    }

    fun getClimate(): Climate? = climate
    fun setClimate(climate: Climate){
        this.climate = climate
    }

    fun getGovernment(): Government? = government
    fun setGovernment(government: Government){
        this.government = government
    }

    fun getAgglomeration(): Double? = agglomeration
    fun setAgglomeration(agglomeration: Double){
        this.agglomeration = agglomeration
    }

    fun getArea(): Int? = area
    fun setArea(area: Int){
        this.area = area
    }

    fun getPopulation(): Long? = population
    fun setPopulation(population: Long) {
        this.population = population
    }
}