package m2;

import android.content.Context;
import n2.AbstractC2393F;

/* JADX INFO: renamed from: m2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2355h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC2352e f21363a;

    public static synchronized InterfaceC2352e a(Context context) {
        try {
            if (f21363a == null) {
                C2354g c2354g = new C2354g(null);
                c2354g.b(new C2361n(AbstractC2393F.a(context)));
                f21363a = c2354g.a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f21363a;
    }
}
