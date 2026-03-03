package org.example;

public class Main {

    public static void main(String[] args) {

        TemperatureConverter converter = new TemperatureConverter();

        double kelvin = 300.0;
        double celsius = converter.kelvinToCelsius(kelvin);
        double fahrenheit = converter.celsiusToFahrenheit(celsius);

        System.out.println("Kelvin: " + kelvin);
        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Extreme Temperature? " + converter.isExtremeTemperature(celsius));
    }
}