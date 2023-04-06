package cscd212classes.lab2;

public class Television extends
{
    private final boolean fourK; // private final data member if the Television is a 4K television
    private final String make; // private final data member for the Television make
    private final String model; // private final data member for the Television model
    private final int resolution; // private final data member for the Television resolution
    private final int screenSize; // private final data member for the Television screenSize
    private final boolean smart; // private final data member if the Television is a smart television

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getResolution() { return resolution; }
    public int getScreenSize() { return screenSize; }

    public Television(final String make, final String model,
                      final int resolution, final int screenSize,
                      final boolean smart) {
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;

        fourK = (resolution == 2160);
    }

    @Override
    public int compareTo(Television another) {
        if (another == null)
            throw new IllegalArgumentException("Illegal Argument");

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String toString()
    {
        return "string";
    }
}
