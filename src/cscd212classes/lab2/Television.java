package cscd212classes.lab2;

public class Television implements Comparable<Television>
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

    public Television(final String model,
                      final boolean smart, final int screenSize,
                      final int resolution, final String make)
    {
        this(make, model, smart, screenSize, resolution);
    }

    public Television(final String make, final String model,
                      final boolean smart, final int screenSize,
                      final int resolution)
    {
        if (make == null || make.equals("") || model == null || model.equals("") ||
                screenSize < 32 || resolution < 720)
        {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }

        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;

        fourK = (resolution == 2160);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this) return true;
        //if (o == null) return false;
        if (!(o instanceof Television t)) return false;

        return make.equals(t.getMake()) && model.equals(t.getModel()) &&
                resolution == t.getResolution() && screenSize == t.getScreenSize();
    }

    @Override
    public int hashCode()
    {
        return make.hashCode() + model.hashCode() + resolution +
                Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }

    public String toString()
    {
        //No Smart or 4K Example: TCL-NS32R, 32 inch tv with 720 resolution
        //Smart and 4K Example: Samsung-SM85U, 85 inch smart tv with 4K resolution

        return make + "-" + model + ", " + screenSize + " inch " +
                (smart? "smart ": "") + "tv with " + (fourK? "4K": resolution) + " resolution";
    }

    @Override
    public int compareTo(Television another)
    {
        if (another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");

        int value = make.compareTo(another.getMake());
        if (value == 0)
            value = model.compareTo(another.getModel());
        if (value == 0)
            value = screenSize - another.getScreenSize();

        return value;
    }
}