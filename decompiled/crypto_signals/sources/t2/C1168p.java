package t2;

/* JADX INFO: renamed from: t2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1168p implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1168p f10183a = new C1168p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10184b = F2.c.a("name");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10185c = F2.c.a("importance");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10186d = F2.c.a("frames");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1134W c1134w = (C1134W) ((B0) obj);
        eVar.a(f10184b, c1134w.f10033a);
        eVar.g(f10185c, c1134w.f10034b);
        eVar.a(f10186d, c1134w.f10035c);
    }
}
