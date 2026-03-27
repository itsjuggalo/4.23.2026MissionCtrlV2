package s2;

/* JADX INFO: renamed from: s2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0998a implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0998a f9534a = new C0998a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f9535b = F2.c.a("rolloutId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f9536c = F2.c.a("parameterKey");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f9537d = F2.c.a("parameterValue");
    public static final F2.c e = F2.c.a("variantId");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f9538f = F2.c.a("templateVersion");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C0999b c0999b = (C0999b) ((n) obj);
        eVar.a(f9535b, c0999b.f9539b);
        eVar.a(f9536c, c0999b.f9540c);
        eVar.a(f9537d, c0999b.f9541d);
        eVar.a(e, c0999b.e);
        eVar.f(f9538f, c0999b.f9542f);
    }
}
