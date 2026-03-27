package d6;

import b6.AbstractC1057a;
import b6.C1103x0;
import b6.E0;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends AbstractC1057a implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f13490d;

    public e(H5.g gVar, d dVar, boolean z7, boolean z8) {
        super(gVar, z7, z8);
        this.f13490d = dVar;
    }

    @Override // b6.E0
    public void B(Throwable th) {
        CancellationException cancellationExceptionD0 = E0.D0(this, th, null, 1, null);
        this.f13490d.cancel(cancellationExceptionD0);
        y(cancellationExceptionD0);
    }

    public final d O0() {
        return this.f13490d;
    }

    @Override // d6.t
    public Object a(Object obj, H5.d dVar) {
        return this.f13490d.a(obj, dVar);
    }

    @Override // d6.s
    public Object b() {
        return this.f13490d.b();
    }

    @Override // b6.E0, b6.InterfaceC1101w0
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new C1103x0(E(), null, this);
        }
        B(cancellationException);
    }

    @Override // d6.t
    public boolean d(Throwable th) {
        return this.f13490d.d(th);
    }

    @Override // d6.s
    public f iterator() {
        return this.f13490d.iterator();
    }

    @Override // d6.s
    public Object j(H5.d dVar) {
        return this.f13490d.j(dVar);
    }

    @Override // d6.t
    public Object k(Object obj) {
        return this.f13490d.k(obj);
    }

    @Override // d6.t
    public void l(Q5.k kVar) {
        this.f13490d.l(kVar);
    }

    @Override // d6.t
    public boolean m() {
        return this.f13490d.m();
    }

    @Override // b6.E0, b6.InterfaceC1101w0
    public /* synthetic */ void cancel() {
        B(new C1103x0(E(), null, this));
    }

    @Override // b6.E0, b6.InterfaceC1101w0
    public final /* synthetic */ boolean cancel(Throwable th) {
        B(new C1103x0(E(), null, this));
        return true;
    }
}
