package W2;

import W2.p;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.r.f(exception, "exception");
        return new p.b(exception);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof p.b) {
            throw ((p.b) obj).f5489a;
        }
    }
}
