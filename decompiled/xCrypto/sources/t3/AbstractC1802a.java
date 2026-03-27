package t3;

/* JADX INFO: renamed from: t3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1802a extends E0 implements InterfaceC1846w0, Z2.e, L {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Z2.i f14974c;

    public AbstractC1802a(Z2.i iVar, boolean z4, boolean z5) {
        super(z5);
        if (z4) {
            e0((InterfaceC1846w0) iVar.get(InterfaceC1846w0.f15039M));
        }
        this.f14974c = iVar.plus(this);
    }

    @Override // t3.E0
    public String I() {
        return P.a(this) + " was cancelled";
    }

    public void K0(Object obj) {
        y(obj);
    }

    public final void N0(N n4, Object obj, i3.o oVar) {
        n4.c(oVar, obj, this);
    }

    @Override // t3.E0
    public final void d0(Throwable th) {
        K.a(this.f14974c, th);
    }

    @Override // Z2.e
    public final Z2.i getContext() {
        return this.f14974c;
    }

    @Override // t3.E0, t3.InterfaceC1846w0
    public boolean isActive() {
        return super.isActive();
    }

    @Override // t3.L
    public Z2.i l() {
        return this.f14974c;
    }

    @Override // t3.E0
    public String m0() {
        String strB = H.b(this.f14974c);
        if (strB == null) {
            return super.m0();
        }
        return '\"' + strB + "\":" + super.m0();
    }

    @Override // Z2.e
    public final void resumeWith(Object obj) {
        Object objK0 = k0(G.d(obj, null, 1, null));
        if (objK0 == F0.f14935b) {
            return;
        }
        K0(objK0);
    }

    @Override // t3.E0
    public final void t0(Object obj) {
        if (!(obj instanceof C)) {
            M0(obj);
        } else {
            C c4 = (C) obj;
            L0(c4.f14907a, c4.a());
        }
    }

    public void M0(Object obj) {
    }

    public void L0(Throwable th, boolean z4) {
    }
}
