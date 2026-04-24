package t3;

/* JADX INFO: loaded from: classes3.dex */
public final class W0 extends y3.B implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14969e;

    public W0(long j4, Z2.e eVar) {
        super(eVar.getContext(), eVar);
        this.f14969e = j4;
    }

    @Override // t3.AbstractC1802a, t3.E0
    public String m0() {
        return super.m0() + "(timeMillis=" + this.f14969e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        C(X0.a(this.f14969e, W.b(getContext()), this));
    }
}
