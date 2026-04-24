package I3;

import H3.k;
import android.view.LayoutInflater;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class e implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f4090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f4092c;

    public e(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f4090a = interfaceC2426a;
        this.f4091b = interfaceC2426a2;
        this.f4092c = interfaceC2426a3;
    }

    public static e a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new e(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static d c(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        return new d(kVar, layoutInflater, iVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d get() {
        return c((k) this.f4090a.get(), (LayoutInflater) this.f4091b.get(), (R3.i) this.f4092c.get());
    }
}
