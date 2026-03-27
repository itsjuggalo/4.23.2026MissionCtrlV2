package t3;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: t3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1837s extends C {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15031c = AtomicIntegerFieldUpdater.newUpdater(C1837s.class, "_resumed");
    private volatile int _resumed;

    public C1837s(Z2.e eVar, Throwable th, boolean z4) {
        if (th == null) {
            th = new CancellationException("Continuation " + eVar + " was cancelled normally");
        }
        super(th, z4);
        this._resumed = 0;
    }

    public final boolean c() {
        return f15031c.compareAndSet(this, 0, 1);
    }
}
