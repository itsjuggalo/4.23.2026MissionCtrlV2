package i3;

import android.os.Build;

/* JADX INFO: renamed from: i3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0677d implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0677d f6912a = new C0677d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f6913b = F2.c.a("appId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f6914c = F2.c.a("deviceModel");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f6915d = F2.c.a("sessionSdkVersion");
    public static final F2.c e = F2.c.a("osVersion");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F2.c f6916f = F2.c.a("logEnvironment");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F2.c f6917g = F2.c.a("androidAppInfo");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0675b c0675b = (C0675b) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f6913b, c0675b.f6899a);
        eVar.a(f6914c, Build.MODEL);
        eVar.a(f6915d, "3.0.0");
        eVar.a(e, Build.VERSION.RELEASE);
        eVar.a(f6916f, EnumC0672A.f6824b);
        eVar.a(f6917g, c0675b.f6900b);
    }
}
