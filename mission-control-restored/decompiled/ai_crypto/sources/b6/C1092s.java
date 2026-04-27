package b6;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: b6.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1092s extends C1056C {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9089c = AtomicIntegerFieldUpdater.newUpdater(C1092s.class, "_resumed");
    private volatile int _resumed;

    public C1092s(H5.d dVar, Throwable th, boolean z7) {
        if (th == null) {
            th = new CancellationException("Continuation " + dVar + " was cancelled normally");
        }
        super(th, z7);
        this._resumed = 0;
    }

    public final boolean c() {
        return f9089c.compareAndSet(this, 0, 1);
    }
}
