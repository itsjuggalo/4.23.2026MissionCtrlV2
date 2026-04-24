package u5;

import s5.C2712j;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: u5.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2783j extends AbstractC2774a {
    public AbstractC2783j(InterfaceC2707e interfaceC2707e) {
        super(interfaceC2707e);
        if (interfaceC2707e != null && interfaceC2707e.getContext() != C2712j.f23116a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override // s5.InterfaceC2707e
    public InterfaceC2711i getContext() {
        return C2712j.f23116a;
    }
}
