import java.util.Scanner;

public class Step3
{
    public static void main(String[] args)
    {
        // 1. Register a new device
        int smartHomeSize = 2;
        SmartHome smartHome = new SmartHome(smartHomeSize);

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < smartHomeSize; i++)
        {
            smartHome.insertDevice("Room " + (i + 1), (i + 1) + 0.4, true);
        }

        System.out.println("Let's add a new SmartDevice now.");

        smartHome.insertDevice("Room 3", 17.4, true);

        System.out.println(smartHome.toString());

        // 2. Room level change

        smartHome.setAllInRoom(17, false);
        System.out.println("setAllInRoom executed.");
        System.out.println(smartHome.toString());

        // 3. Shutdown all devices.
        smartHome.shutdown();
        System.out.println("Shutdown executed.");
        System.out.println(smartHome.toString());

    }
}