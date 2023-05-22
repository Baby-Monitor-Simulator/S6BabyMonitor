package org.fontys.json

data class Session(
    val id: String,
    val fetalHeartRate: Short,
    val fetalBloodSaturation: Short,
    val fetalBloodPressure: Short,
    val umbilicalArteryBloodFlow: Short,
    val uterineContractions: Short,
)
