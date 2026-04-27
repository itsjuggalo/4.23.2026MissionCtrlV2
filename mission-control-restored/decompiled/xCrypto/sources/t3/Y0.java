package t3;

/* JADX INFO: loaded from: classes3.dex */
public final class Y0 extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Y0 f14972c = new Y0();

    @Override // t3.I
    public void d0(Z2.i iVar, Runnable runnable) {
        android.support.v4.media.session.b.a(iVar.get(c1.f14981b));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // t3.I
    public boolean e0(Z2.i iVar) {
        return false;
    }

    @Override // t3.I
    public I f0(int i4) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // t3.I
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
