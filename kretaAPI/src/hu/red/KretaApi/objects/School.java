package hu.red.KretaApi.objects;

public class School {
    //region Variables
    private final String instituteCode;
    private final String name;
    private final String url;
    private final String city;
    private final String advertisingUrl;
    private final FeatureToggleSet featureToggleSet;
    private int instituteId;
    //endregion

    public School(int instituteId, String instituteCode, String name, String url, String city, String advertisingUrl, FeatureToggleSet featureToggleSet) {
        this.instituteId = instituteId;
        this.instituteCode = instituteCode;
        this.name = name;
        this.url = url;
        this.city = city;
        this.advertisingUrl = advertisingUrl;
        this.featureToggleSet = featureToggleSet;
    }

    //region getters
    public int getInstituteId() {
        return instituteId;
    }

    public String getInstituteCode() {
        return instituteCode;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getCity() {
        return city;
    }

    public String getAdvertisingUrl() {
        return advertisingUrl;
    }

    public FeatureToggleSet getFeatureToggleSet() {
        return featureToggleSet;
    }
    //endregions

    @Override
    public String toString() {
        return name;
    }

    public class FeatureToggleSet {
    }
}
