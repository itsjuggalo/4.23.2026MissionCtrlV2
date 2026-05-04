package fh;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9583a;

    static {
        Object objB;
        try {
            r.a aVar = cd.r.f3870b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.t.e(property, "getProperty(...)");
            objB = cd.r.b(kg.y.o(property));
        } catch (Throwable th) {
            r.a aVar2 = cd.r.f3870b;
            objB = cd.r.b(cd.s.a(th));
        }
        if (cd.r.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        f9583a = num != null ? num.intValue() : 2097152;
    }
}
