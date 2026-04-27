package t3;

import W2.p;

/* JADX INFO: loaded from: classes3.dex */
public final class O0 extends D0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Z2.e f14959e;

    public O0(Z2.e eVar) {
        this.f14959e = eVar;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return W2.E.f5463a;
    }

    @Override // t3.E
    public void q(Throwable th) {
        Z2.e eVar = this.f14959e;
        p.a aVar = W2.p.f5487b;
        eVar.resumeWith(W2.p.b(W2.E.f5463a));
    }
}
