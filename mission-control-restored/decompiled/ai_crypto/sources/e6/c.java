package e6;

import E5.E;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends f6.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Q5.o f13898d;

    public c(Q5.o oVar, H5.g gVar, int i7, d6.a aVar) {
        super(gVar, i7, aVar);
        this.f13898d = oVar;
    }

    public static /* synthetic */ Object k(c cVar, d6.r rVar, H5.d dVar) {
        Object objInvoke = cVar.f13898d.invoke(rVar, dVar);
        return objInvoke == I5.c.e() ? objInvoke : E.f1657a;
    }

    @Override // f6.e
    public Object f(d6.r rVar, H5.d dVar) {
        return k(this, rVar, dVar);
    }

    @Override // f6.e
    public String toString() {
        return "block[" + this.f13898d + "] -> " + super.toString();
    }
}
