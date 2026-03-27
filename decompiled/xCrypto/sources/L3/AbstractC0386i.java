package L3;

import W2.p;

/* JADX INFO: renamed from: L3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0386i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1533a;

    static {
        Object objB;
        try {
            p.a aVar = W2.p.f5487b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.r.e(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            objB = W2.p.b(r3.w.m(property));
        } catch (Throwable th) {
            p.a aVar2 = W2.p.f5487b;
            objB = W2.p.b(W2.q.a(th));
        }
        if (W2.p.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        f1533a = num != null ? num.intValue() : 2097152;
    }
}
