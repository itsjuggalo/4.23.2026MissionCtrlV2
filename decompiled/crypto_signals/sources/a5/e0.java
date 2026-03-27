package a5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class e0 extends p0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4116c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0() {
        super(true);
        boolean z6 = true;
        x(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p0.f4153b;
        InterfaceC0310q interfaceC0310q = (InterfaceC0310q) atomicReferenceFieldUpdater.get(this);
        r rVar = interfaceC0310q instanceof r ? (r) interfaceC0310q : null;
        if (rVar == null) {
            z6 = false;
            break;
        }
        p0 p0VarI = rVar.i();
        while (!p0VarI.s()) {
            InterfaceC0310q interfaceC0310q2 = (InterfaceC0310q) atomicReferenceFieldUpdater.get(p0VarI);
            r rVar2 = interfaceC0310q2 instanceof r ? (r) interfaceC0310q2 : null;
            if (rVar2 == null) {
                z6 = false;
                break;
            }
            p0VarI = rVar2.i();
        }
        this.f4116c = z6;
    }

    @Override // a5.p0
    public final boolean s() {
        return this.f4116c;
    }

    @Override // a5.p0
    public final boolean t() {
        return true;
    }
}
