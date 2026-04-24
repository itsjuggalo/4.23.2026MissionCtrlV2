package Y0;

import b1.C0379a;

/* JADX INFO: loaded from: classes.dex */
public final class a implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3530a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f3531b = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(1))), "window");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f3532c = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(2))), "logSourceMetrics");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F2.c f3533d = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(3))), "globalMetrics");
    public static final F2.c e = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(4))), "appNamespace");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0379a c0379a = (C0379a) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f3531b, c0379a.f4867a);
        eVar.a(f3532c, c0379a.f4868b);
        eVar.a(f3533d, c0379a.f4869c);
        eVar.a(e, c0379a.f4870d);
    }
}
