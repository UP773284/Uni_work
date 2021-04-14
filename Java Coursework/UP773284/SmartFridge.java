public class SmartFridge extends SmartDevice
{
    private double currentTemperature;

    public SmartFridge(double currentTemperature, String name, double location)
    {
        super(name, location, true);
        this.currentTemperature = currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }

    public double getCurrentTemperature()
    {
        return this.currentTemperature;
    }

    public void increment()
    {
        this.currentTemperature++;
    }

    public void decrement()
    {
        this.currentTemperature--;
    }

    @Override
    public void switchOff() {}

    @Override
    public String toString()
    {
        return super.toString() + String.format("%-15s %s", "Current Temperature:", this.currentTemperature + "\n");
    }
}