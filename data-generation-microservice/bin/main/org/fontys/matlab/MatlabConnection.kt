package org.fontys.matlab

import com.mathworks.engine.MatlabEngine

class MatlabConnection(
    private val engine: MatlabEngine = MatlabEngine.startMatlab()
) : AutoCloseable {
    fun runModel(model: MatlabModel) = engine.eval(model.type)

    fun runModelAsync(model: MatlabModel) = engine.evalAsync(model.type)

    fun getSingleVar(varName: MatlabSingleVariable): Double = engine.getVariable(varName.type)

    fun getDoubleArray(varName: MatlabDoubleArray): DoubleArray = engine.getVariable(varName.type)

    fun getMultiDimDoubleArray(varName: MatlabMultiDimDoubleArray): Array<DoubleArray> =
        engine.getVariable(varName.type)

    fun putSingleVar(varName: MatlabSingleVariable, varVal: Double): Unit = engine.putVariable(varName.type, varVal)

    fun putDoubleArray(varName: MatlabDoubleArray, varVal: DoubleArray): Unit = engine.putVariable(varName.type, varVal)

    fun putMultiDimDoubleArray(varName: MatlabMultiDimDoubleArray, varVal: Array<DoubleArray>): Unit = engine.putVariable(varName.type, varVal)

    override fun close() = engine.close()
}
