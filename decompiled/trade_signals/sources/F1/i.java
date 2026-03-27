package F1;

import G1.x;
import H1.InterfaceC0586d;
import android.content.Context;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class i implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f1519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f1520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f1521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f1522d;

    public i(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4) {
        this.f1519a = interfaceC2426a;
        this.f1520b = interfaceC2426a2;
        this.f1521c = interfaceC2426a3;
        this.f1522d = interfaceC2426a4;
    }

    public static i a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3, InterfaceC2426a interfaceC2426a4) {
        return new i(interfaceC2426a, interfaceC2426a2, interfaceC2426a3, interfaceC2426a4);
    }

    public static x c(Context context, InterfaceC0586d interfaceC0586d, G1.f fVar, J1.a aVar) {
        return (x) B1.d.d(h.a(context, interfaceC0586d, fVar, aVar));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((Context) this.f1519a.get(), (InterfaceC0586d) this.f1520b.get(), (G1.f) this.f1521c.get(), (J1.a) this.f1522d.get());
    }
}
