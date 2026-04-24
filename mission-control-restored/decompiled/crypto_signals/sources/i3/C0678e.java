package i3;

/* JADX INFO: renamed from: i3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0678e implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0678e f6920a = new C0678e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6921b = F2.c.a("performance");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6922c = F2.c.a("crashlytics");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6923d = F2.c.a("sessionSamplingRate");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0684k c0684k = (C0684k) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f6921b, c0684k.f6975a);
        eVar.a(f6922c, c0684k.f6976b);
        eVar.b(f6923d, c0684k.f6977c);
    }
}
