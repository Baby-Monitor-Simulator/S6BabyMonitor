import com.mathworks.engine.MatlabEngine

fun main()  {
    val eng = MatlabEngine.startMatlab()
    val p = doubleArrayOf(1.0, -1.0, -6.0)
    val r: DoubleArray = eng.feval("roots", p)
    for (e in r) {
        println(e)
    }

    val i1: Short = 3
    val i2: Short = 5
    val i3: Short = 10

    val area: Int = eng.feval("calcArea", i1, i2)
    val cube: Int = eng.feval("calcCube", i1, i2, i3)
    val pow: Int = eng.feval("calcPower", i3, i1)

    println(area)
    println(cube)
    println(pow)


    eng.evalAsync("FMPmodel")

    eng.close()
}