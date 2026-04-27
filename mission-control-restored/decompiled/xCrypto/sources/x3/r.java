package x3;

import b3.InterfaceC0867e;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Z2.e, InterfaceC0867e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.e f15788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z2.i f15789b;

    public r(Z2.e eVar, Z2.i iVar) {
        this.f15788a = eVar;
        this.f15789b = iVar;
    }

    @Override // b3.InterfaceC0867e
    public InterfaceC0867e getCallerFrame() {
        Z2.e eVar = this.f15788a;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    @Override // Z2.e
    public Z2.i getContext() {
        return this.f15789b;
    }

    @Override // Z2.e
    public void resumeWith(Object obj) {
        this.f15788a.resumeWith(obj);
    }
}
