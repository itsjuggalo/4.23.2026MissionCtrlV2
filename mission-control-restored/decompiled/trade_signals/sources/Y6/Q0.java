package Y6;

import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class Q0 extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Q0 f9643c = new Q0();

    @Override // Y6.I
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        android.support.v4.media.session.b.a(interfaceC2711i.a(U0.f9648b));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // Y6.I
    public boolean w0(InterfaceC2711i interfaceC2711i) {
        return false;
    }

    @Override // Y6.I
    public I x0(int i8, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }
}
