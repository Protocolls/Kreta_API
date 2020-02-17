package hu.red.KretaApi;

import com.google.gson.Gson;
import hu.red.KretaApi.Utils.DataBuilder;
import hu.red.KretaApi.Utils.Header;
import hu.red.KretaApi.objects.API_LINKS;
import hu.red.KretaApi.objects.School;
import hu.red.KretaApi.objects.Tokens;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class KretaAPI {
    private final String USER_NAME;
    private final String PASSWORD;
    private final int SCHOOL_ID;

    public KretaAPI(String user_name, String password, int school_id) {
        USER_NAME = user_name;
        PASSWORD = password;
        SCHOOL_ID = school_id;
    }


    public static class APITools {
        private final static Gson gson = new Gson();

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

        public static API_LINKS getAPILinks() {
            String json = Utils.GetStringFromServer(URLS.API_LINKS_LINK);
            return gson.fromJson(json, API_LINKS.class);
        }

        public static String getProdLink() {
            return getAPILinks().getGlobalMobileApiUrlPROD();
        }

        public static Tokens getBearerTokens(String instituteCode, String username, String password, String grandType) {
            DataBuilder dataBuilder = new DataBuilder();
            dataBuilder.AddData("institute_code", instituteCode);
            dataBuilder.AddData("userName", username);
            dataBuilder.AddData("password", password);
            dataBuilder.AddData("grant_type", grandType);
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
    }

    private static class URLS {
        public final static Header USER_AGENT_HEADER = new Header("User-Agent", "Kreta.Ellenorzo");
        public final static String API_KEY = "7856d350-1fda-45f5-822d-e1a2f3f1acf0";
        public final static Header API_KEY_HEADER = new Header("apiKey", API_KEY);
        public final static String SCHOOL_LIST_LINK = "http://kretaglobalmobileapi2.ekreta.hu/api/v2/Institute/";
        public final static String API_LINKS_LINK = "http://kretamobile.blob.core.windows.net/configuration/ConfigurationDescriptor.json";
    }

    public static class Utils {
        //region GetStringFromServer
        public static String GetStringFromServer(String address, Header[] headers) {
            return GetStringFromServer(address, headers, null);
        }

        public static String GetStringFromServer(String address, String data) {
            return GetStringFromServer(address, new Header[0], data);
        }

        public static String GetStringFromServer(String address, Header[] headers, String data) {
            URL url = null;
            try {
                url = new URL(address);

                URLConnection connection;
                if (url.getProtocol().equals("https")) {
                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                    connection = con;
                } else {
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    connection = con;
                }
                AddHeader(connection, headers);
                if (data != null) {
                    connection.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                    wr.writeBytes(data);
                    wr.flush();
                    wr.close();
                }
                return GetContent(connection);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private static void AddHeader(URLConnection con, Header[] headers) {

            for (int i = 0; i < headers.length; i++) {
                con.addRequestProperty(headers[i].getKey(), headers[i].getVaule());
            }
        }

        private static String GetContent(URLConnection con) {
            if (con != null) {
                try {
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(con.getInputStream()));
                    String input;
                    String full = "";

                    while ((input = br.readLine()) != null) {
                        full = full + input + "\n";
                    }
                    br.close();
                    return full;
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
