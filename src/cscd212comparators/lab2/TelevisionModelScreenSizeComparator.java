package cscd212comparators.lab2;

import cscd212classes.lab2.Television;
import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television>
{
    @Override
    public int compare(final Television t1, final Television t2)
    {
        if (t1 == null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");

        int value = t1.getModel().compareTo(t2.getModel());
        if (value == 0)
            value = t1.getScreenSize() - t2.getScreenSize();

        return value;
    }
}
