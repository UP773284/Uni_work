import java.util.Scanner;

public class Step4
{
    public static void main(String[] args)
    {
        // Create SmartHome object
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of SmartHome: ");
        int size = in.nextInt();
        SmartHome home = new SmartHome(size);

        boolean smartFridgeInstance = true;

        for (int i = 0; i < size; i++)
        {
            if (smartFridgeInstance)
            {
                SmartFridge fridge = new SmartFridge(30, "Fridge " + i, i + 0.4);
                home.insertDevice(fridge);
                smartFridgeInstance = false;
            }

            else
            {
                SmartDevice device = new SmartDevice("Device " + i, i + 0.4, false);
                home.insertDevice(device);
                smartFridgeInstance = true;
            }
        }

        System.out.println(home);

        // 2.Create SmartHome object - using the second constructor.
        System.out.print("Specify the number of items to be held in the array: ");
        int numberOfItems = in.nextInt();
        SmartDevice[] arrayDevice = new SmartDevice[numberOfItems];

        for (int i = 0; i < size; i++)
        {
            if (smartFridgeInstance)
            {
                SmartFridge fridge = new SmartFridge(30, "Fridge " + i, i + 0.4);
                arrayDevice[i] = fridge;
                smartFridgeInstance = false;
            }

            else
            {
                SmartDevice device = new SmartDevice("Device " + i, i + 0.4, false);
                arrayDevice[i] = device;
                smartFridgeInstance = true;
            }
        }

        SmartHome home2 = new SmartHome(arrayDevice);
        System.out.println(home2);

        // 3.Using the shutdown() method, attempt to switch off a fridge.

        home2.shutdown();

        System.out.println("Shutdown executed");
        System.out.println(home2);

        // 4.Increment and decrement temperature.
        // Because of statement boolean smartFridgeInstance = true,
        // the first device in the SmartHome will always be a fridge
        // We use the home instance

        SmartDevice fridge1 = home.getDevice(0);

        ((SmartFridge) fridge1).increment();
        System.out.println("Temperature incremented.");
        System.out.println(home);

        ((SmartFridge) fridge1).decrement();
        System.out.println("Temperature decremented.");
        System.out.println(home);

        in.close();
    }
}