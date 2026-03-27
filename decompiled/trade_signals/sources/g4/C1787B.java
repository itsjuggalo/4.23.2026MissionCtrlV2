package g4;

import android.content.Context;
import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: g4.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1787B implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f18013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f18014b;

    public C1787B(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f18013a = interfaceC2426a;
        this.f18014b = interfaceC2426a2;
    }

    public static C1787B a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new C1787B(interfaceC2426a, interfaceC2426a2);
    }

    public static C1786A c(Context context, InterfaceC1810Z interfaceC1810Z) {
        return new C1786A(context, interfaceC1810Z);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1786A get() {
        return c((Context) this.f18013a.get(), (InterfaceC1810Z) this.f18014b.get());
    }
}
