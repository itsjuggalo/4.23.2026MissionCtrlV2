package m9;

import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s implements i0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y0.g f16260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y0.g f16261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y0.g f16262f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.b f16263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fa.b f16264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a7.p f16265c;

    static {
        y0.d dVar = rb.y0.f19747e;
        f16260d = y0.g.e("x-firebase-client-log-type", dVar);
        f16261e = y0.g.e("x-firebase-client", dVar);
        f16262f = y0.g.e("x-firebase-gmpid", dVar);
    }

    public s(fa.b bVar, fa.b bVar2, a7.p pVar) {
        this.f16264b = bVar;
        this.f16263a = bVar2;
        this.f16265c = pVar;
    }

    @Override // m9.i0
    public void a(rb.y0 y0Var) {
        if (this.f16263a.get() == null || this.f16264b.get() == null) {
            return;
        }
        int iB = ((o9.j) this.f16263a.get()).b("fire-fst").b();
        if (iB != 0) {
            y0Var.p(f16260d, Integer.toString(iB));
        }
        y0Var.p(f16261e, ((oa.i) this.f16264b.get()).a());
        b(y0Var);
    }

    public final void b(rb.y0 y0Var) {
        a7.p pVar = this.f16265c;
        if (pVar == null) {
            return;
        }
        String strC = pVar.c();
        if (strC.length() != 0) {
            y0Var.p(f16262f, strC);
        }
    }
}
