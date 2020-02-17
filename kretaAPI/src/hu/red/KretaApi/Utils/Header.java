package hu.red.KretaApi.Utils;

public class Header {
    private final String key;
    private final String vaule;

    public Header(String key, String vaule) {
        this.key = key;
        this.vaule = vaule;
    }

    public String getKey() {
        return key;
    }

    public String getVaule() {
        return vaule;
    }
}
