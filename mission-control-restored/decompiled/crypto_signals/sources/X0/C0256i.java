package X0;

/* JADX INFO: renamed from: X0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0256i implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0256i f3458a = new C0256i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f3459b = F2.c.a("eventTimeMs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f3460c = F2.c.a("eventCode");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f3461d = F2.c.a("complianceData");
    public static final F2.c e = F2.c.a("eventUptimeMs");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f3462f = F2.c.a("sourceExtension");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f3463g = F2.c.a("sourceExtensionJsonProto3");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f3464h = F2.c.a("timezoneOffsetSeconds");
    public static final F2.c i = F2.c.a("networkConnectionInfo");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F2.c f3465j = F2.c.a("experimentIds");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        t tVar = (t) ((F) obj);
        eVar.f(f3459b, tVar.f3500a);
        eVar.a(f3460c, tVar.f3501b);
        eVar.a(f3461d, tVar.f3502c);
        eVar.f(e, tVar.f3503d);
        eVar.a(f3462f, tVar.e);
        eVar.a(f3463g, tVar.f3504f);
        eVar.f(f3464h, tVar.f3505g);
        eVar.a(i, tVar.f3506h);
        eVar.a(f3465j, tVar.i);
    }
}
