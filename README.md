## Pi4J RGB LED Module Test (KY-016)

This Java application demonstrates how to control a KY-016 3-Color RGB LED module using the Pi4J library on a Raspberry Pi.

**Purpose:**

The `App.java` class provides a simple example of interacting with an RGB LED module connected to a Raspberry Pi using Pi4J v2. It showcases how to initialize Pi4J, configure digital output pins for controlling the Red, Green, and Blue LEDs within the module, and then cycle through basic colors and color combinations. This serves as a starting point for anyone wanting to experiment with RGB LEDs and Pi4J.

**Functionality:**

* **Initialization:**  Sets up the Pi4J context (`Pi4J.newAutoContext()`) which is essential for interacting with Raspberry Pi hardware.
* **GPIO Configuration:** Configures three digital output pins (GPIO 22, 27, and 17 in BCM numbering) to control the Red, Green, and Blue LEDs respectively.  It uses the Pi4J `DigitalOutput.Builder` for a clear and structured configuration.
* **Individual LED Testing:**  Turns on each LED (Red, Green, Blue) individually for 2 seconds to verify basic functionality.
* **Color Combination Testing:** Demonstrates creating common colors by activating multiple LEDs simultaneously:
    * Yellow (Red + Green)
    * Cyan (Green + Blue)
    * Magenta (Red + Blue)
    * White (Red + Green + Blue)
* **Shutdown:** Properly shuts down the Pi4J context (`pi4j.shutdown()`) to release resources after the program execution.

**Hardware Requirements:**

* **Raspberry Pi:** Any Raspberry Pi model supported by Pi4J.
* **KY-016 3-Color RGB LED Module:**  A common and inexpensive RGB LED module.
* **Wiring:** Jumper wires to connect the RGB LED module to the Raspberry Pi GPIO pins as follows:
    * **RED:**  GPIO17 (Pin 11)
    * **GREEN:** GPIO27 (Pin 13)
    * **BLUE:**  GPIO22 (Pin 15)
    * **GND:**   Ground (Pin 6 or any other GND pin)

**Software Requirements:**

* **Java Development Kit (JDK):**  Required to compile and run the Java code.
* **Pi4J Library:**  This project is built using Pi4J v2. You'll need to include Pi4J as a dependency in your project (e.g., using Maven or Gradle).
* **Operating System:** Raspberry Pi OS (or any OS supported by Pi4J).

**How to Use:**

1. **Clone this repository.**
2. **Ensure you have Pi4J v2 set up in your project.** If you are using Maven, include the Pi4J core dependency in your `pom.xml`.
3. **Compile the `App.java` class.**
4. **Connect the KY-016 RGB LED module to your Raspberry Pi as described above.**
5. **Run the compiled `App` class on your Raspberry Pi.**

**Important Notes:**

* **GPIO Pin Numbering:** The code uses BCM (Broadcom) GPIO pin numbering. Make sure your wiring matches this numbering scheme.
* **LED Module Type:** This code is specifically designed for common cathode RGB LED modules like KY-016 where applying HIGH voltage turns the LED ON. If you are using a common anode module, you may need to adjust the logic (e.g., use `DigitalState.HIGH` for `shutdown` and `initial`, and `low()` to turn the LED on).
* **Permissions:** Ensure that the user running the Java application has the necessary permissions to access the Raspberry Pi's GPIO pins.

**Keywords:** Raspberry Pi, Pi4J, RGB LED, KY-016, GPIO, Java, IoT, Hardware, Example, Tutorial, Digital Output.
