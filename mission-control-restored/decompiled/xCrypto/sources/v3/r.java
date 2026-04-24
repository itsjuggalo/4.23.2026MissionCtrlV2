package v3;

import W2.E;
import t3.K;
import v3.u;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends e implements s {
    public r(Z2.i iVar, d dVar) {
        super(iVar, dVar, true, true);
    }

    @Override // t3.AbstractC1802a
    public void L0(Throwable th, boolean z4) {
        if (O0().k(th) || z4) {
            return;
        }
        K.a(getContext(), th);
    }

    @Override // t3.AbstractC1802a
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public void M0(E e4) {
        u.a.a(O0(), null, 1, null);
    }

    @Override // t3.AbstractC1802a, t3.E0, t3.InterfaceC1846w0
    public boolean isActive() {
        return super.isActive();
    }
}
