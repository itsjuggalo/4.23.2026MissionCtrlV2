package b6;

/* JADX INFO: loaded from: classes2.dex */
public final class Y0 extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Y0 f9030c = new Y0();

    @Override // b6.I
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    @Override // b6.I
    public void y0(H5.g gVar, Runnable runnable) {
        android.support.v4.media.session.b.a(gVar.get(c1.f9039b));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // b6.I
    public boolean z0(H5.g gVar) {
        return false;
    }
}
