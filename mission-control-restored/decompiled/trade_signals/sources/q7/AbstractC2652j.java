package q7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2490r;

/* JADX INFO: renamed from: q7.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2652j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22891a;

    static {
        Object objB;
        try {
            C2490r.a aVar = C2490r.f21981b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            AbstractC2304t.e(property, "getProperty(...)");
            objB = C2490r.b(V6.z.n(property));
        } catch (Throwable th) {
            C2490r.a aVar2 = C2490r.f21981b;
            objB = C2490r.b(AbstractC2491s.a(th));
        }
        if (C2490r.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        f22891a = num != null ? num.intValue() : 2097152;
    }
}
