package y3;

import W2.p;
import a.C0773a;
import b3.AbstractC0863a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f15956a = new C0773a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15958c;

    static {
        Object objB;
        Object objB2;
        try {
            p.a aVar = W2.p.f5487b;
            objB = W2.p.b(AbstractC0863a.class.getCanonicalName());
        } catch (Throwable th) {
            p.a aVar2 = W2.p.f5487b;
            objB = W2.p.b(W2.q.a(th));
        }
        if (W2.p.e(objB) != null) {
            objB = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f15957b = (String) objB;
        try {
            objB2 = W2.p.b(E.class.getCanonicalName());
        } catch (Throwable th2) {
            p.a aVar3 = W2.p.f5487b;
            objB2 = W2.p.b(W2.q.a(th2));
        }
        if (W2.p.e(objB2) != null) {
            objB2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f15958c = (String) objB2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
