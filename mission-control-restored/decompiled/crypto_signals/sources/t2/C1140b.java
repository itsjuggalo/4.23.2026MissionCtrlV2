package t2;

/* JADX INFO: renamed from: t2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1140b implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1140b f10057a = new C1140b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10058b = F2.c.a("pid");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10059c = F2.c.a("processName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10060d = F2.c.a("reasonCode");
    public static final F2.c e = F2.c.a("importance");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10061f = F2.c.a("pss");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f10062g = F2.c.a("rss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f10063h = F2.c.a("timestamp");
    public static final F2.c i = F2.c.a("traceFile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F2.c f10064j = F2.c.a("buildIdMappingForArch");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1116D c1116d = (C1116D) ((q0) obj);
        eVar.g(f10058b, c1116d.f9943a);
        eVar.a(f10059c, c1116d.f9944b);
        eVar.g(f10060d, c1116d.f9945c);
        eVar.g(e, c1116d.f9946d);
        eVar.f(f10061f, c1116d.e);
        eVar.f(f10062g, c1116d.f9947f);
        eVar.f(f10063h, c1116d.f9948g);
        eVar.a(i, c1116d.f9949h);
        eVar.a(f10064j, c1116d.i);
    }
}
