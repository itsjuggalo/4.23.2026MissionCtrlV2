package t2;

/* JADX INFO: renamed from: t2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1164n implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1164n f10168a = new C1164n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10169b = F2.c.a("type");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10170c = F2.c.a("reason");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10171d = F2.c.a("frames");
    public static final F2.c e = F2.c.a("causedBy");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10172f = F2.c.a("overflowCount");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1132U c1132u = (C1132U) ((y0) obj);
        eVar.a(f10169b, c1132u.f10026a);
        eVar.a(f10170c, c1132u.f10027b);
        eVar.a(f10171d, c1132u.f10028c);
        eVar.a(e, c1132u.f10029d);
        eVar.g(f10172f, c1132u.e);
    }
}
