package com.gmail.kvederys.mindaugas.RGBModuleTest;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import java.util.concurrent.TimeUnit;

/**
 * <h2>KY-016 3-Color RGB LED Module Test Application</h2>
 * <p>
 * This application demonstrates how to control a KY-016 3-color RGB LED module using the Pi4J library.
 * It initializes the Pi4J context, configures digital output pins for Red, Green, and Blue LEDs,
 * and then cycles through various colors and color combinations to test the module.
 * </p>
 * <p>
 * <b>Hardware Setup:</b>
 * <ul>
 *     <li><b>GPIO17 [Pin 11]</b> >> RED LED control pin</li>
 *     <li><b>GPIO27 [Pin 13]</b> >> GREEN LED control pin</li>
 *     <li><b>GPIO22 [Pin 15]</b> >> BLUE LED control pin</li>
 *     <li><b>GND [Pin 6]</b>   >> GROUND connection</li>
 * </ul>
 * </p>
 * <p>
 * <b>Important Note:</b> Ensure that you have properly connected the RGB LED module to your Raspberry Pi
 * as described above. Using the correct GPIO pins and a common ground is crucial for the application to work correctly.
 * </p>
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        // Initialize Pi4J platform context.
        // This is the entry point to using Pi4J and should be created only once.
        final Context pi4j = Pi4J.newAutoContext();

        // Configure and create DigitalOutput instance for the RED LED.
        // Using Pi4J's DigitalOutput.Builder to define the properties of the RED LED pin.
        DigitalOutput red = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .id("red")                      // Unique ID for this digital output (optional)
                .name("Red LED")                // Descriptive name for this digital output (optional)
                .address(22)                    // BCM GPIO pin number for the Red LED (GPIO22)
                .shutdown(DigitalState.LOW)     // Set the pin state to LOW on program shutdown
                .initial(DigitalState.LOW)      // Set the initial pin state to LOW
                .build());                      // Build and create the DigitalOutput instance

        // Configure and create DigitalOutput instance for the GREEN LED.
        // Similar configuration as the RED LED, but using GPIO27 for the Green LED.
        DigitalOutput green = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .id("green")                    // Unique ID for this digital output (optional)
                .name("Green LED")              // Descriptive name for this digital output (optional)
                .address(27)                    // BCM GPIO pin number for the Green LED (GPIO27)
                .shutdown(DigitalState.LOW)     // Set the pin state to LOW on program shutdown
                .initial(DigitalState.LOW)      // Set the initial pin state to LOW
                .build());                      // Build and create the DigitalOutput instance

        // Configure and create DigitalOutput instance for the BLUE LED.
        // Similar configuration as RED and GREEN LEDs, but using GPIO17 for the Blue LED.
        DigitalOutput blue = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .id("blue")                     // Unique ID for this digital output (optional)
                .name("Blue LED")               // Descriptive name for this digital output (optional)
                .address(17)                    // BCM GPIO pin number for the Blue LED (GPIO17)
                .shutdown(DigitalState.LOW)     // Set the pin state to LOW on program shutdown
                .initial(DigitalState.LOW)      // Set the initial pin state to LOW
                .build());                      // Build and create the DigitalOutput instance

        // --- LED Testing Sequence ---

        // Test the RED LED individually.
        System.out.println("Turning on Red LED...");
        red.high();                             // Set RED LED pin to HIGH (turn LED on)
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        red.low();                              // Set RED LED pin to LOW (turn LED off)

        // Test the GREEN LED individually.
        System.out.println("Turning on Green LED...");
        green.high();                           // Set GREEN LED pin to HIGH (turn LED on)
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        green.low();                            // Set GREEN LED pin to LOW (turn LED off)

        // Test the BLUE LED individually.
        System.out.println("Turning on Blue LED...");
        blue.high();                            // Set BLUE LED pin to HIGH (turn LED on)
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        blue.low();                             // Set BLUE LED pin to LOW (turn LED off)

        // --- Color Combinations Testing ---

        // Test Yellow color (Red + Green).
        System.out.println("Turning on Yellow (Red + Green)...");
        red.high();                             // Turn RED LED on
        green.high();                           // Turn GREEN LED on
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        red.low();                              // Turn RED LED off
        green.low();                            // Turn GREEN LED off

        // Test Cyan color (Green + Blue).
        System.out.println("Turning on Cyan (Green + Blue)...");
        green.high();                           // Turn GREEN LED on
        blue.high();                            // Turn BLUE LED on
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        green.low();                            // Turn GREEN LED off
        blue.low();                             // Turn BLUE LED off

        // Test Magenta color (Red + Blue).
        System.out.println("Turning on Magenta (Red + Blue)...");
        red.high();                             // Turn RED LED on
        blue.high();                            // Turn BLUE LED on
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        red.low();                              // Turn RED LED off
        blue.low();                             // Turn BLUE LED off

        // Test White color (Red + Green + Blue).
        System.out.println("Turning on White (Red + Green + Blue)...");
        red.high();                             // Turn RED LED on
        green.high();                           // Turn GREEN LED on
        blue.high();                            // Turn BLUE LED on
        TimeUnit.SECONDS.sleep(2);              // Wait for 2 seconds
        red.low();                              // Turn RED LED off
        green.low();                            // Turn GREEN LED off
        blue.low();                             // Turn BLUE LED off

        // Shutdown Pi4J context.
        // This is important to release resources and stop Pi4J properly.
        pi4j.shutdown();
        System.out.println("Pi4J context shutdown.");
    }
}