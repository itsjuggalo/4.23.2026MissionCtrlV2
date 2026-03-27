package I3;

import H3.k;
import android.view.LayoutInflater;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class i implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f4111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f4113c;

    public i(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f4111a = interfaceC2426a;
        this.f4112b = interfaceC2426a2;
        this.f4113c = interfaceC2426a3;
    }

    public static i a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new i(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static h c(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        return new h(kVar, layoutInflater, iVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h get() {
        return c((k) this.f4111a.get(), (LayoutInflater) this.f4112b.get(), (R3.i) this.f4113c.get());
    }
}
