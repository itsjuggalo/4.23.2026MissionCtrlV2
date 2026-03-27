package Y0;

import b1.C0384f;

/* JADX INFO: loaded from: classes.dex */
public final class f implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f3543a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f3544b = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(1))), "currentCacheSizeBytes");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f3545c = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(2))), "maxCacheSizeBytes");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0384f c0384f = (C0384f) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.f(f3544b, c0384f.f4885a);
        eVar.f(f3545c, c0384f.f4886b);
    }
}
