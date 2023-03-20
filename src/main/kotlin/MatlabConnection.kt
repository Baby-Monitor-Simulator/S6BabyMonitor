import com.mathworks.engine.MatlabEngine
import com.mathworks.toolbox.javabuilder.MWArray
import com.mathworks.toolbox.javabuilder.MWCellArray
import java.util.Vector

//https://de.mathworks.com/help/matlab/matlab_external/start-matlab-session-from-java.html
//https://de.mathworks.com/help/matlab/matlab_external/data-type-conversions.html#bvcnn_p
//https://de.mathworks.com/help/matlab/apiref/com.mathworks.engine.matlabengine.html
//https://de.mathworks.com/help/javabuilder/MWArrayAPI/overview-summary.html
//https://de.mathworks.com/products/compiler/matlab-runtime.html


class MatlabConnection {
    private lateinit var engine: MatlabEngine

    fun RunModel(model: MatlabModel){
        engine = MatlabEngine.startMatlab()
        engine.eval(model.type)
    }

    fun Stop(){
        engine.close()
    }

    //use for single value variable
    fun GetSingleVar(varName: MatlabSingleVariable): Float{
        return engine.getVariable(varName.type)
    }

    //use for single dimensional double array -> matlab 1x10000 double
    fun GetDoubleArray(varName: MatlabDoubleArray): DoubleArray {
        return engine.getVariable(varName.type)
    }

    //use for multidimensional double array
    fun GetMultiDimDoubleArray(varName: MatlabMultiDimDoubleArray): Array<DoubleArray>{
        return engine.getVariable(varName.type)
    }
}