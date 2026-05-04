package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f7876a;

    public g1(o0 o0Var) {
        this.f7876a = o0Var;
    }

    public void c() {
        this.f7876a.f(new s0.a() { // from class: d9.f1
            @Override // s0.a
            public final void accept(Object obj) {
                ((g9.q0) obj).B();
            }
        });
    }

    public void d() {
        this.f7876a.f(new s0.a() { // from class: d9.e1
            @Override // s0.a
            public final void accept(Object obj) {
                ((g9.q0) obj).N(false);
            }
        });
    }

    public void e() {
        this.f7876a.f(new s0.a() { // from class: d9.d1
            @Override // s0.a
            public final void accept(Object obj) {
                ((g9.q0) obj).N(true);
            }
        });
    }
}
