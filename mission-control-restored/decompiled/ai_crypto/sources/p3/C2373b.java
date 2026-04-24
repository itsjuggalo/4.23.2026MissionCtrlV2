package p3;

import h3.InterfaceC1677H;
import org.json.JSONObject;
import p3.C2375d;

/* JADX INFO: renamed from: p3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2373b implements i {
    public static C2375d b(InterfaceC1677H interfaceC1677H) {
        return new C2375d(interfaceC1677H.getCurrentTimeMillis() + ((long) 3600000), new C2375d.b(8, 4), new C2375d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // p3.i
    public C2375d a(InterfaceC1677H interfaceC1677H, JSONObject jSONObject) {
        return b(interfaceC1677H);
    }
}
