package t2;

/* JADX INFO: renamed from: t2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1162m implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1162m f10158a = new C1162m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10159b = F2.c.a("threads");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10160c = F2.c.a("exception");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10161d = F2.c.a("appExitInfo");
    public static final F2.c e = F2.c.a("signal");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10162f = F2.c.a("binaries");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1130S c1130s = (C1130S) ((C0) obj);
        eVar.a(f10159b, c1130s.f10018a);
        eVar.a(f10160c, c1130s.f10019b);
        eVar.a(f10161d, c1130s.f10020c);
        eVar.a(e, c1130s.f10021d);
        eVar.a(f10162f, c1130s.e);
    }
}
