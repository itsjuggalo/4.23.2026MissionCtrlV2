package Y0;

import b1.C0382d;

/* JADX INFO: loaded from: classes.dex */
public final class c implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3536a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f3537b = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(1))), "eventsDroppedCount");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f3538c = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(3))), "reason");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0382d c0382d = (C0382d) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.f(f3537b, c0382d.f4880a);
        eVar.a(f3538c, c0382d.f4881b);
    }
}
