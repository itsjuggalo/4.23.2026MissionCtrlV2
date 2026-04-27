package t2;

/* JADX INFO: renamed from: t2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1150g implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1150g f10105a = new C1150g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10106b = F2.c.a("identifier");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10107c = F2.c.a("version");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10108d = F2.c.a("displayVersion");
    public static final F2.c e = F2.c.a("organization");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10109f = F2.c.a("installationUuid");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f10110g = F2.c.a("developmentPlatform");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f10111h = F2.c.a("developmentPlatformVersion");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1123K c1123k = (C1123K) ((v0) obj);
        eVar.a(f10106b, c1123k.f9980a);
        eVar.a(f10107c, c1123k.f9981b);
        eVar.a(f10108d, c1123k.f9982c);
        eVar.a(e, null);
        eVar.a(f10109f, c1123k.f9983d);
        eVar.a(f10110g, c1123k.e);
        eVar.a(f10111h, c1123k.f9984f);
    }
}
