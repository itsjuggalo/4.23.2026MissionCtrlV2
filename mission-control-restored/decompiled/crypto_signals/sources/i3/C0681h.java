package i3;

/* JADX INFO: renamed from: i3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0681h implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0681h f6941a = new C0681h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6942b = F2.c.a("sessionId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6943c = F2.c.a("firstSessionId");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6944d = F2.c.a("sessionIndex");
    public static final F2.c e = F2.c.a("eventTimestampUs");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f6945f = F2.c.a("dataCollectionStatus");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f6946g = F2.c.a("firebaseInstallationId");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f6947h = F2.c.a("firebaseAuthenticationToken");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        X x6 = (X) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f6942b, x6.f6881a);
        eVar.a(f6943c, x6.f6882b);
        eVar.g(f6944d, x6.f6883c);
        eVar.f(e, x6.f6884d);
        eVar.a(f6945f, x6.e);
        eVar.a(f6946g, x6.f6885f);
        eVar.a(f6947h, x6.f6886g);
    }
}
