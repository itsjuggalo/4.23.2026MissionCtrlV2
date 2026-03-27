package v3;

import java.util.concurrent.CancellationException;
import t3.AbstractC1802a;
import t3.C1848x0;
import t3.E0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends AbstractC1802a implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f15363d;

    public e(Z2.i iVar, d dVar, boolean z4, boolean z5) {
        super(iVar, z4, z5);
        this.f15363d = dVar;
    }

    @Override // t3.E0
    public void E(Throwable th) {
        CancellationException cancellationExceptionD0 = E0.D0(this, th, null, 1, null);
        this.f15363d.cancel(cancellationExceptionD0);
        C(cancellationExceptionD0);
    }

    public final d O0() {
        return this.f15363d;
    }

    @Override // v3.u
    public Object a(Object obj, Z2.e eVar) {
        return this.f15363d.a(obj, eVar);
    }

    @Override // v3.u
    public void b(i3.k kVar) {
        this.f15363d.b(kVar);
    }

    @Override // v3.t
    public Object c(Z2.e eVar) {
        return this.f15363d.c(eVar);
    }

    @Override // t3.E0, t3.InterfaceC1846w0
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new C1848x0(I(), null, this);
        }
        E(cancellationException);
    }

    @Override // v3.t
    public Object d() {
        return this.f15363d.d();
    }

    @Override // v3.t
    public f iterator() {
        return this.f15363d.iterator();
    }

    @Override // v3.u
    public boolean k(Throwable th) {
        return this.f15363d.k(th);
    }

    @Override // v3.u
    public Object m(Object obj) {
        return this.f15363d.m(obj);
    }

    @Override // v3.u
    public boolean n() {
        return this.f15363d.n();
    }

    @Override // t3.E0, t3.InterfaceC1846w0
    public /* synthetic */ void cancel() {
        E(new C1848x0(I(), null, this));
    }

    @Override // t3.E0, t3.InterfaceC1846w0
    public final /* synthetic */ boolean cancel(Throwable th) {
        E(new C1848x0(I(), null, this));
        return true;
    }
}
