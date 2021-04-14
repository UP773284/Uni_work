public class SmartLamp extends SmartDevice {
    private LightModes lightMode;

    public SmartLamp(LightModes mode, String name, double location, boolean switchedOn) {
        super(name, location, switchedOn);
        this.lightMode = mode;
    }

    public LightModes getLightMode() {
        return this.lightMode;
    }

    public void setLightMode(LightModes lightMode) {
        if (lightMode.toString() == "NIGHT_MODE")
            this.lightMode.setMode(new LightModes("NIGHT_MODE"));
        else if (lightMode.toString() == "SOFT_MODE")
            this.lightMode.setMode(new LightModes("SOFT_MODE"));
        else if (lightMode.toString() == "STANDARD_MODE")
            this.lightMode.setMode(new LightModes("STANDARD_MODE"));
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-15s %s", "Mode: ", this.lightMode + "\n");
    }
}
