package org.fontys.json

data class SettingsPatch(
    val fetalHeartRate: Short,
    val fetalBloodSaturation: Short,
    val fetalBloodPressure: Short,
    val umbilicalArteryBloodFlow: Short,
    val uterineContractions: Short,
)
