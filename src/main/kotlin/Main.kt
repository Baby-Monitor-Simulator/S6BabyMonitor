import java.util.*

fun main()  {
    val matlab = MatlabConnection()

    matlab.runModel(MatlabModel.MainModel)

    val singleVal = matlab.getSingleVar(MatlabSingleVariable.oxcycle)
    println("")
    println("Single Value")
    println(singleVal)

    val doubleArray = matlab.getDoubleArray(MatlabDoubleArray.fcavdata)
    println("")
    println("Single Dimensional Array")
    println(doubleArray.joinToString(","))

    val multiDimDoubleArray = matlab.getMultiDimDoubleArray(MatlabMultiDimDoubleArray.msegdata)
    println("")
    println("Multi Dimensional Array")
    println(Arrays.deepToString(multiDimDoubleArray))

    matlab.stop()
}