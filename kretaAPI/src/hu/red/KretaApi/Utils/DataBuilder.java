package hu.red.KretaApi.Utils;

import java.util.ArrayList;
import java.util.List;

public class DataBuilder {
    List<Data> datas = new ArrayList<>();

    public String Build() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Data data : datas) {
            stringBuilder.append(data.getDataHead());
            stringBuilder.append('=');
            stringBuilder.append(data.getDataBody());
            stringBuilder.append('&');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void AddData(String head, String body) {
        datas.add(new Data(head, body));
    }

    @Override
    public String toString() {
        return Build();
    }
}

class Data {
    private final String dataHead;
    private final String dataBody;

    Data(String dataName, String datas) {
        this.dataHead = dataName;
        this.dataBody = datas;
    }

    public String getDataHead() {
        return dataHead;
    }

    public String getDataBody() {
        return dataBody;
    }
}
