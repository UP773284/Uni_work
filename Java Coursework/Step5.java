import java.util.Scanner;

public class Step5
{
    public static void main(String[] args)
    {
        // 1.Light mode changes test .
        SmartHome home = new SmartHome(5);

        home.insertDevice(new SmartDevice("Device 1", 1.4, true));
        home.insertDevice(new SmartDevice("Device 2", 2.4, true));
        home.insertDevice(new SmartFridge(30, "Fridge 1", 3.4));
        home.insertDevice(new SmartLamp(new LightModes("NIGHT_MODE"), "Lamp 1", 4.4, true));
        home.insertDevice(new SmartLamp(new LightModes("SOFT_MODE"), "Lamp 2", 5.4, true));

        System.out.println("Lamps are at index 3 and 4.");
        System.out.print("Enter a lamp index: ");

        Scanner in = new Scanner(System.in);
        int index = in.nextInt();

        System.out.println("Lamps at index 3 and 4 are set at NIGHT_MODE and SOFT_MODE");

        SmartLamp lamp = (SmartLamp)home.getDevice(index);
        lamp.setLightMode(new LightModes("STANDARD_MODE"));
        System.out.println("Set chosen lamp to STANDARD_MODE");

        System.out.println(home);

        // 2. Light mode changes test 2

        System.out.println("Lamps are at index 3 and 4.");
        System.out.print("Enter a lamp index: ");

        index = in.nextInt();

        lamp = (SmartLamp)home.getDevice(index);
        lamp.setLightMode(new LightModes("NIGHT_MODE"));
        System.out.println("Set chosen lamp to NIGHT_MODE");

        System.out.println(home);

        // 3. Light mode changes test 3
        System.out.println("Lamps are at index 3 and 4.");
        System.out.print("Enter a lamp index: ");

        index = in.nextInt();

        lamp = (SmartLamp)home.getDevice(index);
        lamp.setLightMode(new LightModes("BRIGHT_MODE"));
        System.out.println("Trying to set chosen lamp to BRIGHT_MODE");

        System.out.println(home);

        in.close();

    }
}