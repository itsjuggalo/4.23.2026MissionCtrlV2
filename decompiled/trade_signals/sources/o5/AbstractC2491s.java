package o5;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2490r;

/* JADX INFO: renamed from: o5.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2491s {
    public static final Object a(Throwable exception) {
        AbstractC2304t.f(exception, "exception");
        return new C2490r.b(exception);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof C2490r.b) {
            throw ((C2490r.b) obj).f21983a;
        }
    }
}
