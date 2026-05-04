package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fe.l1 f24995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cd.k f24996b;

    public j1(fe.l1 typeParameter) {
        kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
        this.f24995a = typeParameter;
        this.f24996b = cd.l.a(cd.n.f3864b, new i1(this));
    }

    public static final r0 d(j1 j1Var) {
        return k1.b(j1Var.f24995a);
    }

    @Override // xf.a2
    public a2 a(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // xf.a2
    public m2 b() {
        return m2.f25017g;
    }

    @Override // xf.a2
    public boolean c() {
        return true;
    }

    public final r0 f() {
        return (r0) this.f24996b.getValue();
    }

    @Override // xf.a2
    public r0 getType() {
        return f();
    }
}
