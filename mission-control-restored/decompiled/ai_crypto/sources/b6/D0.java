package b6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D0 extends E implements InterfaceC1062c0, InterfaceC1091r0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public E0 f8968d;

    @Override // b6.InterfaceC1062c0
    public void a() {
        t().y0(this);
    }

    @Override // b6.InterfaceC1091r0
    public J0 d() {
        return null;
    }

    @Override // b6.InterfaceC1091r0
    public boolean isActive() {
        return true;
    }

    public final E0 t() {
        E0 e02 = this.f8968d;
        if (e02 != null) {
            return e02;
        }
        kotlin.jvm.internal.r.s("job");
        return null;
    }

    @Override // g6.q
    public String toString() {
        return P.a(this) + '@' + P.b(this) + "[job@" + P.b(t()) + ']';
    }

    public final void u(E0 e02) {
        this.f8968d = e02;
    }
}
