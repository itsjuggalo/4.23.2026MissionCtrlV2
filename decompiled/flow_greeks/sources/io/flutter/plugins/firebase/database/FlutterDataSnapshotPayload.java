package io.flutter.plugins.firebase.database;

import dd.r;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00002\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/flutter/plugins/firebase/database/FlutterDataSnapshotPayload;", "", "Le8/b;", Constants.SNAPSHOT, "<init>", "(Le8/b;)V", "", "", "params", "withAdditionalParams", "(Ljava/util/Map;)Lio/flutter/plugins/firebase/database/FlutterDataSnapshotPayload;", "toMap", "()Ljava/util/Map;", "", "payloadMap", "Ljava/util/Map;", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlutterDataSnapshotPayload {
    private Map<String, Object> payloadMap;

    public FlutterDataSnapshotPayload(e8.b snapshot) {
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        this.payloadMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key", snapshot.e());
        linkedHashMap.put("value", snapshot.h());
        linkedHashMap.put(Constants.PRIORITY, snapshot.f());
        int iD = (int) snapshot.d();
        if (iD == 0) {
            linkedHashMap.put(Constants.CHILD_KEYS, r.k());
        } else {
            String[] strArr = new String[iD];
            int i10 = 0;
            for (int i11 = 0; i11 < iD; i11++) {
                strArr[i11] = "";
            }
            Iterable iterableC = snapshot.c();
            kotlin.jvm.internal.t.e(iterableC, "getChildren(...)");
            Iterator it = iterableC.iterator();
            while (it.hasNext()) {
                String strE = ((e8.b) it.next()).e();
                if (strE == null) {
                    strE = "";
                }
                strArr[i10] = strE;
                i10++;
            }
            linkedHashMap.put(Constants.CHILD_KEYS, dd.n.z0(strArr));
        }
        this.payloadMap.put(Constants.SNAPSHOT, linkedHashMap);
    }

    public final Map<String, Object> toMap() {
        return this.payloadMap;
    }

    public final FlutterDataSnapshotPayload withAdditionalParams(Map<String, ? extends Object> params) {
        kotlin.jvm.internal.t.f(params, "params");
        Map<String, Object> map = this.payloadMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.payloadMap = linkedHashMap;
        linkedHashMap.putAll(map);
        this.payloadMap.putAll(params);
        return this;
    }
}
