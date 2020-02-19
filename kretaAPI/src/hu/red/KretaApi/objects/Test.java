package hu.red.KretaApi.objects;

public class Test {
    private final String Uid;
    private final int Id;
    private final String Datum;
    private final String HetNapja;
    private final int Oraszam;
    private final String Tantargy;
    private final String Tanar;
    private final String SzamonkeresMegnevezese;
    private final String SzamonkeresModja;
    private final String BejelentesDatuma;
    private final String OsztalyCsoportUid;

    public Test(String uid, int id, String datum, String hetNapja, int oraszam, String tantargy, String tanar, String szamonkeresMegnevezese, String szamonkeresModja, String bejelentesDatuma, String osztalyCsoportUid) {
        Uid = uid;
        Id = id;
        Datum = datum;
        HetNapja = hetNapja;
        Oraszam = oraszam;
        Tantargy = tantargy;
        Tanar = tanar;
        SzamonkeresMegnevezese = szamonkeresMegnevezese;
        SzamonkeresModja = szamonkeresModja;
        BejelentesDatuma = bejelentesDatuma;
        OsztalyCsoportUid = osztalyCsoportUid;
    }

    public String getUid() {
        return Uid;
    }

    public int getId() {
        return Id;
    }

    public String getDatum() {
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

    public String getBejelentesDatuma() {
        return BejelentesDatuma;
    }

    public String getOsztalyCsoportUid() {
        return OsztalyCsoportUid;
    }
}
