package org.fontys.data

import kotlinx.serialization.json.JsonObject

public interface GraphDataGenerator {
    fun createJSONData(minute: Number): JsonObject
    fun convertStringToJSON(s: String)

    fun yValueGenerator(): MutableMap<GraphSet, Int>
}