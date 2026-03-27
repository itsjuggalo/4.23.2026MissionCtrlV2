package Y6;

/* JADX INFO: loaded from: classes2.dex */
public final class P0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P0 f9639a = new P0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f9640b = d7.L.a(new d7.D("ThreadLocalEventLoop"));

    public final AbstractC1002e0 a() {
        return (AbstractC1002e0) f9640b.get();
    }

    public final AbstractC1002e0 b() {
        ThreadLocal threadLocal = f9640b;
        AbstractC1002e0 abstractC1002e0 = (AbstractC1002e0) threadLocal.get();
        if (abstractC1002e0 != null) {
            return abstractC1002e0;
        }
        AbstractC1002e0 abstractC1002e0A = AbstractC1008h0.a();
        threadLocal.set(abstractC1002e0A);
        return abstractC1002e0A;
    }

    public final void c() {
        f9640b.set(null);
    }

    public final void d(AbstractC1002e0 abstractC1002e0) {
        f9640b.set(abstractC1002e0);
    }
}
