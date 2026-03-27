package P3;

import F4.AbstractC0490d;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0787x implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0786w f6428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6429b;

    public C0787x(C0786w c0786w, InterfaceC2426a interfaceC2426a) {
        this.f6428a = c0786w;
        this.f6429b = interfaceC2426a;
    }

    public static C0787x a(C0786w c0786w, InterfaceC2426a interfaceC2426a) {
        return new C0787x(c0786w, interfaceC2426a);
    }

    public static AbstractC0490d c(C0786w c0786w, String str) {
        return (AbstractC0490d) E3.d.e(c0786w.a(str));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC0490d get() {
        return c(this.f6428a, (String) this.f6429b.get());
    }
}
