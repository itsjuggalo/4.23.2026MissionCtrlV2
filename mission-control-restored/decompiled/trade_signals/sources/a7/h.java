package a7;

import Y6.A0;
import Y6.AbstractC0993a;
import Y6.v0;
import java.util.concurrent.CancellationException;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends AbstractC0993a implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f10221d;

    public h(InterfaceC2711i interfaceC2711i, g gVar, boolean z7, boolean z8) {
        super(interfaceC2711i, z7, z8);
        this.f10221d = gVar;
    }

    @Override // Y6.A0
    public void C(Throwable th) {
        CancellationException cancellationExceptionI0 = A0.I0(this, th, null, 1, null);
        this.f10221d.e(cancellationExceptionI0);
        z(cancellationExceptionI0);
    }

    public final g T0() {
        return this.f10221d;
    }

    @Override // a7.x
    public void b(B5.k kVar) {
        this.f10221d.b(kVar);
    }

    @Override // a7.w
    public Object d() {
        return this.f10221d.d();
    }

    @Override // Y6.A0, Y6.InterfaceC1033u0
    public final void e(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new v0(H(), null, this);
        }
        C(cancellationException);
    }

    @Override // a7.x
    public boolean h(Throwable th) {
        return this.f10221d.h(th);
    }

    @Override // a7.w
    public i iterator() {
        return this.f10221d.iterator();
    }

    @Override // a7.w
    public Object l(InterfaceC2707e interfaceC2707e) {
        return this.f10221d.l(interfaceC2707e);
    }

    @Override // a7.x
    public Object m(Object obj) {
        return this.f10221d.m(obj);
    }

    @Override // a7.x
    public Object n(Object obj, InterfaceC2707e interfaceC2707e) {
        return this.f10221d.n(obj, interfaceC2707e);
    }

    @Override // a7.x
    public boolean o() {
        return this.f10221d.o();
    }
}
