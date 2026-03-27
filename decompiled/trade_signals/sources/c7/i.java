package c7;

import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements InterfaceC2711i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC2711i f13595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f13596b;

    public i(Throwable th, InterfaceC2711i interfaceC2711i) {
        this.f13595a = interfaceC2711i;
        this.f13596b = th;
    }

    @Override // s5.InterfaceC2711i
    public Object K(Object obj, B5.o oVar) {
        return this.f13595a.K(obj, oVar);
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i.b a(InterfaceC2711i.c cVar) {
        return this.f13595a.a(cVar);
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i m0(InterfaceC2711i interfaceC2711i) {
        return this.f13595a.m0(interfaceC2711i);
    }

    @Override // s5.InterfaceC2711i
    public InterfaceC2711i r0(InterfaceC2711i.c cVar) {
        return this.f13595a.r0(cVar);
    }
}
