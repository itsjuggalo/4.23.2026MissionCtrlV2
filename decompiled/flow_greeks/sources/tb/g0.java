package tb;

import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.k1 f21242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s.a f21243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rb.k[] f21244e;

    public g0(rb.k1 k1Var, rb.k[] kVarArr) {
        this(k1Var, s.a.PROCESSED, kVarArr);
    }

    @Override // tb.o1, tb.r
    public void j(s sVar) {
        p6.n.u(!this.f21241b, "already started");
        this.f21241b = true;
        for (rb.k kVar : this.f21244e) {
            kVar.i(this.f21242c);
        }
        sVar.d(this.f21242c, this.f21243d, new rb.y0());
    }

    @Override // tb.o1, tb.r
    public void l(x0 x0Var) {
        x0Var.b("error", this.f21242c).b("progress", this.f21243d);
    }

    public g0(rb.k1 k1Var, s.a aVar, rb.k[] kVarArr) {
        p6.n.e(!k1Var.p(), "error must not be OK");
        this.f21242c = k1Var;
        this.f21243d = aVar;
        this.f21244e = kVarArr;
    }
}
