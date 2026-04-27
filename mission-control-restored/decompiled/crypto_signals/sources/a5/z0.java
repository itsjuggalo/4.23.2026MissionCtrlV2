package a5;

/* JADX INFO: loaded from: classes.dex */
public final class z0 extends f5.q implements Runnable {
    public final long e;

    public z0(long j4, K4.c cVar) {
        super(cVar, cVar.getContext());
        this.e = j4;
    }

    @Override // a5.p0
    public final String C() {
        return super.C() + "(timeMillis=" + this.e + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        C.i(this.f4105c);
        i(new y0("Timed out waiting for " + this.e + " ms", this));
    }
}
