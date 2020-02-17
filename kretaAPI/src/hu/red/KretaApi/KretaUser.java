package hu.red.KretaApi;

import hu.red.KretaApi.Utils.KretaTools;
import hu.red.KretaApi.objects.School;
import hu.red.KretaApi.objects.Tokens;

public class KretaUser {
    private final String USER_NAME;
    private final String PASSWORD;
    private final School SCHOOL;
    private Tokens tokens = null;

    public KretaUser(String user_name, String password, School school) {
        USER_NAME = user_name;
        PASSWORD = password;
        SCHOOL = school;
    }

    public void refresh_bearer() {
        if (tokens == null) {
            tokens = KretaTools.APITools.getBearerTokens(SCHOOL.getInstituteCode(), USER_NAME, PASSWORD, "PASSWORD");

        }
    }

}
