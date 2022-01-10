package xmlparser.model;

public class WeatherModel {

    private final String region;
    private final String period;
    private final String city;
    private final String situation;
    private final String max;
    private final String min;

    public WeatherModel(String region, String period, String city, String situation, String max, String min) {
        this.region = region;
        this.period = period;
        this.city = city;
        this.situation = situation;
        this.max = max;
        this.min = min;
    }

    public String getRegion() {
        return region;
    }

    public String getPeriod() {
        return period;
    }

    public String getCity() {
        return city;
    }

    public String getSituation() {
        return situation;
    }

    public String getMax() {
        return max;
    }

    public String getMin() {
        return min;
    }
}
