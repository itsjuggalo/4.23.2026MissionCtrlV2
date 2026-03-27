package g6;

import b6.AbstractC1057a;

/* JADX INFO: loaded from: classes2.dex */
public class B extends AbstractC1057a implements J5.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H5.d f14267d;

    public B(H5.g gVar, H5.d dVar) {
        super(gVar, true, true);
        this.f14267d = dVar;
    }

    @Override // b6.AbstractC1057a
    public void K0(Object obj) {
        H5.d dVar = this.f14267d;
        dVar.resumeWith(b6.G.a(obj, dVar));
    }

    @Override // b6.E0
    public final boolean e0() {
        return true;
    }

    @Override // J5.e
    public final J5.e getCallerFrame() {
        H5.d dVar = this.f14267d;
        if (dVar instanceof J5.e) {
            return (J5.e) dVar;
        }
        return null;
    }

    @Override // b6.E0
    public void v(Object obj) {
        AbstractC1651k.c(I5.b.c(this.f14267d), b6.G.a(obj, this.f14267d), null, 2, null);
    }
}
