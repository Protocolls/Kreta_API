package hu.red.KretaApi.objects;

import hu.red.KretaApi.Utils.Kreta;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewHomework {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.kk:mm:ss");
    private final String
            OraId,
            OraDate,
            OraType,
            HataridoUtc,
            FeladatSzovege;

    public NewHomework(String oraId, Date oraDate, String oraType, Date hataridoUtc, String feladatSzovege) {
        OraId = oraId;
        OraDate = dateFormat.format(oraDate);
        OraType = oraType;
        HataridoUtc = dateFormat.format(hataridoUtc);
        FeladatSzovege = feladatSzovege;
    }

    public String getOraId() {
        return OraId;
    }

    public String getOraDate() {
        return OraDate;
    }

    public String getOraType() {
        return OraType;
    }

    public String getHataridoUtc() {
        return HataridoUtc;
    }

    public String getFeladatSzovege() {
        return FeladatSzovege;
    }

    @Override
    public String toString() {
        return Kreta.Utils.toJson(this);
    }
}
