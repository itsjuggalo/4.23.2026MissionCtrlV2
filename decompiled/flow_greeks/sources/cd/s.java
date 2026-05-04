package cd;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.t.f(exception, "exception");
        return new r.b(exception);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof r.b) {
            throw ((r.b) obj).f3872a;
        }
    }
}
