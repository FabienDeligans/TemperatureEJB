/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conv;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class Convertir {

    public double ConvertirCelciusToFahrenheit(double t) {
        double fahrenheit;
        fahrenheit = 9.0 / 5.0 * t + 32;
        return fahrenheit;
    }

    public double convertirFahrenheitToCelcius(double t) {
        double celcius;
        celcius = (t - 32) * 5.0 / 9.0;
        return celcius;
    }
}
