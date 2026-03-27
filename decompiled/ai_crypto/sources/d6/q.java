package d6;

import E5.E;
import b6.K;
import d6.t;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends e implements r {
    public q(H5.g gVar, d dVar) {
        super(gVar, dVar, true, true);
    }

    @Override // b6.AbstractC1057a
    public void L0(Throwable th, boolean z7) {
        if (O0().d(th) || z7) {
            return;
        }
        K.a(getContext(), th);
    }

    @Override // b6.AbstractC1057a
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public void M0(E e7) {
        t.a.a(O0(), null, 1, null);
    }

    @Override // b6.AbstractC1057a, b6.E0, b6.InterfaceC1101w0
    public boolean isActive() {
        return super.isActive();
    }
}
