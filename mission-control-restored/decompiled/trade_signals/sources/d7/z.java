package d7;

import Y6.AbstractC0993a;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2750b;
import u5.InterfaceC2778e;

/* JADX INFO: loaded from: classes2.dex */
public class z extends AbstractC0993a implements InterfaceC2778e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2707e f17082d;

    public z(InterfaceC2711i interfaceC2711i, InterfaceC2707e interfaceC2707e) {
        super(interfaceC2711i, true, true);
        this.f17082d = interfaceC2707e;
    }

    @Override // Y6.AbstractC0993a
    public void P0(Object obj) {
        InterfaceC2707e interfaceC2707e = this.f17082d;
        interfaceC2707e.resumeWith(Y6.C.a(obj, interfaceC2707e));
    }

    @Override // u5.InterfaceC2778e
    public final InterfaceC2778e getCallerFrame() {
        InterfaceC2707e interfaceC2707e = this.f17082d;
        if (interfaceC2707e instanceof InterfaceC2778e) {
            return (InterfaceC2778e) interfaceC2707e;
        }
        return null;
    }

    @Override // Y6.A0
    public final boolean o0() {
        return true;
    }

    @Override // Y6.A0
    public void w(Object obj) {
        AbstractC1648i.b(AbstractC2750b.c(this.f17082d), Y6.C.a(obj, this.f17082d));
    }
}
