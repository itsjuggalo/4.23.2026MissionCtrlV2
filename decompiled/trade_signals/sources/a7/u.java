package a7;

import Y6.K;
import a7.x;
import o5.C2470H;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends h implements v {
    public u(InterfaceC2711i interfaceC2711i, g gVar) {
        super(interfaceC2711i, gVar, true, true);
    }

    @Override // Y6.AbstractC0993a
    public void Q0(Throwable th, boolean z7) {
        if (T0().h(th) || z7) {
            return;
        }
        K.a(getContext(), th);
    }

    @Override // Y6.AbstractC0993a
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void R0(C2470H c2470h) {
        x.a.a(T0(), null, 1, null);
    }

    @Override // Y6.AbstractC0993a, Y6.A0, Y6.InterfaceC1033u0
    public boolean c() {
        return super.c();
    }
}
