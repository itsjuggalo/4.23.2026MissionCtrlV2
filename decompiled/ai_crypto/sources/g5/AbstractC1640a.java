package g5;

import android.util.Log;
import com.google.firebase.firestore.f;
import e5.AbstractC1533z;
import e5.C1508a;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: g5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1640a {
    public static Map a(Exception exc) {
        C1508a c1508a;
        HashMap map = new HashMap();
        if (exc == null) {
            return map;
        }
        if (exc instanceof f) {
            c1508a = new C1508a((f) exc, exc.getCause());
        } else if (exc.getCause() == null || !(exc.getCause() instanceof f)) {
            c1508a = null;
        } else {
            c1508a = new C1508a((f) exc.getCause(), exc.getCause().getCause() != null ? exc.getCause().getCause() : exc.getCause());
        }
        if (c1508a != null) {
            map.put("code", c1508a.a());
            map.put("message", c1508a.getMessage());
        }
        if (map.containsKey("code")) {
            String str = (String) map.get("code");
            Objects.requireNonNull(str);
            if (str.equals("unknown")) {
                Log.e("FLTFirebaseFirestore", "An unknown error occurred", exc);
            }
        }
        return map;
    }

    public static void b(AbstractC1533z.x xVar, Exception exc) {
        xVar.b(new AbstractC1533z.j("firebase_firestore", exc != null ? exc.getMessage() : null, a(exc)));
    }
}
