package I3;

import H3.k;
import android.view.LayoutInflater;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class g implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f4097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f4099c;

    public g(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f4097a = interfaceC2426a;
        this.f4098b = interfaceC2426a2;
        this.f4099c = interfaceC2426a3;
    }

    public static g a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new g(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static f c(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        return new f(kVar, layoutInflater, iVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f get() {
        return c((k) this.f4097a.get(), (LayoutInflater) this.f4098b.get(), (R3.i) this.f4099c.get());
    }
}
