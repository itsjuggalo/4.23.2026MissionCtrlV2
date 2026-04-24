package i3;

/* JADX INFO: renamed from: i3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0679f implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0679f f6926a = new C0679f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6927b = F2.c.a("processName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6928c = F2.c.a("pid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6929d = F2.c.a("importance");
    public static final F2.c e = F2.c.a("defaultProcess");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        G g2 = (G) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f6927b, g2.f6837a);
        eVar.g(f6928c, g2.f6838b);
        eVar.g(f6929d, g2.f6839c);
        eVar.e(e, g2.f6840d);
    }
}
