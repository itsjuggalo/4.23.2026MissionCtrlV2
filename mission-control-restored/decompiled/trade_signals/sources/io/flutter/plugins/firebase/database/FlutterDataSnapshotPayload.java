package io.flutter.plugins.firebase.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FlutterDataSnapshotPayload {
    private Map<String, Object> payloadMap = new HashMap();

    public FlutterDataSnapshotPayload(c3.b bVar) {
        Collection collectionAsList;
        HashMap map = new HashMap();
        map.put("key", bVar.e());
        map.put("value", bVar.h());
        map.put(Constants.PRIORITY, bVar.f());
        int iD = (int) bVar.d();
        if (iD == 0) {
            collectionAsList = new ArrayList();
        } else {
            String[] strArr = new String[iD];
            Iterator it = bVar.c().iterator();
            int i8 = 0;
            while (it.hasNext()) {
                strArr[i8] = ((c3.b) it.next()).e();
                i8++;
            }
            collectionAsList = Arrays.asList(strArr);
        }
        map.put(Constants.CHILD_KEYS, collectionAsList);
        this.payloadMap.put(Constants.SNAPSHOT, map);
    }

    public Map<String, Object> toMap() {
        return this.payloadMap;
    }

    public FlutterDataSnapshotPayload withAdditionalParams(Map<String, Object> map) {
        Map<String, Object> map2 = this.payloadMap;
        HashMap map3 = new HashMap();
        this.payloadMap = map3;
        map3.putAll(map2);
        this.payloadMap.putAll(map);
        return this;
    }
}
