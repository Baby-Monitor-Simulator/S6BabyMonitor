import com.mathworks.engine.MatlabEngine

fun main()  {
    val eng = MatlabEngine.startMatlab()
    val p = doubleArrayOf(1.0, -1.0, -6.0)
    val r: DoubleArray = eng.feval("roots", p)
    for (e in r) {
        println(e)
    }
    eng.close()
}