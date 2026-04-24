package b6;

/* JADX INFO: loaded from: classes2.dex */
public final class U0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final U0 f9024a = new U0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f9025b = g6.K.a(new g6.F("ThreadLocalEventLoop"));

    public final AbstractC1070g0 a() {
        return (AbstractC1070g0) f9025b.get();
    }

    public final AbstractC1070g0 b() {
        ThreadLocal threadLocal = f9025b;
        AbstractC1070g0 abstractC1070g0 = (AbstractC1070g0) threadLocal.get();
        if (abstractC1070g0 != null) {
            return abstractC1070g0;
        }
        AbstractC1070g0 abstractC1070g0A = AbstractC1076j0.a();
        threadLocal.set(abstractC1070g0A);
        return abstractC1070g0A;
    }

    public final void c() {
        f9025b.set(null);
    }

    public final void d(AbstractC1070g0 abstractC1070g0) {
        f9025b.set(abstractC1070g0);
    }
}
