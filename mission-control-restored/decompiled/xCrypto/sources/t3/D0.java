package t3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class D0 extends E implements InterfaceC1807c0, InterfaceC1836r0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public E0 f14910d;

    @Override // t3.InterfaceC1836r0
    public J0 a() {
        return null;
    }

    @Override // t3.InterfaceC1807c0
    public void dispose() {
        r().y0(this);
    }

    @Override // t3.InterfaceC1836r0
    public boolean isActive() {
        return true;
    }

    public final E0 r() {
        E0 e02 = this.f14910d;
        if (e02 != null) {
            return e02;
        }
        kotlin.jvm.internal.r.t("job");
        return null;
    }

    public final void s(E0 e02) {
        this.f14910d = e02;
    }

    @Override // y3.q
    public String toString() {
        return P.a(this) + '@' + P.b(this) + "[job@" + P.b(r()) + ']';
    }
}
