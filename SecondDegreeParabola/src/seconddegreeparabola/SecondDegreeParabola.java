/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seconddegreeparabola;

import BLL.Service;
import Model.Value;

/**
 *
 * @author max_p
 */
public class SecondDegreeParabola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Service service = new Service();

        /**
         * From Equation : y = -2x^2+4x+1 Extract a, b, c values to => a = -2 b
         * = 4 c = 1 and put them inside the solutionner below,
         *
         * @param Value
         */
        Value value = new Value(3, 4, 0);
        service.solution(value);

        /**
         * If you need only one coordinate from an X value just enter the value
         * and the X value you want.
         *
         * @param Value
         * @param double
         */
        service.showingNorthingFromX(value, 2.0);
    }
}
