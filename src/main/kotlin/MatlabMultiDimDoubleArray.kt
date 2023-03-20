//TODO: Add correct variables to enum, current vars are for testing

//Use for matlab variables that are a multidimensional double array
// ex. 2x10000, 3x350, 5x1000
enum class MatlabMultiDimDoubleArray(val type: String) {
    pin("pin"),
    psav("psav"),
    msegdata("msegdata"),
    mV("mV")
}