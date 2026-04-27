package H1;

import android.content.Context;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class X implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f3607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f3608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f3609c;

    public X(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f3607a = interfaceC2426a;
        this.f3608b = interfaceC2426a2;
        this.f3609c = interfaceC2426a3;
    }

    public static X a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new X(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static W c(Context context, String str, int i8) {
        return new W(context, str, i8);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public W get() {
        return c((Context) this.f3607a.get(), (String) this.f3608b.get(), ((Integer) this.f3609c.get()).intValue());
    }
}
