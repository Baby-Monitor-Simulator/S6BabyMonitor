package org.fontys.data

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import kotlin.random.Random

class DataGenerator : GraphDataGenerator {
    // should be called in loop
    override fun createJSONData(minute: Number): JsonObject {
        val ySets: MutableMap<GraphSet, Int> = yValueGenerator()
        val json = buildJsonObject {
            putJsonObject(GraphSet.FETAL_BLOOD.text) {
                put("x", minute)
                put("y", ySets[GraphSet.FETAL_BLOOD])
            }
            putJsonObject(GraphSet.FETAL_BLOOD_PRESSURE.text) {
                put("x", minute)
                put("y", ySets[GraphSet.FETAL_BLOOD_PRESSURE])
            }
            putJsonObject(GraphSet.UTERINE_CONTRACTIONS.text) {
                put("x", minute)
                put("y", ySets[GraphSet.UTERINE_CONTRACTIONS])
            }
            putJsonObject(GraphSet.FETAL_HEART_RATE.text) {
                put("x", minute)
                put("y", ySets[GraphSet.FETAL_HEART_RATE])
            }
        }
        return json;
    }

    override fun convertStringToJSON(s: String) {
        TODO("Not yet implemented")
    }

    override fun yValueGenerator(): MutableMap<GraphSet, Int> {
        val lb = 0
        val ub = 20
        val ySets = LinkedHashMap<GraphSet, Int>()

        // TODO("Make specific lb/ub for each data type")
        val ySetsBounds = LinkedHashMap<GraphSet, Pair<Int, Int>>()
        ySetsBounds[GraphSet.FETAL_BLOOD] = Pair(lb, ub)
        ySetsBounds[GraphSet.FETAL_BLOOD_PRESSURE] = Pair(lb, ub)
        ySetsBounds[GraphSet.UTERINE_CONTRACTIONS] = Pair(lb, ub)
        ySetsBounds[GraphSet.FETAL_HEART_RATE] = Pair(lb, ub)

        for (dataSet: MutableMap.MutableEntry<GraphSet, Pair<Int, Int>> in ySetsBounds) {
            val randomData = Random.nextInt(dataSet.value.first, dataSet.value.second + 1)
            ySets[dataSet.key] = randomData
        }

        return ySets
    }
}