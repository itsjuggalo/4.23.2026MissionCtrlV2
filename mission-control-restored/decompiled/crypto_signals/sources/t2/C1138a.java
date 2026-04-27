package t2;

/* JADX INFO: renamed from: t2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1138a implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1138a f10049a = new C1138a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10050b = F2.c.a("arch");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10051c = F2.c.a("libraryName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10052d = F2.c.a("buildId");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1117E c1117e = (C1117E) ((p0) obj);
        eVar.a(f10050b, c1117e.f9950a);
        eVar.a(f10051c, c1117e.f9951b);
        eVar.a(f10052d, c1117e.f9952c);
    }
}
