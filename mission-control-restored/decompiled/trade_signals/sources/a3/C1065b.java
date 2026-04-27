package a3;

import S2.D;
import a3.C1067d;
import org.json.JSONObject;

/* JADX INFO: renamed from: a3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1065b implements i {
    public static C1067d b(D d8) {
        return new C1067d(d8.getCurrentTimeMillis() + ((long) 3600000), new C1067d.b(8, 4), new C1067d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // a3.i
    public C1067d a(D d8, JSONObject jSONObject) {
        return b(d8);
    }
}
