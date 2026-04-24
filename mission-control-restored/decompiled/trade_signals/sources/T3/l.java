package T3;

import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public class l implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2329m f7988a;

    public l(C2329m c2329m) {
        this.f7988a = c2329m;
    }

    @Override // T3.o
    public boolean a(Exception exc) {
        return false;
    }

    @Override // T3.o
    public boolean b(U3.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f7988a.e(dVar.d());
        return true;
    }
}
