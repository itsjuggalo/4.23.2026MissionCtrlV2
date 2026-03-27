package t2;

/* JADX INFO: renamed from: t2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1148f implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1148f f10098a = new C1148f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f10099b = F2.c.a("filename");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f10100c = F2.c.a("contents");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        F2.e eVar = (F2.e) obj2;
        C1120H c1120h = (C1120H) ((s0) obj);
        eVar.a(f10099b, c1120h.f9957a);
        eVar.a(f10100c, c1120h.f9958b);
    }
}
