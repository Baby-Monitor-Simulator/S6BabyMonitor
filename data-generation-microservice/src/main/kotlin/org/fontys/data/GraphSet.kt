package org.fontys.data

enum class GraphSet(val text: String, val unit: String) {
    FETAL_BLOOD("fetalBlood", "Po2"),
    FETAL_BLOOD_PRESSURE("fetalBloodPressure", "MAP"),
    UTERINE_CONTRACTIONS("uterineContractions", "UP"),
    FETAL_HEART_RATE("fetalHeartRate", "FHR"),

//    MAX_CONTRACTIONS_AMPLITUDE("Max Contractions Amplitude", "mmHg"),
//    CONTRACTION_DURATION("Contractions Duration", "s"),
//    TIME_BETWEEN_CONTRACTIONS("Time Between Contractions", "s"),
}