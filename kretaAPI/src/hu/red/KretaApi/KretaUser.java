package hu.red.KretaApi;

import hu.red.KretaApi.Utils.KretaTools;
import hu.red.KretaApi.objects.School;
import hu.red.KretaApi.objects.Tokens;

public class KretaUser {
    private final String USER_NAME;
    private final String PASSWORD;
    private final School SCHOOL;
    private Tokens tokens = null;
    private long expTime = 0;

    public KretaUser(String user_name, String password, School school) {
        USER_NAME = user_name;
        PASSWORD = password;
        SCHOOL = school;
    }

    public Tokens refreshTokens() {
        if (tokens != null)
            if (expTime > System.currentTimeMillis()) {
                tokens = KretaTools.APITools.updateTokens(SCHOOL.getInstituteCode(), tokens.getRefresh_token());
                expTime = System.currentTimeMillis() + tokens.getExpires_in() * 1000;
                return tokens;
            }
        tokens = KretaTools.APITools.getTokens(SCHOOL.getInstituteCode(), USER_NAME, PASSWORD);
        expTime = System.currentTimeMillis() + tokens.getExpires_in() * 1000;
        return tokens;
    }

    public String getTests() {
        return KretaTools.APITools.getTests(SCHOOL.getInstituteCode(), tokens.getAccess_token());
    }

    public School getSCHOOL() {
        return SCHOOL;
    }

    public Tokens getTokens() {
        return tokens;
    }

    public long getExpTime() {
        return expTime;
    }
}
