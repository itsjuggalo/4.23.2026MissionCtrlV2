package b6;

/* JADX INFO: renamed from: b6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1057a extends E0 implements InterfaceC1101w0, H5.d, L {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H5.g f9032c;

    public AbstractC1057a(H5.g gVar, boolean z7, boolean z8) {
        super(z8);
        if (z7) {
            d0((InterfaceC1101w0) gVar.get(InterfaceC1101w0.f9097L));
        }
        this.f9032c = gVar.plus(this);
    }

    @Override // b6.E0
    public String E() {
        return P.a(this) + " was cancelled";
    }

    public void K0(Object obj) {
        v(obj);
    }

    public final void N0(N n7, Object obj, Q5.o oVar) {
        n7.b(oVar, obj, this);
    }

    @Override // b6.E0
    public final void b0(Throwable th) {
        K.a(this.f9032c, th);
    }

    @Override // H5.d
    public final H5.g getContext() {
        return this.f9032c;
    }

    @Override // b6.L
    public H5.g h() {
        return this.f9032c;
    }

    @Override // b6.E0, b6.InterfaceC1101w0
    public boolean isActive() {
        return super.isActive();
    }

    @Override // b6.E0
    public String m0() {
        String strB = H.b(this.f9032c);
        if (strB == null) {
            return super.m0();
        }
        return '\"' + strB + "\":" + super.m0();
    }

    @Override // H5.d
    public final void resumeWith(Object obj) {
        Object objK0 = k0(G.d(obj, null, 1, null));
        if (objK0 == F0.f8993b) {
            return;
        }
        K0(objK0);
    }

    @Override // b6.E0
    public final void t0(Object obj) {
        if (!(obj instanceof C1056C)) {
            M0(obj);
        } else {
            C1056C c1056c = (C1056C) obj;
            L0(c1056c.f8965a, c1056c.a());
        }
    }

    public void M0(Object obj) {
    }

    public void L0(Throwable th, boolean z7) {
    }
}
