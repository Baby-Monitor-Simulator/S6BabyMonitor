package org.fontys
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.putJsonArray
import org.fontys.data.DataGenerator

fun main() {
    val dataGenerator = DataGenerator();
    var minute = 0;
    val dataFinal: MutableList<JsonObject> = mutableListOf();

    while(minute < 10) {
        dataFinal.add(dataGenerator.createJSONData(minute))
        minute = minute.inc()
    }

    val json = buildJsonObject {
        putJsonArray("dataSets") {
            for (i in dataFinal) add(i)
        }
    }

    print(json)
}
