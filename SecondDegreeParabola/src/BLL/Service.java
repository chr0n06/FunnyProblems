/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Model.Values;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max_p
 */
public class Service {

    public void discriminant(Values values) {
        Double discriminant = Math.pow(values.getB(), 2) - ((4 * values.getA()) * values.getC());

        //Formula : discriminant = b^2-4ac
        if (discriminant < 0) {
            System.out.println("Parabola never touch the 'x' axis cause discriminant " + discriminant + " is lower then zero !");
        } else if (discriminant == 0) {
            System.out.println("Parabola touch the 'x' axis only once cause discriminant " + discriminant + " is equal to zero !");
            findingSummit(values);
        } else if (discriminant > 0) {
            System.out.println("Parabola touch the 'x' axis twice time cause discriminant " + discriminant + " is greater then zero !");
            solutionningEquation(values);
        }//if
    }

    private void solutionningEquation(Values values) {
        List<Double> data = new ArrayList<>();
        double x1;
        double x2;

        //Formula : x1 = (b + √b^2-4ac)/2a
        x1 = (Math.negateExact(values.getB())
                + Math.sqrt(
                        Math.pow(values.getB(), 2) - ((4 * values.getA()) * values.getC())
                )) / (2 * values.getA());
        System.out.println("X1 = " + x1);

        //Formula : x2 = (b - √b^2-4ac)/2a
        x2 = (Math.negateExact(values.getB())
                - Math.sqrt(
                        Math.pow(values.getB(), 2) - ((4 * values.getA()) * values.getC())
                )) / (2 * values.getA());
        System.out.println("X2 = " + x2);

        findingSummit(values);

    }//solutionningEquation
    
    private void findingSummit(Values values) {
        //Formula : Summit x0 = -b/2a
        double x0;
        double y0;

        x0 = (Math.negateExact(values.getB())) / (2 * values.getA());
        y0 = (values.getA() * Math.pow(x0, 2)) + (values.getB() * x0) + values.getC();

        System.out.println("Summit coordinate = (" + x0 + ", " + y0 + ")");
    }//findingSummit
}
