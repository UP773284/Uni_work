public class SmartHome
{
    private SmartDevice[] smartDeviceArray;

    // First constructor
    public SmartHome(int size)
    {
        smartDeviceArray = new SmartDevice[size];
    }

    // Second constructor
    public SmartHome(SmartDevice[] array)
    {
        this.smartDeviceArray = array;
    }

    public void insertDevice(SmartDevice device)
    {
        int i = 0;

        while (i < smartDeviceArray.length && this.smartDeviceArray[i] != null)
            i++;

        if (i < smartDeviceArray.length)
            // Insert the device inside the array
            this.smartDeviceArray[i] = device;
        else
            addDevice(device);
    }

    public void insertDevice(String name, double location, boolean switchedOn)
    {
        SmartDevice device = new SmartDevice(name, location, switchedOn);
        insertDevice(device);
    }

    public SmartDevice getDevice(int index)
    {
        if (index >= 0 && index < this.smartDeviceArray.length)
        {
            return this.smartDeviceArray[index];
        }

        else
            return null;
    }

    public SmartDevice getDevice(double location)
    {
        for (int i = 0; i < this.smartDeviceArray.length; i++)
        {
            if (this.smartDeviceArray[i].getLocation() == location)
                return this.smartDeviceArray[i];
        }

        return null;
    }

    public void toggle(double location)
    {
        SmartDevice device;
        if ((device = getDevice(location)) != null)
        {
            if (device.isSwitchedOn())
                device.switchOff();
            else
                device.switchOn();
        }
    }

    public void addDevice(SmartDevice device)
    {
        if (this.smartDeviceArray[smartDeviceArray.length - 1] != null) // create temp array if is fulll
        {
            SmartDevice[] temp = new SmartDevice[smartDeviceArray.length + 1];

            for (int i = 0; i < this.smartDeviceArray.length; i++)
            {
                temp[i] = this.smartDeviceArray[i];
            }

            temp[smartDeviceArray.length] = device;

            this.smartDeviceArray = temp;
        }

        else
        {
            insertDevice(device);
        }
    }

    public void setAllInRoom(int location, boolean switchedOn)
    {
        for (int i = 0; i < this.smartDeviceArray.length; i++)
        {
            if (((int)this.smartDeviceArray[i].getLocation()) == location) // look into this later
            {
                if (switchedOn)
                    this.smartDeviceArray[i].switchOn();
                else
                    this.smartDeviceArray[i].switchOff();
            }
        }
    }

    public void shutdown()
    {
        for (int i = 0; i < smartDeviceArray.length; i++)
        {
            this.smartDeviceArray[i].switchOff();
        }
    }

    @Override
    public String toString()
    {
        String s = "";
        for (int i = 0; i < this.smartDeviceArray.length; i++)
        {
            if (this.smartDeviceArray[i] != null)
            {

                s += "----------\n";
                s += "-DEVICE " + (i+1) + "-\n";
                s += "----------\n";
                s += this.smartDeviceArray[i].toString();
                s += "----------\n";
            }
        }

        return s;
    }
}