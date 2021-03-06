/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Model.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author max_p
 */
public class Service {
    int rangeDrawingParabola = 10;
    
    public void solution(Value value) {
        discriminant(value);
    }

    public void discriminant(Value value) {
        //Formula : discriminant = b^2-4ac
        Double discriminant = Math.pow(value.getB(), 2) - ((4 * value.getA()) * value.getC());

        if (discriminant < 0) {
            System.out.println("Parabola never touch the 'x' axis cause discriminant " + discriminant + " is lower then zero !");
            drawingParabola(value, rangeDrawingParabola);
        } else if (discriminant == 0) {
            System.out.println("Parabola touch the 'x' axis only once cause discriminant " + discriminant + " is equal to zero !");
            findingSummit(value);
            drawingParabola(value, rangeDrawingParabola);
        } else if (discriminant > 0) {
            System.out.println("Parabola touch the 'x' axis twice time cause discriminant " + discriminant + " is greater then zero !");
            findingXsWhenYEqualZero(value);
            drawingParabola(value, rangeDrawingParabola);
        }//if
    }

    private void findingXsWhenYEqualZero(Value value) {
        List<Double> data = new ArrayList<>();
        double x1;
        double x2;

        //Formula : x1 = (b + √b^2-4ac)/2a
        x1 = (Math.negateExact(value.getB())
                + Math.sqrt(
                        Math.pow(value.getB(), 2) - ((4 * value.getA()) * value.getC())
                )) / (2 * value.getA());
        System.out.println("X1 = " + x1);

        //Formula : x2 = (b - √b^2-4ac)/2a
        x2 = (Math.negateExact(value.getB())
                - Math.sqrt(
                        Math.pow(value.getB(), 2) - ((4 * value.getA()) * value.getC())
                )) / (2 * value.getA());
        System.out.println("X2 = " + x2);

        findingSummit(value);
    }//findingXsWhenYEqualZero

    private void findingSummit(Value value) {
        //Formula : Summit x0 = -b/2a
        double x0;
        double y0;

        x0 = (Math.negateExact(value.getB())) / (2 * value.getA());
        y0 = (value.getA() * Math.pow(x0, 2)) + (value.getB() * x0) + value.getC();

        System.out.println("Summit coordinate = (" + x0 + ", " + y0 + ")");
    }//findingSummit

    public Map<Integer, Double> drawingParabola(Value value, int range) {
        Map<Integer, Double> coordinateTab = new TreeMap<Integer, Double>();
        
        for (int i = Math.negateExact(range); i < range; i++) {
            coordinateTab.put(i, ((value.getA() * Math.pow(i, 2)) + (value.getB() * i) + value.getC()));
            System.out.println("(x,y) = (" + i + ", " + ((value.getA() * Math.pow(i, 2)) + (value.getB() * i) + value.getC()) + ")");
        }
        
        return coordinateTab;
    }

    public void showingNorthingFromX(Value value, Double x) {
        System.out.println("(x,y) = (" + x + ", " + ((value.getA() * Math.pow(x, 2)) + (value.getB() * x) + value.getC()) + ")");
    }
    /*
    public void showingEasthingFromY(Value value, Double y) {
        System.out.println("(x,y) = (" + y + ", " + ((value.getA() * Math.pow(y, 2)) + (value.getB() * y) + value.getC()) + ")");
    }
*/
}//Service
