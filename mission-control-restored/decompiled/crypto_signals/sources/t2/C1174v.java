package t2;

/* JADX INFO: renamed from: t2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1174v implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1174v f10215a = new C1174v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10216b = F2.c.a("rolloutVariant");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10217c = F2.c.a("parameterKey");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10218d = F2.c.a("parameterValue");
    public static final F2.c e = F2.c.a("templateVersion");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1149f0 c1149f0 = (C1149f0) ((I0) obj);
        eVar.a(f10216b, c1149f0.f10101a);
        eVar.a(f10217c, c1149f0.f10102b);
        eVar.a(f10218d, c1149f0.f10103c);
        eVar.f(e, c1149f0.f10104d);
    }
}
