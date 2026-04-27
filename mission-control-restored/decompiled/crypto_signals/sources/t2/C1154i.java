package t2;

/* JADX INFO: renamed from: t2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1154i implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1154i f10116a = new C1154i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10117b = F2.c.a("arch");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10118c = F2.c.a("model");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f10119d = F2.c.a("cores");
    public static final F2.c e = F2.c.a("ram");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f10120f = F2.c.a("diskSpace");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f10121g = F2.c.a("simulator");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F2.c f10122h = F2.c.a("state");
    public static final F2.c i = F2.c.a("manufacturer");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F2.c f10123j = F2.c.a("modelClass");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1126N c1126n = (C1126N) ((w0) obj);
        eVar.g(f10117b, c1126n.f9993a);
        eVar.a(f10118c, c1126n.f9994b);
        eVar.g(f10119d, c1126n.f9995c);
        eVar.f(e, c1126n.f9996d);
        eVar.f(f10120f, c1126n.e);
        eVar.e(f10121g, c1126n.f9997f);
        eVar.g(f10122h, c1126n.f9998g);
        eVar.a(i, c1126n.f9999h);
        eVar.a(f10123j, c1126n.i);
    }
}
