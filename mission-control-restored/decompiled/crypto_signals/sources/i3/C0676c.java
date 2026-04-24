package i3;

import android.os.Build;

/* JADX INFO: renamed from: i3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0676c implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0676c f6904a = new C0676c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6905b = F2.c.a("packageName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6906c = F2.c.a("versionName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6907d = F2.c.a("appBuildVersion");
    public static final F2.c e = F2.c.a("deviceManufacturer");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f6908f = F2.c.a("currentProcessDetails");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f6909g = F2.c.a("appProcessDetails");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0674a c0674a = (C0674a) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f6905b, c0674a.f6893a);
        eVar.a(f6906c, c0674a.f6894b);
        eVar.a(f6907d, c0674a.f6895c);
        eVar.a(e, Build.MANUFACTURER);
        eVar.a(f6908f, c0674a.f6896d);
        eVar.a(f6909g, c0674a.e);
    }
}
