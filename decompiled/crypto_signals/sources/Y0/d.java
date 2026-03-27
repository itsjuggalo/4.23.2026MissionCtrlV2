package Y0;

import b1.C0383e;

/* JADX INFO: loaded from: classes.dex */
public final class d implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3539a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F2.c f3540b = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(1))), "logSource");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F2.c f3541c = new F2.c(k0.a.h(k0.a.g(I2.e.class, new I2.a(2))), "logEventDropped");

    @Override // F2.a
    public final void a(Object obj, Object obj2) {
        C0383e c0383e = (C0383e) obj;
        F2.e eVar = (F2.e) obj2;
        eVar.a(f3540b, c0383e.f4883a);
        eVar.a(f3541c, c0383e.f4884b);
    }
}
