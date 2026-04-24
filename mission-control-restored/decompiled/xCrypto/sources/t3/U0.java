package t3;

/* JADX INFO: loaded from: classes3.dex */
public final class U0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final U0 f14966a = new U0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f14967b = y3.K.a(new y3.F("ThreadLocalEventLoop"));

    public final AbstractC1815g0 a() {
        return (AbstractC1815g0) f14967b.get();
    }

    public final AbstractC1815g0 b() {
        ThreadLocal threadLocal = f14967b;
        AbstractC1815g0 abstractC1815g0 = (AbstractC1815g0) threadLocal.get();
        if (abstractC1815g0 != null) {
            return abstractC1815g0;
        }
        AbstractC1815g0 abstractC1815g0A = AbstractC1821j0.a();
        threadLocal.set(abstractC1815g0A);
        return abstractC1815g0A;
    }

    public final void c() {
        f14967b.set(null);
    }

    public final void d(AbstractC1815g0 abstractC1815g0) {
        f14967b.set(abstractC1815g0);
    }
}
