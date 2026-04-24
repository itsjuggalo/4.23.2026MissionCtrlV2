package S1;

/* JADX INFO: renamed from: S1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0234c extends A {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f2856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2857l;

    public /* synthetic */ C0234c(Object obj, int i) {
        this.f2856k = i;
        this.f2857l = obj;
    }

    @Override // S1.A
    public final void b() {
        switch (this.f2856k) {
            case 0:
                C0236e c0236e = ((ServiceConnectionC0235d) this.f2857l).f2858a;
                c0236e.f2861b.b("unlinkToDeath", new Object[0]);
                c0236e.f2871n.asBinder().unlinkToDeath(c0236e.f2868k, 0);
                c0236e.f2871n = null;
                c0236e.f2865g = false;
                return;
            default:
                synchronized (((C0236e) this.f2857l).f2864f) {
                    try {
                        if (((C0236e) this.f2857l).f2869l.get() > 0 && ((C0236e) this.f2857l).f2869l.decrementAndGet() > 0) {
                            ((C0236e) this.f2857l).f2861b.b("Leaving the connection open for other ongoing calls.", new Object[0]);
                            return;
                        }
                        C0236e c0236e2 = (C0236e) this.f2857l;
                        if (c0236e2.f2871n != null) {
                            c0236e2.f2861b.b("Unbind from service.", new Object[0]);
                            C0236e c0236e3 = (C0236e) this.f2857l;
                            c0236e3.f2860a.unbindService(c0236e3.f2870m);
                            C0236e c0236e4 = (C0236e) this.f2857l;
                            c0236e4.f2865g = false;
                            c0236e4.f2871n = null;
                            c0236e4.f2870m = null;
                        }
                        ((C0236e) this.f2857l).e();
                        return;
                    } finally {
                    }
                }
        }
    }
}
