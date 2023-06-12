package org.fontys.json

import kotlinx.serialization.Serializable

@Serializable
data class GraphData(
    val x: Int,
    val fetalBlood: Int,
    val fetalBloodPressure: Int,
    val uterineContractions: Int,
    val fetalHeartRate: Int
)
