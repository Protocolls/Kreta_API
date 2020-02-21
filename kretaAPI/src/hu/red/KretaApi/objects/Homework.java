package hu.red.KretaApi.objects;

import hu.red.KretaApi.Utils.Kreta;

import java.util.Date;

public class Homework {
    private final String Uid;
    private final int Id;
    private final String TanuloNev;
    private final String FeladasDatuma;
    private final String FeladatSzovege;
    private final int RogzitoId;
    private final boolean TanuloAltalTorolt;
    private final boolean TanarAltalTorolt;

    public Homework(String uid, int id, String tanuloNev, String feladasDatuma, String feladatSzovege, int rogzitoId, boolean tanuloAltalTorolt, boolean tanarAltalTorolt) {
        Uid = uid;
        Id = id;
        TanuloNev = tanuloNev;
        FeladasDatuma = feladasDatuma;
        FeladatSzovege = feladatSzovege;
        RogzitoId = rogzitoId;
        TanuloAltalTorolt = tanuloAltalTorolt;
        TanarAltalTorolt = tanarAltalTorolt;
    }

    public String getUid() {
        return Uid;
    }

    public int getId() {
        return Id;
    }

    public String getTanuloNev() {
        return TanuloNev;
    }

    public Date getFeladasDatuma() {
        return Kreta.Utils.StingToDate(FeladasDatuma);
    }

    public String getFeladatSzovege() {
        return FeladatSzovege;
    }

    public int getRogzitoId() {
        return RogzitoId;
    }

    public boolean isTanuloAltalTorolt() {
        return TanuloAltalTorolt;
    }

    public boolean isTanarAltalTorolt() {
        return TanarAltalTorolt;
    }
}
