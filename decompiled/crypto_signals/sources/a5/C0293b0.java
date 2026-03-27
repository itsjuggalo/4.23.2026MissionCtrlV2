package a5;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: a5.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0293b0 extends g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4108f = AtomicIntegerFieldUpdater.newUpdater(C0293b0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    public final R4.l e;

    public C0293b0(R4.l lVar) {
        this.e = lVar;
    }

    @Override // a5.g0
    public final boolean j() {
        return true;
    }

    @Override // a5.g0
    public final void k(Throwable th) {
        if (f4108f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
