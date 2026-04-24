package j2;

import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import i2.C0670p;
import java.util.HashMap;
import java.util.Map;
import x1.C1402a;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1402a f7735a = new C1402a("GetTokenResultFactory", new String[0]);

    public static C0670p a(String str) {
        Map map;
        try {
            map = AbstractC0744u.b(str);
        } catch (zzaao e) {
            f7735a.b("Error parsing token claims", e, new Object[0]);
            map = new HashMap();
        }
        C0670p c0670p = new C0670p();
        c0670p.f6801a = str;
        c0670p.f6802b = map;
        return c0670p;
    }
}
