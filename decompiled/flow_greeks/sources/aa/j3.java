package aa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j3 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f492b;

    public j3(bd.a aVar, bd.a aVar2) {
        this.f491a = aVar;
        this.f492b = aVar2;
    }

    public static j3 a(bd.a aVar, bd.a aVar2) {
        return new j3(aVar, aVar2);
    }

    public static i3 c(q2 q2Var, da.a aVar) {
        return new i3(q2Var, aVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i3 get() {
        return c((q2) this.f491a.get(), (da.a) this.f492b.get());
    }
}
