package databases;

import databases.models.Equation;
import databases.services.batiservices.EquationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileWriter;
import java.io.IOException;


public class MainMyBatis {
    private static final Logger LOGGER = LogManager.getLogger(MainMyBatis.class); //loggers
    public static void main(String[] args) {
       EquationService equationService = new EquationService();  //creating equation service object
            try{
                FileWriter write = new FileWriter("Equation.txt", true);  // creating file to write results
                for (Equation q : equationService.getAllEquation()) {   //calculates every data
                    write.write("Coefficients: A = " + q.getA() + "\t" + " B = " + q.getB() + "\t" + " C = " + q.getC()  + "\n"); //  writing coefficients in txt file
                    if (q.d() >= 0) {
                        write.write("X1 = " + (q.re() - q.im()) + "\n");
                        write.write("X2 = " + (q.re() + q.im()) + "\n");  // if discriminant will be >= 0 it will solve this
                    } else {
                        write.write("X1 = " + q.re() + " -i* " + q.im() + "\n");
                        write.write("X2 = " + q.re() + " +i* " + q.im() + "\n"); // else these will be solved
                    }
                }
                write.close(); //closing file
            } catch (IOException e) {
                LOGGER.info(e); // catches exceptions for file opening
            }
    }
}
