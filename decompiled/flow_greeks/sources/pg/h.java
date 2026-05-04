package pg;

import java.util.concurrent.CancellationException;
import ng.e2;
import ng.z1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends ng.a implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f18668d;

    public h(gd.i iVar, g gVar, boolean z10, boolean z11) {
        super(iVar, z10, z11);
        this.f18668d = gVar;
    }

    @Override // ng.e2
    public void D(Throwable th) {
        CancellationException cancellationExceptionD0 = e2.D0(this, th, null, 1, null);
        this.f18668d.cancel(cancellationExceptionD0);
        A(cancellationExceptionD0);
    }

    public final g O0() {
        return this.f18668d;
    }

    @Override // pg.w
    public Object a(gd.e eVar) {
        return this.f18668d.a(eVar);
    }

    @Override // pg.w
    public Object b() {
        return this.f18668d.b();
    }

    @Override // ng.e2, ng.y1
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new z1(I(), null, this);
        }
        D(cancellationException);
    }

    @Override // pg.x
    public boolean d(Throwable th) {
        return this.f18668d.d(th);
    }

    @Override // pg.x
    public Object i(Object obj, gd.e eVar) {
        return this.f18668d.i(obj, eVar);
    }

    @Override // pg.w
    public i iterator() {
        return this.f18668d.iterator();
    }

    @Override // pg.x
    public Object l(Object obj) {
        return this.f18668d.l(obj);
    }

    @Override // pg.x
    public void m(pd.k kVar) {
        this.f18668d.m(kVar);
    }

    @Override // pg.x
    public boolean n() {
        return this.f18668d.n();
    }

    @Override // ng.e2, ng.y1
    public /* synthetic */ void cancel() {
        D(new z1(I(), null, this));
    }

    @Override // ng.e2, ng.y1
    public final /* synthetic */ boolean cancel(Throwable th) {
        D(new z1(I(), null, this));
        return true;
    }
}
