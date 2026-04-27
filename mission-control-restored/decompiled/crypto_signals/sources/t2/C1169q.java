package t2;

/* JADX INFO: renamed from: t2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1169q implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1169q f10187a = new C1169q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10188b = F2.c.a("pc");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10189c = F2.c.a("symbol");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10190d = F2.c.a("file");
    public static final F2.c e = F2.c.a("offset");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10191f = F2.c.a("importance");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1136Y c1136y = (C1136Y) ((A0) obj);
        eVar.f(f10188b, c1136y.f10041a);
        eVar.a(f10189c, c1136y.f10042b);
        eVar.a(f10190d, c1136y.f10043c);
        eVar.f(e, c1136y.f10044d);
        eVar.g(f10191f, c1136y.e);
    }
}
