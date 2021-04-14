public class SmartDevice {

    private String name;
    private double location;
    private boolean switchedOn;

    public SmartDevice(String name, double location, boolean switchedOn) {
        this.name = name;
        this.location = location;
        this.switchedOn = switchedOn;
    }

    public void setLocation(double location)
    {
        this.location = location;
    }

    public double getLocation()
    {
        return this.location;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void switchOn()
    {
        this.switchedOn = true;
    }

    public void switchOff()
    {
        this.switchedOn = false;
    }

    public boolean isSwitchedOn()
    {
        return this.switchedOn;
    }

    @Override
    public String toString()
    {
        return String.format("%-15s %s", "Name:", this.name + "\n")
                + String.format("%-15s %s", "Location:", this.location + "\n")
                + String.format("%-15s %s", "Switched On:", this.switchedOn + "\n");
    }

}
