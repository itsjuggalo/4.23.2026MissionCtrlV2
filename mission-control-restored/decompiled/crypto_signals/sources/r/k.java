package r;

import N1.P0;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Y1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f9437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f9438b = new j(this);

    public k(i iVar) {
        this.f9437a = new WeakReference(iVar);
    }

    @Override // Y1.b
    public final void a(A.a aVar, P0 p02) {
        this.f9438b.a(aVar, p02);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        i iVar = (i) this.f9437a.get();
        boolean zCancel = this.f9438b.cancel(z6);
        if (zCancel && iVar != null) {
            iVar.f9432a = null;
            iVar.f9433b = null;
            iVar.f9434c.j(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f9438b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f9438b.f9429a instanceof C0958a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f9438b.isDone();
    }

    public final String toString() {
        return this.f9438b.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return this.f9438b.get(j4, timeUnit);
    }
}
