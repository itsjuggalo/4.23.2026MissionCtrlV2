package K3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static final a a(a from, i3.k builderAction) {
        kotlin.jvm.internal.r.f(from, "from");
        kotlin.jvm.internal.r.f(builderAction, "builderAction");
        d dVar = new d(from);
        builderAction.invoke(dVar);
        return new m(dVar.a(), dVar.b());
    }

    public static /* synthetic */ a b(a aVar, i3.k kVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = a.f1326d;
        }
        return a(aVar, kVar);
    }
}
