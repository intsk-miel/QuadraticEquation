package databases.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Equation {

    //creating model (sql table)

    private static final Logger LOGGER = LogManager.getLogger(Equation.class);
    private Long id;
    private double A;
    private double B;
    private double C;


    public Equation() {    //default constructor
    }

    public Equation(Long id, double a, double b, double c) {    // constructor
        this.id = id;
        A = a;
        B = b;
        C = c;
    }

 // creating setters and getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public double d() {
        return (B * B) - (4 * A * C);
    }   //method to calculate discriminant

    public double re() {
        return -B / (2 * A);
    }   //method to calculate real numbers
    public double im() {
        return Math.sqrt(Math.abs(d()))/ (2 * A);
    }  //method to calculate imaginary numbers

    @Override   // overriding to string
    public String toString() {
        return "Equation {" + "\n" +
                "id = " + id + "\n" +
                "A = " + A + "\n" +
                "B = " + B + "\n" +
                "C = " + C + "\n";
    }
}




