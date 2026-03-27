package Y6;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s5.InterfaceC2707e;

/* JADX INFO: renamed from: Y6.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1025q extends A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9687c = AtomicIntegerFieldUpdater.newUpdater(C1025q.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public C1025q(InterfaceC2707e interfaceC2707e, Throwable th, boolean z7) {
        if (th == null) {
            th = new CancellationException("Continuation " + interfaceC2707e + " was cancelled normally");
        }
        super(th, z7);
        this._resumed$volatile = 0;
    }

    public final boolean e() {
        return f9687c.compareAndSet(this, 0, 1);
    }
}
