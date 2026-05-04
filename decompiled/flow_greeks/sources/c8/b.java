package c8;

import c8.d;
import org.json.JSONObject;
import u7.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements i {
    public static d b(b0 b0Var) {
        return new d(b0Var.getCurrentTimeMillis() + ((long) 3600000), new d.b(8, 4), new d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // c8.i
    public d a(b0 b0Var, JSONObject jSONObject) {
        return b(b0Var);
    }
}
