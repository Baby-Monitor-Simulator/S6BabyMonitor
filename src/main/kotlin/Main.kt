import com.mathworks.engine.MatlabEngine

fun main()  {
    val matlab = MatlabConnection()

    //first run the model
    matlab.RunModel(MatlabModel.MainModel)

    //get single variable
    val singleVal = matlab.GetSingleVar(MatlabSingleVariable.oxcycle)
    println("")
    println("Single Value")
    println(singleVal)

    //get double array
    val doubleArray = matlab.GetDoubleArray(MatlabDoubleArray.fcavdata)
    println("")
    println("Single Dimensional Array")
    doubleArray.forEach {
        println(it)
    }

    //get multiDimDoubleArray
    val multiDimDoubleArray = matlab.GetMultiDimDoubleArray(MatlabMultiDimDoubleArray.msegdata)
    println("")
    println("Multi Dimensional Array")
    multiDimDoubleArray.forEach {outer->
        outer.forEach {inner->
            print("$inner,")
        }
        println("")
    }
    //when done always stop the matlab engine
    matlab.Stop()
}