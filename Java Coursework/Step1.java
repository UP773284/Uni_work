import java.util.Scanner;

public class Step1 {

    public static void main(String args[]) {
        System.out.println("1. Create object");
        SmartDevice device = new SmartDevice("example", 17.3, false);
        System.out.println(device.toString());

        System.out.println("2. Create an array of SmartDevices");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.print("Enter a number: ");
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        //reader.close();

        SmartDevice arr[] = new SmartDevice[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = new SmartDevice("device " + (i+1), i + 0.7, false);
        }

        printArr(arr);

        System.out.println("3. Update the switchedOn​ ​value for one of the devices in the array");

        System.out.print("Enter a number: ");
        int index = reader.nextInt(); // Scans the next token of the input as an int.
        reader.close();

        if(arr[index].isSwitchedOn())
            arr[index].switchOff();
        else
            arr[index].switchOn();

        printArr(arr);
    }

    private static void printArr(SmartDevice[] arr) {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("-----------");
            System.out.println("- DEVICE " + (i+1) + "-");
            System.out.println("-----------");
            System.out.println(arr[i].toString());
            System.out.println("-----------");
        }
    }
}