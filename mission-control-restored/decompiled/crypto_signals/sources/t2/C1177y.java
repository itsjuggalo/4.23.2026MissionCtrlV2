package t2;

/* JADX INFO: renamed from: t2.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1177y implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1177y f10224a = new C1177y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10225b = F2.c.a("platform");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10226c = F2.c.a("version");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10227d = F2.c.a("buildVersion");
    public static final F2.c e = F2.c.a("jailbroken");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1157j0 c1157j0 = (C1157j0) ((L0) obj);
        eVar.g(f10225b, c1157j0.f10139a);
        eVar.a(f10226c, c1157j0.f10140b);
        eVar.a(f10227d, c1157j0.f10141c);
        eVar.e(e, c1157j0.f10142d);
    }
}
