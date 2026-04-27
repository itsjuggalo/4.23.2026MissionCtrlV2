package X0;

/* JADX INFO: renamed from: X0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0257j implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0257j f3466a = new C0257j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f3467b = F2.c.a("requestTimeMs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f3468c = F2.c.a("requestUptimeMs");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f3469d = F2.c.a("clientInfo");
    public static final F2.c e = F2.c.a("logSource");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f3470f = F2.c.a("logSourceName");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f3471g = F2.c.a("logEvent");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f3472h = F2.c.a("qosTier");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        u uVar = (u) ((G) obj);
        eVar.f(f3467b, uVar.f3507a);
        eVar.f(f3468c, uVar.f3508b);
        eVar.a(f3469d, uVar.f3509c);
        eVar.a(e, uVar.f3510d);
        eVar.a(f3470f, uVar.e);
        eVar.a(f3471g, uVar.f3511f);
        eVar.a(f3472h, K.f3430a);
    }
}
