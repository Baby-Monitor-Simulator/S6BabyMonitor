import com.mathworks.engine.MatlabEngine

fun main(args: Array<String>)  {
    val eng = MatlabEngine.startMatlab()
    val p = doubleArrayOf(1.0, -1.0, -6.0)
    val r: DoubleArray = eng.feval<DoubleArray>("roots", p)
    for (e in r) {
        println(e)
    }
    eng.close()
}