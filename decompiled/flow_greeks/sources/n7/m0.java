package n7;

import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p5.a f16815a = new p5.a("GetTokenResultFactory", new String[0]);

    public static m7.c0 a(String str) {
        Map map;
        try {
            map = l0.b(str);
        } catch (zzaao e10) {
            f16815a.b("Error parsing token claims", e10, new Object[0]);
            map = new HashMap();
        }
        return new m7.c0(str, map);
    }
}
