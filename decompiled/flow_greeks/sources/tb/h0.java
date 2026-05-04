package tb;

import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class h0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.k1 f21383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s.a f21384b;

    public h0(rb.k1 k1Var, s.a aVar) {
        p6.n.e(!k1Var.p(), "error must not be OK");
        this.f21383a = k1Var;
        this.f21384b = aVar;
    }

    @Override // rb.p0
    public rb.k0 f() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // tb.t
    public r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
        return new g0(this.f21383a, this.f21384b, kVarArr);
    }
}
