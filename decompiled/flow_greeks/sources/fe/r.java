package fe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w1 f9505a;

    public r(w1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        this.f9505a = delegate;
    }

    @Override // fe.u
    public w1 b() {
        return this.f9505a;
    }

    @Override // fe.u
    public String c() {
        return b().b();
    }

    @Override // fe.u
    public u f() {
        u uVarJ = t.j(b().d());
        kotlin.jvm.internal.t.e(uVarJ, "toDescriptorVisibility(...)");
        return uVarJ;
    }
}
