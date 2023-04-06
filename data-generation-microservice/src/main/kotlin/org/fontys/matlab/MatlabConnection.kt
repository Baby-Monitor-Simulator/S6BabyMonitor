package org.fontys.matlab

import com.mathworks.engine.MatlabEngine

class MatlabConnection(
    private val engine: MatlabEngine = MatlabEngine.startMatlab()
) : AutoCloseable {
    fun runModel(model: MatlabModel) = engine.eval(model.type)

    fun getSingleVar(varName: MatlabSingleVariable): Double = engine.getVariable(varName.type)

    fun getDoubleArray(varName: MatlabDoubleArray): DoubleArray = engine.getVariable(varName.type)

    fun getMultiDimDoubleArray(varName: MatlabMultiDimDoubleArray): Array<DoubleArray> =
        engine.getVariable(varName.type)

    override fun close() = engine.close()
}
