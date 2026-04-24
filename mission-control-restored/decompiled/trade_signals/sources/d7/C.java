package d7;

import a.C1039a;
import o5.AbstractC2491s;
import o5.C2490r;
import u5.AbstractC2774a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f17025a = new C1039a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f17026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f17027c;

    static {
        Object objB;
        Object objB2;
        try {
            C2490r.a aVar = C2490r.f21981b;
            objB = C2490r.b(AbstractC2774a.class.getCanonicalName());
        } catch (Throwable th) {
            C2490r.a aVar2 = C2490r.f21981b;
            objB = C2490r.b(AbstractC2491s.a(th));
        }
        if (C2490r.e(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f17026b = (String) objB;
        try {
            objB2 = C2490r.b(C.class.getCanonicalName());
        } catch (Throwable th2) {
            C2490r.a aVar3 = C2490r.f21981b;
            objB2 = C2490r.b(AbstractC2491s.a(th2));
        }
        if (C2490r.e(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f17027c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
