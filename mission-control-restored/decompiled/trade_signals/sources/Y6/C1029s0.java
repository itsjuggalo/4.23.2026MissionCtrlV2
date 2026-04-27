package Y6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: Y6.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1029s0 extends z0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9690f = AtomicIntegerFieldUpdater.newUpdater(C1029s0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final B5.k f9691e;

    public C1029s0(B5.k kVar) {
        this.f9691e = kVar;
    }

    @Override // Y6.z0
    public boolean v() {
        return true;
    }

    @Override // Y6.z0
    public void w(Throwable th) {
        if (f9690f.compareAndSet(this, 0, 1)) {
            this.f9691e.invoke(th);
        }
    }
}
