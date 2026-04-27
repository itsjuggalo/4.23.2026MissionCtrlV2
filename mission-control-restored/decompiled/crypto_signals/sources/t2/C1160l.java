package t2;

/* JADX INFO: renamed from: t2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1160l implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1160l f10151a = new C1160l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10152b = F2.c.a("baseAddress");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10153c = F2.c.a("size");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10154d = F2.c.a("name");
    public static final F2.c e = F2.c.a("uuid");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1131T c1131t = (C1131T) ((x0) obj);
        eVar.f(f10152b, c1131t.f10022a);
        eVar.f(f10153c, c1131t.f10023b);
        eVar.a(f10154d, c1131t.f10024c);
        String str = c1131t.f10025d;
        eVar.a(e, str != null ? str.getBytes(O0.f10006a) : null);
    }
}
