package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0332n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C0332n f4587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0332n f4588b;

    static {
        C0332n c0332n = new C0332n();
        Map map = Collections.EMPTY_MAP;
        f4588b = c0332n;
    }

    public static C0332n a() {
        C0332n c0332n;
        S s6 = S.f4509c;
        C0332n c0332n2 = f4587a;
        if (c0332n2 != null) {
            return c0332n2;
        }
        synchronized (C0332n.class) {
            try {
                c0332n = f4587a;
                if (c0332n == null) {
                    Class cls = AbstractC0331m.f4586a;
                    C0332n c0332n3 = null;
                    if (cls != null) {
                        try {
                            c0332n3 = (C0332n) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    c0332n = c0332n3 != null ? c0332n3 : f4588b;
                    f4587a = c0332n;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0332n;
    }
}
