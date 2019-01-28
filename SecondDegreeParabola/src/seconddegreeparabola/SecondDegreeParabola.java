/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seconddegreeparabola;

import BLL.Service;
import Model.Values;

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
        Values values = new Values(-2, 4, 1);
        service.discriminant(values);
    }
}
