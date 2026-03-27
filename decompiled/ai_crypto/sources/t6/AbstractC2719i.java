package t6;

import E5.p;

/* JADX INFO: renamed from: t6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2719i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24326a;

    static {
        Object objB;
        try {
            p.a aVar = E5.p.f1681b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.r.e(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            objB = E5.p.b(Z5.s.i(property));
        } catch (Throwable th) {
            p.a aVar2 = E5.p.f1681b;
            objB = E5.p.b(E5.q.a(th));
        }
        if (E5.p.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        f24326a = num != null ? num.intValue() : 2097152;
    }
}
