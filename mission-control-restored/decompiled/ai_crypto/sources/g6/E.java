package g6;

import E5.p;
import a.C0797a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f14270a = new C0797a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14272c;

    static {
        Object objB;
        Object objB2;
        try {
            p.a aVar = E5.p.f1681b;
            objB = E5.p.b(J5.a.class.getCanonicalName());
        } catch (Throwable th) {
            p.a aVar2 = E5.p.f1681b;
            objB = E5.p.b(E5.q.a(th));
        }
        if (E5.p.e(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f14271b = (String) objB;
        try {
            objB2 = E5.p.b(E.class.getCanonicalName());
        } catch (Throwable th2) {
            p.a aVar3 = E5.p.f1681b;
            objB2 = E5.p.b(E5.q.a(th2));
        }
        if (E5.p.e(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f14272c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
