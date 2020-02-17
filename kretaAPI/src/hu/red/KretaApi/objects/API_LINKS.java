package hu.red.KretaApi.objects;

public class API_LINKS {
    private final String
            GlobalMobileApiUrlDEV,
            GlobalMobileApiUrlTEST,
            GlobalMobileApiUrlUAT,
            GlobalMobileApiUrlPROD;

    public API_LINKS(String globalMobileApiUrlDEV, String globalMobileApiUrlTEST, String globalMobileApiUrlUAT, String globalMobileApiUrlPROD) {
        GlobalMobileApiUrlDEV = globalMobileApiUrlDEV;
        GlobalMobileApiUrlTEST = globalMobileApiUrlTEST;
        GlobalMobileApiUrlUAT = globalMobileApiUrlUAT;
        GlobalMobileApiUrlPROD = globalMobileApiUrlPROD;
    }

    public String getGlobalMobileApiUrlDEV() {
        return GlobalMobileApiUrlDEV;
    }

    public String getGlobalMobileApiUrlTEST() {
        return GlobalMobileApiUrlTEST;
    }

    public String getGlobalMobileApiUrlUAT() {
        return GlobalMobileApiUrlUAT;
    }

    public String getGlobalMobileApiUrlPROD() {
        return GlobalMobileApiUrlPROD;
    }
}
