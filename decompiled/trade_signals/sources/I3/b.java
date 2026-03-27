package I3;

import H3.k;
import android.view.LayoutInflater;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class b implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f4072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f4074c;

    public b(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f4072a = interfaceC2426a;
        this.f4073b = interfaceC2426a2;
        this.f4074c = interfaceC2426a3;
    }

    public static b a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new b(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static a c(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        return new a(kVar, layoutInflater, iVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((k) this.f4072a.get(), (LayoutInflater) this.f4073b.get(), (R3.i) this.f4074c.get());
    }
}
