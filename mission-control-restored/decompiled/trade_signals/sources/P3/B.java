package P3;

import F4.AbstractC0490d;
import n5.InterfaceC2426a;
import r4.g;

/* JADX INFO: loaded from: classes.dex */
public final class B implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f6367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f6369c;

    public B(z zVar, InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f6367a = zVar;
        this.f6368b = interfaceC2426a;
        this.f6369c = interfaceC2426a2;
    }

    public static B a(z zVar, InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new B(zVar, interfaceC2426a, interfaceC2426a2);
    }

    public static g.b c(z zVar, AbstractC0490d abstractC0490d, F4.X x8) {
        return (g.b) E3.d.e(zVar.c(abstractC0490d, x8));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g.b get() {
        return c(this.f6367a, (AbstractC0490d) this.f6368b.get(), (F4.X) this.f6369c.get());
    }
}
