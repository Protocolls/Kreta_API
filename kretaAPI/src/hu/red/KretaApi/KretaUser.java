package hu.red.KretaApi;

import hu.red.KretaApi.Utils.Kreta;
import hu.red.KretaApi.objects.*;

import java.util.Date;

public class KretaUser {
    //region Variables
    private final String USER_NAME;
    private final String PASSWORD;
    private final School SCHOOL;
    private Tokens tokens = null;
    private long expTime = 0;
    //endregion

    public KretaUser(String user_name, String password, School school) {
        USER_NAME = user_name;
        PASSWORD = password;
        SCHOOL = school;
    }

    //region tokens....
    public void refreshTokens() {
        if (tokens != null)
            if (expTime < System.currentTimeMillis()) {
                tokens = Kreta.Tools.updateTokens(SCHOOL.getInstituteCode(), tokens.getRefresh_token());
                expTime = System.currentTimeMillis() + tokens.getExpires_in() * 1000;
                return;
            } else return;
        tokens = Kreta.Tools.getTokens(SCHOOL.getInstituteCode(), USER_NAME, PASSWORD);
        expTime = System.currentTimeMillis() + tokens.getExpires_in() * 1000;

    }

    public void setTokens(Tokens tokens) {
        this.tokens = tokens;
    }

    public Tokens forceRefreshTokens() {
        return tokens = Kreta.Tools.getTokens(SCHOOL.getInstituteCode(), USER_NAME, PASSWORD);
    }

    //endregion
    //region getTest
    public Test[] getTests() {
        return Kreta.Tools.getTests(SCHOOL.getInstituteCode(), tokens.getAccess_token());
    }

    public Test[] getTests(Date from, Date to) {
        return Kreta.Tools.getTests(SCHOOL.getInstituteCode(), tokens.getAccess_token(), from, to);
    }

    //endregion
    //region getUserDate
    public UserData getUserData() {
        return Kreta.Tools.getStudentInfos(SCHOOL.getInstituteCode(), tokens.getAccess_token());
    }

    public UserData getUserData(Date from, Date to) {
        return Kreta.Tools.getStudentInfos(SCHOOL.getInstituteCode(), tokens.getAccess_token(), from, to);
    }
    //endregion

    public Lesson[] getLessons(Date from, Date to) {
        return Kreta.Tools.getTimetable(SCHOOL.getInstituteCode(), tokens.getAccess_token(), from, to);
    }

    public Homework[] getHomeworks(int TeacherHomeworkId) {
        return Kreta.Tools.getHomeworks(SCHOOL.getInstituteCode(), tokens.getAccess_token(), TeacherHomeworkId);
    }

    //region SimpleGetters
    public School getSCHOOL() {
        return SCHOOL;
    }

    public Tokens getTokens() {
        return tokens;
    }

    public long getExpTime() {
        return expTime;
    }
    //endregion
}
