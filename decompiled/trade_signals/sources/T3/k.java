package T3;

import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public class k implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f7986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2329m f7987b;

    public k(p pVar, C2329m c2329m) {
        this.f7986a = pVar;
        this.f7987b = c2329m;
    }

    @Override // T3.o
    public boolean a(Exception exc) {
        this.f7987b.d(exc);
        return true;
    }

    @Override // T3.o
    public boolean b(U3.d dVar) {
        if (!dVar.k() || this.f7986a.f(dVar)) {
            return false;
        }
        this.f7987b.c(m.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}
