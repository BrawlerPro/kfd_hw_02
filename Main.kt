sealed class Transport {
    abstract val name: String
    abstract val speed: Double
    abstract val type: TransportType
}

data class Car(
    override val name: String,
    override val speed: Double,
    override val type: TransportType,
    val engine: Engine
) : Transport()

data class Airplane(
    override val name: String,
    override val speed: Double,
    override val type: TransportType,
    val wings: Int
) : Transport()

data class Ship(
    override val name: String,
    override val speed: Double,
    override val type: TransportType,
    val length: Double
) : Transport()

data class Train(
    override val name: String,
    override val speed: Double,
    override val type: TransportType,
    val numberOfCarriages: Int
) : Transport()

data class Rocket(
    override val name: String,
    override val speed: Double,
    override val type: TransportType,
    val fuelTankCapacity: Double
) : Transport()

class Engine (
    private val type: String,
    private val power: Double
){
    fun underTheHood(): String {
        return "Тип мотора $type .He have $power hours power"
    }
}

enum class TransportType {
    LAND,
    WATER,
    AIR,
    SPACE
}

fun main() {
    val car = Car("Audi R8", 250.0, TransportType.LAND, Engine("V8", 500.0))
    val airplane = Airplane("Boeing", 900.0, TransportType.AIR, 2)
    val ship = Ship("Irina VU", 30.0, TransportType.WATER, 294.134)
    val train = Train("Trans-Siberian Railway", 250.0, TransportType.LAND, 25)
    val rocket = Rocket("Roskosmos", 5000.0, TransportType.SPACE, 12321.12)

    val transportList = listOf(car, airplane, ship, train, rocket)

    val ui = TransportCollection(transportList)
    ui.run()
}

class TransportCollection(private val transportList: List<Transport>) {
    fun run() {
        println("\tКоллекция Транспорта:")
        for (transport in transportList) {
            println("* ${transport.name}, скорость: ${transport.speed}, тип: ${transport.type}")
        }
    }

}