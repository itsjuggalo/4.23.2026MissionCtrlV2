package sg;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f20381a = new a.a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20383c;

    static {
        Object objB;
        Object objB2;
        try {
            r.a aVar = cd.r.f3870b;
            objB = cd.r.b(id.a.class.getCanonicalName());
        } catch (Throwable th) {
            r.a aVar2 = cd.r.f3870b;
            objB = cd.r.b(cd.s.a(th));
        }
        if (cd.r.e(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f20382b = (String) objB;
        try {
            objB2 = cd.r.b(c0.class.getCanonicalName());
        } catch (Throwable th2) {
            r.a aVar3 = cd.r.f3870b;
            objB2 = cd.r.b(cd.s.a(th2));
        }
        if (cd.r.e(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f20383c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
