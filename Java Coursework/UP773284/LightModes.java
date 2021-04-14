public class LightModes
{
    private String mode;

    public LightModes(String mode)
    {
        this.mode = mode;
    }

    public void setMode(LightModes mode) {
        if (mode.toString() == "NIGHT_MODE")
            this.mode = "NIGHT_MODE";
        else if (mode.toString() == "SOFT_MODE")
            this.mode = "SOFT_MODE";
        else if (mode.toString() == "STANDARD_MODE")
            this.mode = "STANDARD_MODE";
    }

    @Override
    public String toString()
    {
        return this.mode;
    }
}