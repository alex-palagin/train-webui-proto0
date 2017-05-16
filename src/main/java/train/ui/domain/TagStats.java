package train.ui.domain;

/**
 * Created by apalagin on 5/12/2017.
 */
public class TagStats {
    private String uniques;
    private String minimum;
    private String maximum;
    private String average;
    private String median;

    public TagStats(String uniques, String minimum, String maximum, String average, String median) {
        this.uniques = uniques;
        this.minimum = minimum;
        this.maximum = maximum;
        this.average = average;
        this.median = median;
    }

    public String getUniques() {
        return uniques;
    }

    public String getMinimum() {
        return minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public String getAverage() {
        return average;
    }

    public String getMedian() {
        return median;
    }
}
