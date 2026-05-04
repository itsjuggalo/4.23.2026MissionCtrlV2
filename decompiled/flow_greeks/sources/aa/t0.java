package aa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f578a;

    public t0(bd.a aVar) {
        this.f578a = aVar;
    }

    public static t0 a(bd.a aVar) {
        return new t0(aVar);
    }

    public static s0 c(q2 q2Var) {
        return new s0(q2Var);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public s0 get() {
        return c((q2) this.f578a.get());
    }
}
