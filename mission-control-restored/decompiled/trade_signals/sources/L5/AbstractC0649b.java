package L5;

import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2490r;

/* JADX INFO: renamed from: L5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0649b {
    static {
        Object objB;
        try {
            C2490r.a aVar = C2490r.f21981b;
            objB = C2490r.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            C2490r.a aVar2 = C2490r.f21981b;
            objB = C2490r.b(AbstractC2491s.a(th));
        }
        if (C2490r.h(objB)) {
            objB = Boolean.TRUE;
        }
        Object objB2 = C2490r.b(objB);
        Boolean bool = Boolean.FALSE;
        if (C2490r.g(objB2)) {
            objB2 = bool;
        }
        ((Boolean) objB2).booleanValue();
    }

    public static final AbstractC0647a a(B5.k compute) {
        AbstractC2304t.f(compute, "compute");
        return new C0663i(compute);
    }
}
