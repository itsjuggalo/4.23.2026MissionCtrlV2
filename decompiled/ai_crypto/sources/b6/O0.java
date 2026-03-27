package b6;

import E5.p;

/* JADX INFO: loaded from: classes2.dex */
public final class O0 extends D0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H5.d f9017e;

    public O0(H5.d dVar) {
        this.f9017e = dVar;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return E5.E.f1657a;
    }

    @Override // b6.E
    public void s(Throwable th) {
        H5.d dVar = this.f9017e;
        p.a aVar = E5.p.f1681b;
        dVar.resumeWith(E5.p.b(E5.E.f1657a));
    }
}
