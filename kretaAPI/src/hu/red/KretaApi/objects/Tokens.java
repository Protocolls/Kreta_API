package hu.red.KretaApi.objects;

public class Tokens {
    private final String access_token;
    private final String token_type;
    private final int expires_in;
    private final String refresh_token;

    public Tokens(String access_token, String token_type, int expires_in, String refresh_token) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
