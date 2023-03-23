import com.mathworks.engine.MatlabEngine

class MatlabConnection(
    private var engine: MatlabEngine = MatlabEngine.startMatlab()
) {

    fun runModel(model: MatlabModel) = engine.eval(model.type)

    fun stop() = engine.close()

    fun getSingleVar(varName: MatlabSingleVariable) = engine.getVariable<Double>(varName.type)

    fun getDoubleArray(varName: MatlabDoubleArray) = engine.getVariable<DoubleArray>(varName.type)

    fun getMultiDimDoubleArray(varName: MatlabMultiDimDoubleArray) = engine.getVariable<Array<DoubleArray>>(varName.type)
}
