package eh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public static final b a(b from, pd.k builderAction) {
        kotlin.jvm.internal.t.f(from, "from");
        kotlin.jvm.internal.t.f(builderAction, "builderAction");
        e eVar = new e(from);
        builderAction.invoke(eVar);
        return new t(eVar.a(), eVar.b());
    }

    public static /* synthetic */ b b(b bVar, pd.k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bVar = b.f8972d;
        }
        return a(bVar, kVar);
    }
}
