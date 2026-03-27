package A1;

import android.content.Context;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class j implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f30a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f31b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f32c;

    public j(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f30a = interfaceC2426a;
        this.f31b = interfaceC2426a2;
        this.f32c = interfaceC2426a3;
    }

    public static j a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new j(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static i c(Context context, J1.a aVar, J1.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f30a.get(), (J1.a) this.f31b.get(), (J1.a) this.f32c.get());
    }
}
