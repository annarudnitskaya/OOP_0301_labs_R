package lab1.Lab6

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class Serializer {

    private val json = Json {
        prettyPrint = true
        serializersModule = serializersMod
    }

    fun serialization(list: List<ColoredShape2d>): String {
        return json.encodeToString(list)
    }

    fun deserialization(data: String): List<ColoredShape2d> {
        return json.decodeFromString(data)
    }

}
