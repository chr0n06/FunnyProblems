/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg711enigma;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxime
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("0.00");
        for (Double i = 7.11; i > 0; i -= 0.01) {
            for (Double j = 7.11; j > 0.00; j += 0.01) {
                for (Double k = 7.11; k > 0.00; k -= 0.01) {
                    for (Double l = 7.11; l > 0 ; l -= 0.01) {
                        Double addition = i + j + k + l;
                        Double multiplication = i * j* k * l;
                       
                        //System.out.println(df.format(addition) + " " + df.format(multiplication));
                        if ((df.format(addition).equals("7,11")) && (df.format(j).equals("7,11"))) {
                            System.out.println("i = " + i
                                    + "j = " + "k = " + k + "l = " + l);
                        }//if
                    }//for4

                }//for3

            }//for2

        }//for1

    }//main
    /*
    public List<Double> process(List<Double> variables){
        for (Double variable : variables) {
            
        }
        return process(variables);
    }
*/
}//class
