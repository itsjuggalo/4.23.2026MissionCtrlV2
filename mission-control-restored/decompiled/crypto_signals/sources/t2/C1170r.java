package t2;

/* JADX INFO: renamed from: t2.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1170r implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1170r f10192a = new C1170r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10193b = F2.c.a("processName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10194c = F2.c.a("pid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10195d = F2.c.a("importance");
    public static final F2.c e = F2.c.a("defaultProcess");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1139a0 c1139a0 = (C1139a0) ((D0) obj);
        eVar.a(f10193b, c1139a0.f10053a);
        eVar.g(f10194c, c1139a0.f10054b);
        eVar.g(f10195d, c1139a0.f10055c);
        eVar.e(e, c1139a0.f10056d);
    }
}
