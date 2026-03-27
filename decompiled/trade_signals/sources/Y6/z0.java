package Y6;

import d7.C1654o;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z0 extends C1654o implements InterfaceC0996b0, InterfaceC1026q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public A0 f9703d;

    @Override // Y6.InterfaceC1026q0
    public boolean c() {
        return true;
    }

    @Override // Y6.InterfaceC1026q0
    public F0 d() {
        return null;
    }

    @Override // Y6.InterfaceC0996b0
    public void dispose() {
        u().D0(this);
    }

    @Override // d7.C1654o
    public String toString() {
        return P.a(this) + '@' + P.b(this) + "[job@" + P.b(u()) + ']';
    }

    public final A0 u() {
        A0 a02 = this.f9703d;
        if (a02 != null) {
            return a02;
        }
        AbstractC2304t.s("job");
        return null;
    }

    public abstract boolean v();

    public abstract void w(Throwable th);

    public final void x(A0 a02) {
        this.f9703d = a02;
    }
}
