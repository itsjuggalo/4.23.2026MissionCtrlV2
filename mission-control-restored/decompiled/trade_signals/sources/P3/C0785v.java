package P3;

import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0785v implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0784u f6426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6427b;

    public C0785v(C0784u c0784u, InterfaceC2426a interfaceC2426a) {
        this.f6426a = c0784u;
        this.f6427b = interfaceC2426a;
    }

    public static C0785v a(C0784u c0784u, InterfaceC2426a interfaceC2426a) {
        return new C0785v(c0784u, interfaceC2426a);
    }

    public static U4.a c(C0784u c0784u, Application application) {
        return (U4.a) E3.d.e(c0784u.a(application));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public U4.a get() {
        return c(this.f6426a, (Application) this.f6427b.get());
    }
}
