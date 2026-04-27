package t2;

/* JADX INFO: renamed from: t2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1171s implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1171s f10196a = new C1171s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10197b = F2.c.a("batteryLevel");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10198c = F2.c.a("batteryVelocity");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10199d = F2.c.a("proximityOn");
    public static final F2.c e = F2.c.a("orientation");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10200f = F2.c.a("ramUsed");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f10201g = F2.c.a("diskUsed");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1143c0 c1143c0 = (C1143c0) ((F0) obj);
        eVar.a(f10197b, c1143c0.f10074a);
        eVar.g(f10198c, c1143c0.f10075b);
        eVar.e(f10199d, c1143c0.f10076c);
        eVar.g(e, c1143c0.f10077d);
        eVar.f(f10200f, c1143c0.e);
        eVar.f(f10201g, c1143c0.f10078f);
    }
}
