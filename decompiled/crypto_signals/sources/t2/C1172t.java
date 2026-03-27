package t2;

/* JADX INFO: renamed from: t2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1172t implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1172t f10202a = new C1172t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10203b = F2.c.a("timestamp");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10204c = F2.c.a("type");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10205d = F2.c.a("app");
    public static final F2.c e = F2.c.a("device");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10206f = F2.c.a("log");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f10207g = F2.c.a("rollouts");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1128P c1128p = (C1128P) ((K0) obj);
        eVar.f(f10203b, c1128p.f10007a);
        eVar.a(f10204c, c1128p.f10008b);
        eVar.a(f10205d, c1128p.f10009c);
        eVar.a(e, c1128p.f10010d);
        eVar.a(f10206f, c1128p.e);
        eVar.a(f10207g, c1128p.f10011f);
    }
}
