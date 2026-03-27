package s6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    public static final a a(a from, Q5.k builderAction) {
        kotlin.jvm.internal.r.f(from, "from");
        kotlin.jvm.internal.r.f(builderAction, "builderAction");
        d dVar = new d(from);
        builderAction.invoke(dVar);
        return new m(dVar.a(), dVar.b());
    }

    public static /* synthetic */ a b(a aVar, Q5.k kVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            aVar = a.f23013d;
        }
        return a(aVar, kVar);
    }
}
