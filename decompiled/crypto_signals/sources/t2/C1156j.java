package t2;

/* JADX INFO: renamed from: t2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1156j implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1156j f10128a = new C1156j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10129b = F2.c.a("generator");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10130c = F2.c.a("identifier");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10131d = F2.c.a("appQualitySessionId");
    public static final F2.c e = F2.c.a("startedAt");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10132f = F2.c.a("endedAt");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f10133g = F2.c.a("crashed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f10134h = F2.c.a("app");
    public static final F2.c i = F2.c.a("user");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F2.c f10135j = F2.c.a("os");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final F2.c f10136k = F2.c.a("device");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final F2.c f10137l = F2.c.a("events");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final F2.c f10138m = F2.c.a("generatorType");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1122J c1122j = (C1122J) ((N0) obj);
        eVar.a(f10129b, c1122j.f9970a);
        eVar.a(f10130c, c1122j.f9971b.getBytes(O0.f10006a));
        eVar.a(f10131d, c1122j.f9972c);
        eVar.f(e, c1122j.f9973d);
        eVar.a(f10132f, c1122j.e);
        eVar.e(f10133g, c1122j.f9974f);
        eVar.a(f10134h, c1122j.f9975g);
        eVar.a(i, c1122j.f9976h);
        eVar.a(f10135j, c1122j.i);
        eVar.a(f10136k, c1122j.f9977j);
        eVar.a(f10137l, c1122j.f9978k);
        eVar.g(f10138m, c1122j.f9979l);
    }
}
