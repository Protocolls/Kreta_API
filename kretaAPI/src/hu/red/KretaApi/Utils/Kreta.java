package hu.red.KretaApi.Utils;

import com.google.gson.Gson;
import hu.red.KretaApi.objects.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public abstract class Kreta {
    private final static Gson gson = new Gson();

    public abstract static class Tools {


        //region GetSchools
        public static School[] getSchools() {
            String json = Utils.GetStringFromServer(URLS.SCHOOL_LIST_LINK, URLS.API_KEY_HEADER);
            return gson.fromJson(json, School[].class);
        }

        public static School getSchool(int InstituteId) {
            return gson.fromJson(
                    Utils.GetStringFromServer(URLS.SCHOOL_LIST_LINK + InstituteId, URLS.API_KEY_HEADER),
                    School.class
            );
        }

        //endregion
        //region API Links
        public static API_LINKS getAPILinks() {
            String json = Utils.GetStringFromServer(URLS.API_LINKS_LINK);
            return gson.fromJson(json, API_LINKS.class);
        }

        public static String getProdLink() {
            return getAPILinks().getGlobalMobileApiUrlPROD();
        }

        //endregion
        //region tokens
        public static Tokens getTokens(String instituteCode, String username, String password) {
            DataBuilder dataBuilder = new DataBuilder();
            dataBuilder.AddData("institute_code", instituteCode);
            dataBuilder.AddData("userName", username);
            dataBuilder.AddData("password", password);
            dataBuilder.AddData("grant_type", "password");
            dataBuilder.AddData("client_id", "919e0c1c-76a2-4646-a2fb-7085bbbf3c56");
            String data = dataBuilder.Build();
            Header[] headers = {
                    new Header("Content-Type", "application/x-www-form-urlencoded"),
                    new Header("charset", "utf-8"),
                    URLS.USER_AGENT_HEADER
            };
            String url = "https://" + instituteCode + ".e-kreta.hu:443/idp/api/v1/Token";
            return gson.fromJson(Utils.GetStringFromServer(url, headers, data), Tokens.class);
        }

        public static Tokens updateTokens(String instituteCode, String refreshToken) {
            Header[] headers = {
                    new Header("Content-Type", "application/x-www-form-urlencoded"),
                    new Header("charset", "utf-8"),
                    URLS.USER_AGENT_HEADER
            };
            DataBuilder dataBuilder = new DataBuilder();
            dataBuilder.AddData("institute_code", instituteCode);
            dataBuilder.AddData("refresh_token", refreshToken);
            dataBuilder.AddData("grant_type", "refresh_token");
            dataBuilder.AddData("client_id", "919e0c1c-76a2-4646-a2fb-7085bbbf3c56");
            String url = "https://" + instituteCode + ".e-kreta.hu:443/idp/api/v1/Token";
            return gson.fromJson(Utils.GetStringFromServer(url, headers, dataBuilder.Build()), Tokens.class);

        }

        //endregion
        //todo nem tudtam tesztelni mivel nekem nincs.... Félbehagyva....
        public static String getEUgyintezes(String bearer) {
            return Utils.GetStringFromServer(
                    "https://eugyintezes.e-kreta.hu/integration-kretamobile-api/v1/kommunikacio/postaladaelemek/sajat",
                    new Header("Authorization", "Bearer " + bearer)
            );
        }

        //region getTest
        public static Test[] getTests(String instituteCode, String bearer) {
            Header[] headers = {
                    new Header("Authorization", "Bearer " + bearer),
                    URLS.USER_AGENT_HEADER
            };
            String url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/BejelentettSzamonkeres?DatumTol=null&DatumIg=null";
            return gson.fromJson(Utils.GetStringFromServer(url, headers), Test[].class);
        }

        public static Test[] getTests(String instituteCode, String bearer, Date from, Date to) {
            Header[] headers = {
                    new Header("Authorization", "Bearer " + bearer),
                    URLS.USER_AGENT_HEADER
            };
            String url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/BejelentettSzamonkeres?DatumTol=" + Utils.DateToString(from) + "&DatumIg=" + Utils.DateToString(from);
            return gson.fromJson(Utils.GetStringFromServer(url, headers), Test[].class);
        }

        //endregion
        //region homewok
        public static Homework[] getHomeworks(String instituteCode, String bearer, int TeacherHomeworkId) {
            Header[] headers = {
                    new Header("Authorization", "Bearer " + bearer),
                    URLS.USER_AGENT_HEADER
            };
            String url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/HaziFeladat/TanuloHaziFeladatLista/" + TeacherHomeworkId;
            return gson.fromJson(Utils.GetStringFromServer(url, headers), Homework[].class);
        }

        //todo nem teszteltem de nem hiszem hogy működik....(félkész)
        public static String setHomework(String instituteCode, String bearer, NewHomework homework) {
            Header[] headers = {
                    new Header("Authorization", "Bearer " + bearer),
                    new Header("charset", "utf-8"),
                    new Header("Content-Type", "application/json"),
                    URLS.USER_AGENT_HEADER
            };
            String url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/HaziFeladat/CreateTanuloHaziFeladat";
            return Utils.GetStringFromServer(url, headers, gson.toJson(homework));
        }

        //endregion
        //region Student datas
        public static UserData getStudentInfos(String instituteCode, String bearer, Date from, Date to) {
            Header[] headers = {
                    new Header("Authorization", "Bearer " + bearer),
                    URLS.USER_AGENT_HEADER
            };
            String url = "";
            if (from == null || to == null) {
                url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/Student";
            } else {
                url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/Student?fromDate=" + Utils.DateToString(from) + "&toDate=" + Utils.DateToString(to);
            }
            return gson.fromJson(Utils.GetStringFromServer(url, headers), UserData.class);
        }

        public static UserData getStudentInfos(String instituteCode, String bearer) {
            return getStudentInfos(instituteCode, bearer, null, null);
        }
//endregion

        public static Lesson[] getTimetable(String instituteCode, String bearer, Date from, Date to) {
            Header[] headers = {
                    new Header("Authorization", "Bearer " + bearer),
                    URLS.USER_AGENT_HEADER
            };
            String url = "https://" + instituteCode + ".e-kreta.hu/mapi/api/v1/Lesson?fromDate=" + Utils.DateToString(from) + "&toDate=" + Utils.DateToString(to);
            return gson.fromJson(Utils.GetStringFromServer(url, headers), Lesson[].class);
        }
    }

    private static class URLS {
        public static Header USER_AGENT_HEADER = new Header("User-Agent", "Kreta.Ellenorzo");
        public final static String API_KEY = "7856d350-1fda-45f5-822d-e1a2f3f1acf0";
        public final static Header API_KEY_HEADER = new Header("apiKey", API_KEY);
        public final static String SCHOOL_LIST_LINK = "https://kretaglobalmobileapi2.ekreta.hu/api/v2/Institute/";
        public final static String API_LINKS_LINK = "https://kretamobile.blob.core.windows.net/configuration/ConfigurationDescriptor.json";
    }

    public abstract static class Utils {
        //region DateFormation
        private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        private static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd-kk:mm:ss");
        private static final SimpleDateFormat longerDateFormat = new SimpleDateFormat("yyyy-MM-dd-kk:mm:ss.SSS");

        public static String DateToString(Date date) {
            return shortDateFormat.format(date);
        }

        public static Date StingToDate(String date) {

            date = date.replace('T', '-');
            if (date.length() == 20)
                date = date.substring(0, date.length() - 1);// a krétás hülyeség miatt kell, (random 'Z'a dátum végén...)
            if (date.length() <= 19) {
                try {
                    return longDateFormat.parse(date);
                } catch (ParseException e) {
                    System.err.println("Nem sikerül átalakítani(rövid): " + date);
                    e.printStackTrace();
                }
            } else {
                try {
                    return longerDateFormat.parse(date);
                } catch (ParseException e) {
                    System.err.println("Nem sikerül átalakítani(hosszu): " + date);
                    e.printStackTrace();
                }
            }
            return null;
        }

        //endregion
        //region GetStringFromServer
        public static String GetStringFromServer(String address, Header[] headers) {
            return GetStringFromServer(address, headers, null);
        }

        public static String GetStringFromServer(String address, String data) {
            return GetStringFromServer(address, new Header[0], data);
        }

        public static String GetStringFromServer(String address, Header[] headers, String data) {
            URL url;
            try {
                url = new URL(address);
                URLConnection connection = url.openConnection();
                AddHeader(connection, headers);
                if (data != null) {
                    connection.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                    wr.writeBytes(data);
                    wr.flush();
                    wr.close();
                }
                return GetContent(connection);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private static void AddHeader(URLConnection con, Header[] headers) {
            for (Header header : headers) {
                con.addRequestProperty(header.getKey(), header.getVaule());
            }
        }

        private static String GetContent(URLConnection con) {
            if (con != null) {
                try {
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(con.getInputStream()));
                    String input;
                    StringBuilder builder = new StringBuilder();

                    while ((input = br.readLine()) != null) {
                        builder.append(input);
                    }
                    br.close();
                    return builder.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "NULL CONNECTION";
        }

        public static String GetStringFromServer(String address, Header header) {
            return GetStringFromServer(address, new Header[]{header});
        }

        public static String GetStringFromServer(String address) {
            return GetStringFromServer(address, new Header[0]);
        }

        //endregion
        public static String toJson(Object object) {
            return gson.toJson(object);
        }

        public static String decodeToken(String str) {
            switch (str.length() % 4) {
                case 2:
                    str += "==";
                    break;
                case 3:
                    str += "=";
                    break;
            }
            return new String(Base64.getDecoder().decode(str));
        }
    }
}
