package e6;

import E5.E;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q5.o f13972a;

    public p(Q5.o oVar) {
        this.f13972a = oVar;
    }

    @Override // e6.a
    public Object d(e eVar, H5.d dVar) {
        Object objInvoke = this.f13972a.invoke(eVar, dVar);
        return objInvoke == I5.c.e() ? objInvoke : E.f1657a;
    }
}
