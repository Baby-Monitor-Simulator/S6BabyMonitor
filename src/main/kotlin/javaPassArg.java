import com.mathworks.engine.*;

public class javaPassArg{
    public static void main() throws Exception{
        MatlabEngine eng = MatlabEngine.startMatlab();
        double[] p =  {1.0, -1.0, -6.0};
        double[] r = eng.feval("roots", p);
        for (double e: r) {
            System.out.println(e);
        }
        eng.close();
    }
}