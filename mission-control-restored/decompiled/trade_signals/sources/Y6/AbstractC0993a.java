package Y6;

import s5.InterfaceC2707e;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: Y6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0993a extends A0 implements InterfaceC1033u0, InterfaceC2707e, L {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2711i f9651c;

    public AbstractC0993a(InterfaceC2711i interfaceC2711i, boolean z7, boolean z8) {
        super(z8);
        if (z7) {
            l0((InterfaceC1033u0) interfaceC2711i.a(InterfaceC1033u0.f9694L));
        }
        this.f9651c = interfaceC2711i.m0(this);
    }

    @Override // Y6.A0
    public String H() {
        return P.a(this) + " was cancelled";
    }

    public void P0(Object obj) {
        w(obj);
    }

    public final void S0(N n8, Object obj, B5.o oVar) {
        n8.b(oVar, obj, this);
    }

    @Override // Y6.A0, Y6.InterfaceC1033u0
    public boolean c() {
        return super.c();
    }

    @Override // s5.InterfaceC2707e
    public final InterfaceC2711i getContext() {
        return this.f9651c;
    }

    @Override // Y6.L
    public InterfaceC2711i j() {
        return this.f9651c;
    }

    @Override // Y6.A0
    public final void k0(Throwable th) {
        K.a(this.f9651c, th);
    }

    @Override // s5.InterfaceC2707e
    public final void resumeWith(Object obj) {
        Object objT0 = t0(C.b(obj));
        if (objT0 == B0.f9615b) {
            return;
        }
        P0(objT0);
    }

    @Override // Y6.A0
    public String u0() {
        String strG = G.g(this.f9651c);
        if (strG == null) {
            return super.u0();
        }
        return '\"' + strG + "\":" + super.u0();
    }

    @Override // Y6.A0
    public final void z0(Object obj) {
        if (!(obj instanceof A)) {
            R0(obj);
        } else {
            A a8 = (A) obj;
            Q0(a8.f9602a, a8.a());
        }
    }

    public void R0(Object obj) {
    }

    public void Q0(Throwable th, boolean z7) {
    }
}
