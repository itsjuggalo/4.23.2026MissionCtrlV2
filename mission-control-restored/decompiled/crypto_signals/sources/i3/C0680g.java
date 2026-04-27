package i3;

/* JADX INFO: renamed from: i3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0680g implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0680g f6933a = new C0680g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6934b = F2.c.a("eventType");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6935c = F2.c.a("sessionData");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6936d = F2.c.a("applicationInfo");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        O o3 = (O) obj;
        F2.e eVar = (F2.e) obj2;
        o3.getClass();
        eVar.a(f6934b, EnumC0686m.f6983b);
        eVar.a(f6935c, o3.f6852a);
        eVar.a(f6936d, o3.f6853b);
    }
}
