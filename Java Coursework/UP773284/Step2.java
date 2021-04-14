import java.util.Scanner;

public class Step2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number of smart devices: ");
        int size = in.nextInt();

        SmartHome home = new SmartHome(size);

        for (int i = 0; i < size; i++)
        {
            System.out.print("Enter a name: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Enter a location: ");
            double location = in.nextDouble();
            System.out.print("Enter a boolean: ");
            boolean switchedOn = in.nextBoolean();

            home.insertDevice(name, location, switchedOn);
        }

        System.out.println(home.toString());

        // 2. Create SmartHome object - using the second constructor
        System.out.print("Enter a number of smart devices: ");
        size = in.nextInt();

        SmartDevice[] deviceArray = new SmartDevice[size];

        for (int i = 0; i < size; i++)
        {
            System.out.print("Enter a name: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Enter a location: ");
            double location = in.nextDouble();
            System.out.print("Enter a boolean: ");
            boolean switchedOn = in.nextBoolean();

            deviceArray[i] = new SmartDevice(name, location, switchedOn);
        }

        SmartHome home2 = new SmartHome(deviceArray);

        System.out.println(home2.toString());

        // 3. Get a device from the SmartHome object using an index and update switchedOn value

        System.out.print("Enter an index: ");
        int index = in.nextInt();

        SmartDevice device = home2.getDevice(index);

        if (device.isSwitchedOn())
            device.switchOff();
        else
            device.switchOn();

        System.out.println(home2.toString());

        // 4. Get a device from SmartHome object using a location and update SwitchedOn value

        System.out.print("Enter a location: ");
        double location = in.nextDouble();

        device = home2.getDevice(location);

        if (device.isSwitchedOn())
            device.switchOff();
        else
            device.switchOn();

        System.out.println(home2.toString());

        in.close();
    }
}
