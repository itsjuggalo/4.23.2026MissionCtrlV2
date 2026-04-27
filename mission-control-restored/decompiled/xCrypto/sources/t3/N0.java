package t3;

import W2.p;

/* JADX INFO: loaded from: classes3.dex */
public final class N0 extends D0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1832p f14958e;

    public N0(C1832p c1832p) {
        this.f14958e = c1832p;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return W2.E.f5463a;
    }

    @Override // t3.E
    public void q(Throwable th) {
        Object objB0 = r().b0();
        if (objB0 instanceof C) {
            C1832p c1832p = this.f14958e;
            p.a aVar = W2.p.f5487b;
            c1832p.resumeWith(W2.p.b(W2.q.a(((C) objB0).f14907a)));
        } else {
            C1832p c1832p2 = this.f14958e;
            p.a aVar2 = W2.p.f5487b;
            c1832p2.resumeWith(W2.p.b(F0.h(objB0)));
        }
    }
}
