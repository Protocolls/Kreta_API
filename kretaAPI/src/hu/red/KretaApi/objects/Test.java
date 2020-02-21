package hu.red.KretaApi.objects;

import hu.red.KretaApi.Utils.KretaTools.Utils;

import java.util.Date;

public class Test {
    private final String Uid;
    private final int Id;
    private final Date Datum;
    private final String HetNapja;
    private final int Oraszam;
    private final String Tantargy;
    private final String Tanar;
    private final String SzamonkeresMegnevezese;
    private final String SzamonkeresModja;
    private final Date BejelentesDatuma;
    private final String OsztalyCsoportUid;

    public Test(String uid, int id, String datum, String hetNapja, int oraszam, String tantargy, String tanar, String szamonkeresMegnevezese, String szamonkeresModja, String bejelentesDatuma, String osztalyCsoportUid) {
        Uid = uid;
        Id = id;
        Datum = Utils.StingToDate(datum);
        HetNapja = hetNapja;
        Oraszam = oraszam;
        Tantargy = tantargy;
        Tanar = tanar;
        SzamonkeresMegnevezese = szamonkeresMegnevezese;
        SzamonkeresModja = szamonkeresModja;
        BejelentesDatuma = Utils.StingToDate(bejelentesDatuma);
        OsztalyCsoportUid = osztalyCsoportUid;
    }

    public String getUid() {
        return Uid;
    }

    public int getId() {
        return Id;
    }

    public Date getDatum() {
        return Datum;
    }

    public String getHetNapja() {
        return HetNapja;
    }

    public int getOraszam() {
        return Oraszam;
    }

    public String getTantargy() {
        return Tantargy;
    }

    public String getTanar() {
        return Tanar;
    }

    public String getSzamonkeresMegnevezese() {
        return SzamonkeresMegnevezese;
    }

    public String getSzamonkeresModja() {
        return SzamonkeresModja;
    }

    public Date getBejelentesDatuma() {
        return BejelentesDatuma;
    }

    public String getOsztalyCsoportUid() {
        return OsztalyCsoportUid;
    }
}
