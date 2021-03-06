package hu.red.KretaApi.objects;

import hu.red.KretaApi.Utils.Kreta;

public class Tokens {
    //region Variables
    private final String access_token;
    private final String token_type;
    private final int expires_in;
    private final String refresh_token;
    //endregion

    public Tokens(String access_token, String token_type, int expires_in, String refresh_token) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
    }

    //region getters
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

    //endregion
    @Override
    public String toString() {
        return Kreta.Utils.toJson(this);
    }
}
