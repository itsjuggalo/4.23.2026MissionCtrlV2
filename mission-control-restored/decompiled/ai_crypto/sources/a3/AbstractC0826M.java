package a3;

import com.google.android.gms.internal.p002firebaseauthapi.zzaag;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: a3.M, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0826M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S1.a f6154a = new S1.a("GetTokenResultFactory", new String[0]);

    public static Z2.C a(String str) {
        Map map;
        try {
            map = AbstractC0825L.b(str);
        } catch (zzaag e7) {
            f6154a.b("Error parsing token claims", e7, new Object[0]);
            map = new HashMap();
        }
        return new Z2.C(str, map);
    }
}
